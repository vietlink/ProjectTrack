package org.jia.test;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.List;
import junit.framework.TestCase;

/**
 * Utilty methods for unit testing.
 *
 * @author Kito D. Mann
 * @$revision$ $date$
 */

public class Utils
{
    /**
     * Compares the specified list of properties in the two objects. Both
     *  objects must have public methods specified via the getXXX() pattern,
     *  and must be of the same class.
     *
     */
    public static boolean compare(Object o1, Object o2, List properties)
    {
      try
      {
        int numPropertyMatches = 0;

        if (o1 == null && o2 == null)
         return true;

        if (o1 == null || o2 == null ||
            (o1.getClass() != o2.getClass()))
         return false;

        BeanInfo info = Introspector.getBeanInfo(o2.getClass());
        PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
        for (int i = 0; i < descriptors.length; i++)
        {
          if (properties.contains(descriptors[i].getName()))
          {
            numPropertyMatches++;
            Method getMethod = descriptors[i].getReadMethod();
            if (getMethod != null)
            {
              Object value1 = getMethod.invoke(o1, null);
              Object value2 = getMethod.invoke(o2, null);
              if ((value1 != null && value2 != null) &&
                   ((value1 == null && value2 != null) ||
                    (value2 == null && value1 != null) ||
                    (!value1.equals(value2))))
              {
                System.out.println("Different values for property " +
                      descriptors[i].getName() + ": " + value1 + " and " + value2);
                return false;
              }
            }
          }
        }
        if (numPropertyMatches != properties.size())
        {
          System.out.println("All specified properties not found during compare.");
          return false;
        }
      }
      catch (Exception e) { e.printStackTrace(); return false; }

      return true;
    }

    /**
     * Method for testing the value of a property. Really convenient for JavaBeans.
     * You can use it within a test case like so:
     *
     * <pre>
     *     public void testSimpleProperties()
     *     {
     *        Utils.testProperty(myBean, "ID", "ID", true, this);
     *        Utils.testProperty(myBean, "recipientFirstName", "recipientLastName", true, this);
     *        Utils.testProperty(myBean, "contentGrade", "contentGrade", true, this);
     *     }
     * </pre>
     * @param o
     * @param propertyName
     * @param testValue
     * @param shouldBeEqual
     * @param testCase
     * @return
     */
    public static boolean testProperty(Object o, String propertyName,
                                      Object testValue, boolean shouldBeEqual,
                                      TestCase testCase)
    {
      boolean result = false;
      StringBuffer message = new StringBuffer();
      try
      {
        message.append("Testing of property [");
        message.append(propertyName);
        message.append("]: ");
        BeanInfo info = Introspector.getBeanInfo(o.getClass());
        PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
        for (int i = 0; i < descriptors.length; i++)
        {
          if (descriptors[i].getName().equals(propertyName))
          {
            Method setMethod = descriptors[i].getWriteMethod();
            Method getMethod = descriptors[i].getReadMethod();
            if (getMethod != null && setMethod != null)
            {
              setMethod.invoke(o, new Object[] { testValue });
              Object value = getMethod.invoke(o, null);
              if (testValue.equals(value))
              {
                message.append("tested successfully");
                result = true;
                break;
              }
              else
              {
                message.append("failed (test value ");
                message.append(testValue);
                message.append(" != ");
                message.append(value);
                message.append(")");
                result = false;
                break;
              }
            }
            else
            {
              message.append(" not found.");
              result = false;
              break;
            }
          }
        }
      }
      catch (Exception e)
      {
        message.append("failed: ");
        message.append(e.getMessage());
        e.printStackTrace();
        result = false;
      }

      if (!shouldBeEqual)
      {
        result = !result;
      }

      if (testCase != null)
      {
        testCase.assertTrue(message.toString(), result);
      }
      else
      {
        System.out.println(message.toString());
      }

      return result;
    }
}
