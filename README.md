# Design Patterns in Test Automation: Scalability & Maintainability

This project is a comprehensive implementation of various **Software Design Patterns** applied specifically to **Test Automation**. The goal was to demonstrate how architectural patterns can solve common problems like code duplication, brittle tests, and high maintenance costs in large-scale automation frameworks.

## Tech Stack
* **Language:** Java 11+
* **Framework:** Selenium WebDriver / Selenide
* **Build Tool:** Maven 
* **Test Runner:** TestNG 

## Implemented Patterns & Use Cases

### 1. Creational Patterns
* **Factory Pattern:** Centralized WebDriver creation logic to support cross-browser testing (Chrome, Firefox, Safari) without hardcoding logic into tests.
* **Builder Pattern:** Used for creating complex test data objects (e.g., User profiles, Order details), making tests more readable and fluently written.

### 2. Structural Patterns
* **Decorator Pattern:** Implemented to handle dynamic UI elements based on user roles (e.g., adding "Admin" specific checks to a standard Page Object).
* **Proxy Pattern:** Utilized for environment-specific actions, such as bypassing certain steps in Production while executing them in QA.

### 3. Behavioral Patterns
* **Strategy Pattern:** Decoupled search behaviors (e.g., Voice Search vs. Text Search) to allow switching logic at runtime without `if-else` blocks.
* **Command Pattern:** Encapsulated complex UI sequences into standalone objects, useful for logging and retrying multi-step business flows.
* **Template Method:** Defined a standard workflow for "Booking" scenarios, allowing specific implementations (Hotel vs. Car) to override only necessary steps.

### 4. Design Principles
* **Single Responsibility Principle (SRP):** Refactored monolithic Page Objects into small, reusable **Page Components**.
* **Execute Around Method:** Used to handle repetitive setup/teardown tasks (like file I/O or DB connections) consistently.
