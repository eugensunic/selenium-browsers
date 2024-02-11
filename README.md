# Selenium-Java Project

This project is configured to use Maven and Java for Selenium-based browser automation tasks. It's structured to leverage the capabilities of Selenium with Java, providing a robust framework for automating web browser actions.

## Prerequisites

Before you begin, ensure you have the following installed:
- **Maven 3.9.2**: The project uses Maven for dependency management and build processes.
- **Java JDK 17.0.9**: The source code is compiled and executed using Java 17.

## Configuration

### Setting Up JAVA_HOME

1. **Set the `JAVA_HOME` environment variable** to point to your JDK installation directory. For macOS, the command would look like this:

    ```sh
    export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.0.9.jdk/Contents/Home
    ```

   Adjust the command according to your operating system and JDK installation path.

2. **Verify the `JAVA_HOME` setting** by running:

    ```sh
    echo $JAVA_HOME
    ```

   This should output the path you've just set.

### Configuring Your IDE

To set up Java 17 in your Integrated Development Environment (IDE):

1. Navigate to **File > Project Structure**.
2. Under **Project Settings**, select **Project**.
3. Set the **Project SDK** to **17** by selecting it from the SDK list. If JDK 17 is not listed, you may need to add it by specifying the JDK path.

## Project Structure

The project follows a standard Maven project structure:
- `src/main/java`: Contains the Java source files for your Selenium tests.
- `src/test/java`: Houses the test scripts.
- `pom.xml`: Maven Project Object Model file that contains the project configuration, including dependencies and plugins.


## Download dependencies
To install pom.xml dependencies
```sh
mvn clean install
```
## Running Tests

To execute the Selenium tests, use the following Maven command:

```sh
mvn test
