Simple application to checkout items for a store.

Using Java 1.7 and Maven for compilation and running test suite.
The only library used is JUnit for test purposes.

Separated the code into:
- checkout (containing the checkout service and the pricing rules / engine)
- model (containing the Catalogue and its Items)
- offer (various methods of giving discounts to customers)
- util (constants and exceptions)

The test suite is located in the test package.

To deploy the program:
maven clean install

(this will compile the code, run the tests and enter in the console interactive mode)