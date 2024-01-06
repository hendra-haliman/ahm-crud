This repo contains a Java Springboot CRUD application.

### To run this app, simply:
1. Create database in MariaDB. You may need to customise credentials to suit.
2. Run create.sql against database to populate db with some data.
3. run npm spring-boot:run from command prompt.
4. Go to localhost:8080/ahm in your browser to see it running

### Logging
Logging has been setup to go to /logs folder and console as well. See logback-spring.xml for configuration.

### Configuration
Configuration is defined in application.properties file. You can customised it according to your needs.

### Front end
The front end part is done using Thymeleaf templating engine.