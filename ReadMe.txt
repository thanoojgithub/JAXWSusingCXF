# CXFJAXWS-Service
JAX-WS web service, using Apache CXF

http://localhost:8080/CXFJAXWS-Service-1.0/helloworld?wsdl

jetty:run

The run goal runs on a webapp that does not have to be built into a WAR. Instead, Jetty deploys the webapp from its sources. It looks for the constituent parts of a webapp in the Maven default project locations, although you can override these in the plugin configuration. For example, by default it looks for:

resources in ${project.basedir}/src/main/webapp

classes in ${project.build.outputDirectory}

web.xml in ${project.basedir}/src/main/webapp/WEB-INF/

The plugin automatically ensures the classes are rebuilt and up-to-date before deployment. If you change the source of a class and your IDE automatically compiles it in the background, the plugin picks up the changed class.

You do not need to assemble the webapp into a WAR, saving time during the development cycle. Once invoked, you can configure the plugin to run continuously, scanning for changes in the project and automatically performing a hot redeploy when necessary. Any changes you make are immediately reflected in the running instance of Jetty, letting you quickly jump from coding to testing, rather than going through the cycle of: code, compile, reassemble, redeploy, test.

Here is a small example, which turns on scanning for changes every ten seconds, and sets the webapp context path to /test:

<plugin>
  <groupId>org.eclipse.jetty</groupId>
  <artifactId>jetty-maven-plugin</artifactId>
  <version>9.3.7.v20160115</version>
  <configuration>
    <scanIntervalSeconds>10</scanIntervalSeconds>
    <webApp>
      <contextPath>/test</contextPath>
    </webApp>
  </configuration>
</plugin>
      
Configuration

In addition to the webApp element that is common to most goals, the jetty:run goal supports:

classesDirectory
Location of your compiled classes for the webapp. You should rarely need to set this parameter. Instead, you should set build outputDirectory in your pom.xml.

testClassesDirectory
Location of the compiled test classes for your webapp. By default this is ${project.build.testOutputDirectory}.

useTestScope
If true, the classes from testClassesDirectory and dependencies of scope "test" are placed first on the classpath. By default this is false.

webAppSourceDirectory
By default, this is set to ${project.basedir}/src/main/webapp. If your static sources are in a different location, set this parameter accordingly.




jetty:run-war

This goal first packages your webapp as a WAR file and then deploys it to Jetty. If you set a non-zero scanInterval, Jetty watches your pom.xml and the WAR file; if either changes, it redeploys the war.

Configuration
war
The location of the built WAR file. This defaults to ${project.build.directory}/${project.build.finalName}.war. If this is not sufficient, set it to your custom location.

<project>
... 
  <plugins>
...
    <plugin>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-maven-plugin</artifactId>
      <version>9.3.7.v20160115</version>
      <configuration>
        <war>${project.basedir}/target/mycustom.war</war>
      </configuration>
    </plugin>
  </plugins>
</project>