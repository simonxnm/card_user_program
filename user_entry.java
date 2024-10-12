package card_user_entrance;

import java.util.Scanner;

public class user_entry {

    static String crdNum = "DE24541511283298771";
    static String pass = "techPRO25";

    static double balance = 500.0;


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        boolean verify = false;
        int counter = 0;
        while ((!verify && counter < 3)) {

            System.out.println("Please enter card number ");
            String cardNumber = input.nextLine().replaceAll(" ", "");
            System.out.println("please enter password ");
            String password = input.nextLine();
            cardNumber = cardNumber.replaceAll(" ", "");


            if (cardNumber.equalsIgnoreCase(crdNum) || password.equalsIgnoreCase(pass)) {

                verify = true;


            } else {
                counter++;
                System.out.println("Invalid card number or password. Try again.");

            }
        }

        if (!verify) {
            System.out.println("Your account is blocked. Please contact your bank.");
            return; // Programı sonlandır
        }

        boolean exit = false;
        while (!exit) {


            System.out.println("select an action :");
            System.out.println("Check Balance 1");
            System.out.println("Deposit 2");
            System.out.println("Withdrow 3");
            System.out.println("Send Money 4");
            System.out.println("Change Passwort 5");
            System.out.println("EXIT 6");


            int choice = input.nextInt();
            input.nextLine();


            switch (choice) {
                case 1:
                    balance();
                    break;
                case 2:
                    deposit(input);
                    break;
                case 3:
                    withdraw(input);
                    break;
                case 4:
                    sendMoney(input);
                    break;
                case 5:
                    changePassword(input);

                    break;
                case 6:
                    System.out.println("EXIT");
                    exit = true;
                    System.exit(0);
                default:
                    System.out.println("Please try again later. ");
            }

        }
        input.close();
    }


    static void balance() {
        System.out.println("Current balance: " + balance + " €");

    }

    static void deposit(Scanner input) {

        System.out.println("Enter the amount you wish to deposit:");
        double wishDeposit = input.nextDouble();
        balance += wishDeposit;
        System.out.println(wishDeposit + " € deposited. Current balance: " + balance + " €");

    }

    static void withdraw(Scanner input) {
        System.out.println("Enter money you want to withdraw");

        double withdrowMoney = input.nextDouble();
        if (withdrowMoney > balance) {
            System.out.println("Insufficent funds ");
        } else {
            balance -= withdrowMoney;
            System.out.println(withdrowMoney + "€ was withdrawn. Current balance:" + balance + " €");
        }
    }

    static void sendMoney(Scanner input) {

        System.out.println("Enter the IBAN you want to send money to:");

        String iban = input.nextLine();

        if (!iban.startsWith("DE") || iban.length() != 26) {
            System.out.println("Invalid IBAN. Please go back to the menu.");
        } else {
            System.out.println("Enter the amount you wish to send:");
            double sendAmount = input.nextDouble();
            if (sendAmount > balance) {
                System.out.println("Insufficient funds");
            } else {
                balance -= sendAmount;
                System.out.println(sendAmount + " € has been sent. Current balance: " + balance + " €");
            }
        }
    }


    static void changePassword(Scanner input) {

        System.out.println("Enter your current password: ");
        String currentPassword = input.nextLine();
        if (currentPassword.equals(pass)) {
            System.out.println(" Enter your new password: ");
            // input.nextLine();
            String newPassword = input.nextLine();
            pass = newPassword;
            System.out.println("password is successfully changed");
        } else {
            System.out.println("Current password is false. ");
        }
    }
}





