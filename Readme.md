Simple application to checkout items for a store.
===

Libraries
---
Using Java 1.8 and Maven/Gradle for compilation and running test suite.
The main libraries used are:
- JUnit for tests
- Spring + Spring MVC
- Fasterxml for JSON representation
- AngularJS
- Swagger for Rest API documentation
- Tomcat7 plugin (Maven)
- Jetty plugin (Gradle)

Introduction
---
The interface shows a Stock content and the current state of the Cart.
Users can add Items to the Cart and the total Price is automatically adjusted using the discount rules.
This is done by exposing REST services accessed directly through AngularJS.

Architecture
---
Separated the code into:
- checkout (containing the checkout service and the pricing rules / engine)
- model (containing the Stock and its Items as well as the Cart)
- offer (various methods of giving discounts to customers)
- util (constants and exceptions)
- controller (containing the REST exposed services)

The test suite is located in the test package.

Installation and Deployment
---

**MAVEN**

To deploy the program:
 mvn clean install

(this will compile the code and run the tests)

To launch the app on a local server:
 mvn tomcat7:run

**GRADLE**

To launch the app on a local server:
 gradle jettyRun


Accessible URLs
---

- The app will be running on: http://localhost:8080/checkout-webapp
- The Swagger API documentation accessible on: http://localhost:8080/checkout-webapp/v2/api-docs
- The Swagger UI documentation accessible on: http://localhost:8080/checkout-webapp/swagger-ui.html


Improvements
---
Some limitations and ways to improve:
- Tests have been developed quickly and therefore cover the integration part (the whole process).
- No real database modelling, just using POJO for quick solution development.
- The catalogue is unlimited in terms of items being bought.
- No limit on the Cart size.
