Simple application to checkout items for a store.

Using Java 1.8 and Maven for compilation and running test suite.
The main libraries used are:
- JUnit for tests
- Spring + Spring MVC
- Fasterxml for JSON representation
- AngularJS
- Tomcat7 plugin

The interface shows a Catalogue content and the current state of the Cart.
Users can add Items to the Cart and the total Price is automatically adjusted using the discount rules.
This is done by exposing REST services accessed directly through AngularJS.

Separated the code into:
- checkout (containing the checkout service and the pricing rules / engine)
- model (containing the Catalogue and its Items as well as the Cart)
- offer (various methods of giving discounts to customers)
- util (constants and exceptions)
- controller (containing the REST exposed services)

The test suite is located in the test package.

To deploy the program:
mvn clean install

(this will compile the code and run the tests)

To launch the app on a local server:
mvn tomcat7:run

Some limitations and ways to improve:
- Tests have been developed quickly and therefore cover the integration part (the whole process).
- No real database modelling, just using POJO for quick solution development.
- The catalogue is unlimited in terms of items being bought.
- No limit on the Cart size.
