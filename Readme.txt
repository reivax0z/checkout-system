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
mvn clean install

(this will compile the code, run the tests and enter in the console interactive mode)

Some limitations and ways to improve:
- Tests have been developed quickly and therefore cover the integration part (the whole process).
- More unit tests should be developed for each scenario and on a class by class basis.
- No real database modelling, just using POJO for quick solution development.
- No interface, and minimal command based interaction.
- Also needs to better handle Exceptions (either from the user part or inside the system).
- The catalogue is unlimited in terms of items being bought.
- No limit on the Cart size.
