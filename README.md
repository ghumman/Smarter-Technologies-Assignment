# Package Sorting – Technical Screen

This project implements a simple sorting function for a robotic automation factory.

The function determines whether a package should be dispatched to:

* **STANDARD**
* **SPECIAL**
* **REJECTED**

---

## Rules

A package is considered:

* **Bulky** if:

  * Volume ≥ 1,000,000 cm³
  * OR any dimension ≥ 150 cm

* **Heavy** if:

  * Mass ≥ 20 kg

### Dispatch Logic

* Bulky + Heavy → **REJECTED**
* Bulky only → **SPECIAL**
* Heavy only → **SPECIAL**
* Neither → **STANDARD**

---

## Tech Stack

* Java
* <a href="https://junit.org/junit5/">JUnit 5</a>

---

## How to Run

1. Clone the repository
2. Open in your preferred IDE (e.g., <a href="https://www.jetbrains.com/idea/">IntelliJ IDEA</a>)
3. Run `PackageSorter.main()`
4. Run `PackageSorterTest` to execute unit tests

Or using Maven:

```bash
mvn test
```

---

## Structure

```
src/
 ├── main/java/PackageSorter.java
 └── test/java/PackageSorterTest.java
```
