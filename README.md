### Welcome

Welcome to Carteira Livre, an open source android app to track your daily expendings with privacy.

### Contribution guidelines

Feel free to contribute. Just please, practice Test Driven Development.

#### Test and build

In order to run the tests, on the root folder, type:
```
./gradlew testBrDebugUnitTest
```
A report will be generated on app/build/reports/tests/brDebug/index.html

To create a test coverage report, type:
```
./gradlew testBrDebugUnitTestCoverage
```
The output will be on app/build/reports/testBrDebugUnitTestCoverage/index.html

To build the .apk, type:
```
./gradlew assembleBr
```
Check the file app-br-release-unsigned.apk on folder app/build/outputs/apk

#### Naming Conventions

- **Compartment** - Each part of the wallet used to store money; A pocket to keep money separated for different purposes.

- **Transaction** - means a money transfer on the wallet. They can be both incomes or expenses.

- **Category** - A group of similar expenses. Entertainment and transportation are examples of category.

- **Event** - a set of changes on the wallet that can be published on an public URL.
