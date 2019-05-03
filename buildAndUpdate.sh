mvn install -DskipTests=true
ibmcloud fn action update GetAllBlogEntries target/spring-openwhisk-jpa-sample.jar --main com.ibm.openwhisk.spring.GetAllBlogEntries
ibmcloud fn action invoke GetAllBlogEntries -b

# java -cp target/spring-test2.jar com.ibm.openwhisk.spring.CommandLineRunner
