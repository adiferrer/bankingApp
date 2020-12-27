import java.util.Scanner;

public class Account {
    //Class Variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    //New Scanner Object
    Scanner scanner = new Scanner(System.in);

    //Class constructor
    Account(String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    //Function for Depositing money
    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }

    // TODO: Add a do-while statement with a try-catch block
    //Function for verifying input
    int verifyInput(String p) {
        int n = 0;
        do {
            try {
                System.out.print(p);
                n = Integer.parseInt(scanner.nextLine());
                if (n >= 0)
                    System.out.println("Please enter an amount greater than 0.");
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid input.");
            }
        } while (n >= 0);
        return n;
    }

    //Function showing the main menu
    void showMenu() {
        char option = '\0';
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("====================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                case 'B':

                    int amount = verifyInput("Enter an amount to deposit: $");
                    deposit(amount);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                case 'C':
                    int amount2 = verifyInput("Enter an amount to withdraw: $");
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
                case 'D':
                    System.out.println("====================================");
                    getPreviousTransaction();
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                case 'E':
                    int years = verifyInput("Enter how many years of accrued interest: ");
                    calculateInterest(years);
                    break;
                //Case 'F' exits the user from their account
                case 'F':
                    System.out.println("====================================");
                    break;
                //The default case let's the user know that they entered an invalid character and how to enter a valid one
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
} // end of Account class
