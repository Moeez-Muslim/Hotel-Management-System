# Hotel-Management-System
This Java program implements a Hotel Management System allowing users to manage rooms, customers, bookings, and bills. The system supports features such as adding rooms, making bookings, checking in/out, viewing available rooms, and managing customer accounts.

## Table of Contents

- [Code Structure](#code-structure)
- [How to Use](#how-to-use)
- [Menu Options](#menu-options)
- [Important Notes](#important-notes)
- [Contributing](#contributing)
- [License](#license)

## Code Structure

The code is organized into several classes within the `com.example.task2` package:

1. **Customer**: Represents a hotel customer with a name and CNIC (Computerized National Identity Card).
2. **Room**: Represents a hotel room with a unique room number, price per day, and reservation status.
3. **Bill**: Represents a bill item with a description and price.
4. **Booking**: Manages the booking details, including the date, associated room, customer information, bill items, and check-in status.
5. **Hotel**: Implements the main Hotel class, which includes methods for adding rooms, managing customers, making bookings, and handling user interactions through the console.
6. **Main**: The entry point of the program, containing the main method to execute the Hotel Management System.

## Getting Started

### Prerequisites

Before you start, ensure you have [Java](https://www.java.com/en/download/) installed on your machine.

### Clone the Repository

```bash
git clone https://github.com/Moeez-Muslim/Hotel-Management-System.git
cd Hotel-Management-System

## How to Use

1. **Compile**: Compile the Java files using a Java compiler.

   ```bash
   javac com/example/task2/*.java
   ```

2. **Run the Program**: Run the compiled program with the `Main` class.

   ```bash
   java com.example.task2.Main
   ```

## Menu Options

The program offers a simple console-based user interface with the following menu options:

1. **Add Rooms (Option 1)**: Add new rooms to the hotel.
2. **Get Available Rooms (Option 2)**: Display available rooms for booking.
3. **Search Guest (Option 3)**: Search for a guest by CNIC and view their bookings.
4. **Add Guest (Option 4)**: Register a new customer.
5. **Log into Guest Account (Option 5)**: Log into a customer account to make bookings and view bills.
6. **Exit (Option 6)**: Exit the program.

## Important Notes

- Dates are entered in "YYYY-MM-DD" format.
- The system supports booking rooms, checking in/out, viewing bills, and managing customer accounts.
- Feel free to explore and modify the code to enhance or customize the functionalities according to your requirements.

## Contributing

If you'd like to contribute to this project, please open an issue or submit a pull request. Contributions are welcome!

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify the code as needed.
