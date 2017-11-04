1. add dependencies in pom.xml
2. mvn dependency:tree
3. write the program
4. mvn package -Dmaven.test.skip=true
5. java -Dspring.datasource.initialize=false -jar target/spring-boot-jdbc-1.0.jar insert newUser newPassword
6. java -Dspring.datasource.initialize=false -jar target/spring-boot-jdbc-1.0.jar display

7. The application is now converted to read choice from user to add / display. The current application is using mysql db backend. Properties must be updated according to your mysql db.

8. The application is now converted to a web app. The restTemplate is introduced. "Display" end point works currently.

9. Trying to setup Junit. 
