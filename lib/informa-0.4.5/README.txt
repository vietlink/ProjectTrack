================================================================
Thirdparty libraries used by Informa
$Id: README.txt,v 1.15 2003/10/13 19:58:10 niko_schmuck Exp $
================================================================


  o jdom.jar (b9)
    - Convient XML handling in Java
    - buildtime (required)
    - Homepage: http://www.jdom.org/
    - License: BSD/Apache style

  o commons-logging (1.0.3)
    - buildtime (required)
    - Homepage: http://jakarta.apache.org/commons/logging.html
    - License: Apache Software License

  o log4j.jar (1.2.8)
    - Logging framework
    - runtime (optional)
    - Homepage: http://jakarta.apache.org/log4j/
    - License: Apache Software License

  o lucene.jar (1.2)
    - Full-text search engine
    - buildtime (required), runtime (optional)
    - Homepage: http://jakarta.apache.org/lucene/
    - License: Apache Software License

  o hibernate2.jar (2.0.3)
    - Object-Relational Mapping tool
    - runtime (optional)
    - Homepage: http://hibernate.sourceforge.net/
    - License: Lesser General Public License (LGPL)

  o cglib-asm.jar (1.0 final)
    - Bytecode generator
    - runtime (needed by hibernate)
    - Homepage: http://cglib.sourceforge.net/
    - License: Apache Software License

  o commons-beanutils.jar (1.6)
    - runtime (needed by hibernate)
    - Homepage: http://jakarta.apache.org/commons/beanutils.html
    - License: Apache Software License

  o commons-collections.jar (2.1)
    - runtime (needed by hibernate)
    - Homepage: http://jakarta.apache.org/commons/collections.html
    - License: Apache Software License

  o commons-lang.jar (1.0.1)
    - runtime (needed by hibernate)
    - Homepage: http://jakarta.apache.org/commons/lang.html
    - License: Apache Software License

  o dom4j.jar (1.4)
    - XML configuration and mapping parser
    - runtime (needed by hibernate)
    - Homepage: http://dom4j.sourceforge.net/
    - License: BSD License

  o odmg.jar (3.0)
    - ODMG API 3.0
    - runtime (optionally needed by hibernate)
    - Homepage: http://www.odmg.org/
    - License: Object Data Management Group

  o junit.jar (3.7)
    - JUnit test framework
    - buildtime, test-runtime
    - Homepage: http://www.junit.org/
    - License: Common Public License

  o checkstyle-all.jar (2.2)
    - Java source code style analyser
    - runtime (optional)
    - Homepage: http://sourceforge.net/projects/checkstyle/
    - License: LGPL
    - Note: Contains also classes from antlr.jar and jakarta-regexp-1.2.jar
    
  o hsqldb.jar (1.7.1)
    - HypersonicSQL database
    - runtime (optionally needed by hibernate)
    - Homepage: http://hsqldb.sourceforge.net/
    - License: BSD License

  o mysql.jar (3.0.8)
    - MySQL JDBC Driver (works with MySQL Server 4.0.x)
    - runtme (optional)
    - Homepage: http://www.mysql.com/downloads/api-jdbc.html
    - License: GPL

  o postgresql.jar (7.3.2)
    - PostgreSQL JDBC (Level 3) Driver
    - runtime (optional)
    - Homepage: http://jdbc.postgresql.org/
    - License: GPL

  o xdoclet.jar                   (1.2b3)
  o xdoclet-hibernate-module.jar
  o xdoclet-xdoclet-module.jar
  o xjavadoc.jar 
    - code generation engine using javadoc
    - runtime (optional, needed in conjunction with hibernate)
    - Homepage: http://xdoclet.sourceforge.net/
    - License: BSD License


  o castor.jar (0.9.4.3)
    - Persistence framework (XML and JDO-like)
    - Warning: The Castor backend for informa is experimental
    - runtime (optional)
    - Homepage: http://castor.exolab.org/
    - License: BSD/Apache style

  o castor-doclet.jar (0.4.1)
    - Castor Doclet
    - buildtime (optional)
    - Homepage: http://castordoclet.sourceforge.net/
    - License: Lesser General Public License (LGPL)

  o jta.jar (1.0.1)
    - Standard JTA API
    - runtime (optional, needed by Castor)
    - Homepage: http://java.sun.com/products/jta/
    - License: Sun
    
  o xerces.jar (1.4.4)
    - SAX parser
    - runtime (optional, needed by Castor)
    - Homepage: http://xml.apache.org/xerces-j/
    - License: Apache Software License
