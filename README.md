# Login Automation with Selenium + TestNG

This project automates login form testing for:
👉 https://the-internet.herokuapp.com/login

## ✅ Features
- Java + Selenium WebDriver + TestNG
- Valid / Invalid login test cases
- Empty field validation
- CSV Data-driven testing (bonus)
- Maven for dependency management

## 🛠️ Setup

### Prerequisites
- Install Java 11+  
- Install Maven  
- Install Git  
- IDE: Eclipse / IntelliJ recommended  

### Clone & Build
```bash
git clone https://github.com/your-username/LoginAutomation.git
cd LoginAutomation
mvn clean install
```

### Run Tests
Run all tests:
```bash
mvn test
```
Run with TestNG suite:
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

## 📂 Structure
```
LoginAutomation/
 ├── pom.xml
 ├── testng.xml
 ├── README.md
 ├── src/test/java/testCases/LoginTest.java
 ├── src/test/java/testCases/LoginDataDrivenTest.java
 ├── src/test/resources/loginData.csv
```

## ✅ Test Cases
1. Valid login → success  
2. Invalid login → error message  
3. Empty fields → error message  
4. Data-driven → read from CSV  
