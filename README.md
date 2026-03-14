# selenium-orangehrm-demo 
Demo Project for Selenium with Java and TestNG

This project is a demonstration of using Selenium WebDriver with Java and TestNG to automate testing of the OrangeHRM application. It includes test cases for login functionality, employee management, and other features of the OrangeHRM system.

# 🧪 QA Automation Portfolio — Carla González

> Senior QA Engineer | Automation with Selenium + Java + TestNG | HealthTech Specialist

---

## 👩‍💻 About

This portfolio showcases my automation testing projects as I transition from Senior Manual QA to QA Automation Engineer. Each project is built with real-world scenarios and industry best practices.

📍 Hermosillo, Mexico  
🔗 [LinkedIn](https://www.linkedin.com/in/carla-dolores-gonzález-gámez-22b990100)  
💼 Currently: Senior QA Engineer @ 3Pillar Global

---

## 📁 Projects

### 1. 🟠 OrangeHRM — Login & User Management Automation
**Status:** ✅ Complete  
**Stack:** Java · Selenium WebDriver · TestNG · Page Object Model

Automated test suite for OrangeHRM demo application covering authentication flows and user management.

**Test Coverage:**
- ✅ Valid login with correct credentials
- ✅ Invalid login — wrong password
- ✅ Invalid login — wrong username
- ✅ Logout flow
- ✅ Create new user via Admin panel

**Key Patterns Used:**
- Page Object Model (POM) for maintainability
- TestNG for test execution and assertions
- Screenshot capture on test failure
- Maven for dependency management

**How to Run:**
```bash
# Clone the repo
git clone https://github.com/carladgg/qa-portfolio-carladgg26.git

# Run all tests
mvn test
mvn clean test -Dheadless=true
mvn clean test -Dheadless=false

# Run specific test
mvn -Dtest=LoginTest#loginWithValidCredentialsShowsDashboard test
```

**Requirements:** Java 17+ · Maven · Chrome Browser

---

### 🔜 Coming Soon

| Project | Stack | Status |
|---------|-------|--------|
| HL7 Message Validation | Selenium + Java + BDD Cucumber | 🔄 In Progress |
| API Testing Suite | Postman + Newman + GitHub Actions | 📅 Planned |
| E2E HealthTech Flow | Cypress + CI/CD | 📅 Planned |
| AI-Assisted Test Generation | Claude Code + Selenium | 📅 Planned |

---

## 🛠️ Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=flat)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub_Actions-2088FF?style=flat&logo=github-actions&logoColor=white)

---

## 📜 Certifications

- 🎓 Claude 101 — Anthropic Academy *(March 2026)*
- 🎓 AI Fluency: Framework & Foundations — Anthropic *(Coming soon)*
- 🎓 Selenium WebDriver with Java — Udemy *(Coming soon)*

---

