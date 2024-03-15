# RMI-Add_and_Count

This repository contains a Java RMI (Remote Method Invocation) application that demonstrates a simple remote service for performing basic operations. These operations include adding numbers from 1 to a given number and counting the occurrence of a specified character in a string.

## Features

- **Add Operation**: Sums numbers from 1 up to a specified number, ensuring the number is within a predefined range (0 to 1000).
- **Count Operation**: Counts the occurrences of a specific character within a given string.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Basic knowledge of Java and RMI

### Installing

1. **Clone the Repository**
    ```git
    git clone https://github.com/ismailza/RMI-Add_and_Count.git
    ```

2. **Compile the Java Files**

    Navigate to the project directory and compile the Java files.

    ```
    javac ma/fstm/ilisi/rmiaddandcount/**/*.java
    ```

3. **Start the Server**
    
    In a new terminal window, run the server:

    ```
    java ma.fstm.ilisi.rmiaddandcount.server.Server
    ```

4. **Run the Client**
    
    Open another terminal window and run the client:

    ```
    java ma.fstm.ilisi.rmiaddandcount.client.Client
    ```

    Follow the prompts to interact with the remote service.


## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
