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

### 1. 🟠 OrangeHRM — Login, Employee & User Management Automation
**Status:** 🔄 In Progress — Employee Details module coming next
**Stack:** Java · Selenium WebDriver · TestNG · Page Object Model

Automated test suite for OrangeHRM demo application covering authentication flows, employee creation/deletion, and user management. Tests run both headless and with UI via Maven flag.

**Test Coverage (7 test cases — all passing ✅):**
- ✅ Valid login with correct credentials
- ✅ Invalid login — wrong password
- ✅ Invalid login — wrong username
- ✅ Logout flow
- ✅ Create employee (PIM module)
- ✅ Create Admin user linked to that employee
- ✅ Delete user (Admin panel)
- ✅ Delete employee (PIM module)
- 🔄 Employee Details — *coming next*

**Execution Order (dependency-aware):**
1. Login tests → 2. Logout → 3. Create Employee → 4. Create User → 5. Delete User → 6. Delete Employee

**Key Patterns Used:**
- Page Object Model (POM) for maintainability
- TestNG for test execution, ordering, and assertions
- Screenshot capture on test failure (TestListener)
- Employee ID override with `currentTimeMillis` to avoid conflicts on the shared public demo site (auto-generated IDs collide with other users)
- Race-condition-safe XPath (row-scoped selectors) for search result tables
- Vue.js autocomplete handling (type-for-hints + suggestion click + attribute wait)
- Headless / UI mode toggle via Maven system property
- Maven Surefire Plugin for suite execution

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

## 🤝 Built with AI Collaboration

This project was developed in pair-programming style with **Claude Code** (Anthropic), an AI coding assistant used directly in the terminal.

Working alongside Claude Code, I was able to:
- Diagnose tricky Selenium timing issues and race conditions
- Debug Vue.js autocomplete binding behavior
- Identify XPath selector failures from test screenshots
- Iterate quickly on Page Object design

> *"Same team, different nature."* — Carla + Claude Code

---

## 📜 Certifications

- ✅ Claude 101 — Anthropic Academy *(March 2026)*
- 🔄 AI Fluency: Framework & Foundations — Anthropic *(In Progress)*
- 📅 Selenium WebDriver with Java — Udemy *(Planned)*

---

