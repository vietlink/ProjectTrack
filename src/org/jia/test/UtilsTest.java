package org.jia.test;

import java.util.ArrayList;
import java.util.List;
import junit.framework.*;

/**
 * Test Case for the Utils static class.
 *
 * @author Kito D. Mann
 * @version $revision$ $date$
 */

public class UtilsTest extends TestCase
{
    protected class TestBean1
    {
        private Object property;
        public TestBean1() {}
        public void setProperty(Object property)
        {
          this.property = property;
        }

        public Object getProperty()
        {
          return property;
        }
    }

    protected class TestBean2
    {
        private Object foo;
        private Object bar;

        public TestBean2() {}
        public void setProperty(Object foo)
        {
          this.foo = foo;
        }

        public Object getProperty()
        {
          return foo;
        }

        public void setBar(Object foo)
        {
          this.foo = foo;
        }

        public Object getBar()
        {
          return bar;
        }
    }

    protected TestBean1 bean1;
    protected TestBean2 bean2;

    public UtilsTest(String name)
    {
      super(name);
    }

    public void setUp() throws Exception
    {
      super.setUp();
      bean1 = new TestBean1();
      bean2 = new TestBean2();
    }

    public static Test suite()
    {
      return new TestSuite(UtilsTest.class);
    }

    public static void main(String args[])
    {
      junit.textui.TestRunner.run(suite());
    }

    public void testCompare()
    {
      bean1.setProperty("foo");
      TestBean1 bean3 = new TestBean1();
      bean3.setProperty("foo");

      List props = new ArrayList();
      props.add("property");

      assertTrue(Utils.compare(bean1, bean3, props));

      bean3.setProperty("foo");
      bean1.setProperty("blah");
      assertTrue(!Utils.compare(bean1, bean3, props));
    }

    public void testTestProperty()
    {
       Utils.testProperty(bean1, "property", "foo", true, this);
       Utils.testProperty(bean1, "propertys", "foo", false, this);
       Utils.testProperty(bean1, "property", new Object(), true, this);
       Utils.testProperty(bean2, "bar", "foo", false, this);
       assertTrue(Utils.testProperty(bean1, "property", "blah", true, null));
       Utils.testProperty(bean1, "property", "abal", true, null);
    }

}
