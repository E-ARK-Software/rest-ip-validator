# rest-ip-validator
REST web services and client for E-ARK Information Package validation

## Getting Started

### Pre-requisites
- [Java 8](https://java.com/download) JDK or higher as runtime environment;
- [Apache Maven](https://maven.apache.org/) to build and package the project

### Build and run
```
# Clone the repo locally and move into it
git clone git@github.com:DILCISBoard/rest-ip-validator.git
cd rest-ip-validator

# Use Maven to compile and package server
mvn clean package

# Run the package server using the supplied configuration file
java -jar app-server/target/rest-server-0.0.1-SNAPSHOT.jar server app-server/eark-validator.yml
```
If all's well you should see something like:
```
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!    THIS APPLICATION HAS NO HEALTHCHECKS. THIS MEANS YOU WILL NEVER KNOW      !
!     IF IT DIES IN PRODUCTION, WHICH MEANS YOU WILL NEVER KNOW IF YOU'RE      !
!    LETTING YOUR USERS DOWN. YOU SHOULD ADD A HEALTHCHECK FOR EACH OF YOUR    !
!         APPLICATION'S DEPENDENCIES WHICH FULLY (BUT LIGHTLY) TESTS IT.       !
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
INFO  [2018-08-07 11:42:20,435] org.eclipse.jetty.server.handler.ContextHandler: Started i.d.j.MutableServletContextHandler@40729f01{/,null,AVAILABLE}
INFO  [2018-08-07 11:42:20,442] org.eclipse.jetty.server.AbstractConnector: Started application@387bf2d9{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
INFO  [2018-08-07 11:42:20,443] org.eclipse.jetty.server.AbstractConnector: Started admin@74aa9c72{HTTP/1.1,[http/1.1]}{0.0.0.0:8081}
INFO  [2018-08-07 11:42:20,443] org.eclipse.jetty.server.Server: Started @1608ms
```
Then the server is up and running. To see the local client go to: http://localhost:8080 
