# Employee Portal


**Prerequisites:** [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [MySQL](https://dev.mysql.com/downloads/mysql/) and [Node.js](https://nodejs.org/).

* [Getting Started](#getting-started)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone https://github.com/sangeet4/employee-portal.git
cd employee-portal
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

For first-time setup, create a MySQL database `employee`, user named `employeePortal` with password as `employeePassword_db` and grant all permisions to the user. *It is not advisable though to grant all permissions in production environment. You can revoke all permissions after running application for the first time and then grant only those permissions which are required.*

To run the backend, cd into the `employee-portal-service` folder and run:
 
```bash
./mvnw spring-boot:run
```

To run the frontend, cd into the `employee-portal-fe` folder and run:
 
```bash
npm install && npm start
```

To explore api-documentations *after starting backend server*, you can visit [Swagger UI](http://localhost:8080/api/v2/swagger-ui.html).

## Help

Please post any questions as comments.

## License

Apache 2.0, see [LICENSE](LICENSE).
