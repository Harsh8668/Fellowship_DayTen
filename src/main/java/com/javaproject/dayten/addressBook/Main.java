package com.javaproject.dayten.addressBook;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<UserInterface> addressArray = new ArrayList<UserInterface>();

    public static void main(String[] args) {
        Main main = new Main();
        int option = 0;
        while (option != 5) {
            option = main.showMainMenu(option);
            main.handleUserSelection(option);
        }
    }

    //Option to be choosen for the activity
    public int showMainMenu(int option) {
        System.out.println("Choose an option : \n 1. Add Contact \n 2. Display \n " +
                "3. Delete \n 4. Edit \n 5. Exit");
        return (sc.nextInt());
    }

    public void handleUserSelection(int option) {
        switch (option) {
            case 1:
                addContact();
                break;
            case 2:
                displayContact();
                break;
            case 3:
                deleteContact();
                break;
            case 4:
                editContact();
                break;
            case 5:
                break;
            default:
                System.out.println("Invalid option");
        }
    }


    //Adding the contacts
    private void addContact() {
        UserInterface ui = new UserInterface();
        System.out.println("Enter your First name");
        String firstName = sc.next();
        ui.setFirstName(sc.next());
        System.out.println("Enter your Last name");
        String lastName = sc.next();
        ui.setLastName(sc.next());
        System.out.println("Enter your Address");
        String address = sc.next();
        ui.setAddress(sc.next());
        System.out.println("Enter your City");
        String city = sc.next();
        ui.setCity(sc.next());
        System.out.println("Enter your State");
        String state = sc.next();
        ui.setState(sc.next());
        System.out.println("Enter your Email address");
        String email = sc.next();
        ui.setEmail(sc.next());
        System.out.println("Enter your Zip Code");
        int zipCode = sc.nextInt();
        ui.setZipCode(sc.nextInt());
        System.out.println("Enter your Phone number");
        int phoneNumber = sc.nextInt();
        ui.setPhoneNumber(sc.nextInt());

        addressArray.add(ui);
        UserInterface person1 = new UserInterface(firstName, lastName, address, city,
                state, email, zipCode, phoneNumber);
        addressArray.add(person1);
        System.out.println(addressArray);
        System.out.println("Contact Added Successfully");
    }

    //Displaying the contacts
    private void displayContact() {
        for (int i = 0; i < addressArray.size(); i++) {
            UserInterface user = addressArray.get(i);
            System.out.println();
            System.out.println("FirstName" + ":=" + user.getFirstName() + "\n" + "lastname" + ":= " + user.getLastName() + "\n" +
                    "Address" + ":= " + user.getAddress() + "\n" + "City" + ":= " + user.getCity() + "\n" +
                    "State" + ":=" + user.getState() + "\n" + "Zip" + ":= " + user.getZipCode() + "\n" +
                    "PhoneNumber" + ":= " + user.getPhoneNumber() + "\n" + "Email" + ":= " + user.getEmail());
        }
    }


    //Deleting the contacts
    private void deleteContact() {
        System.out.println("Enter the name to delete the contact");
        String name = sc.next();
        for (int i = 0; i < addressArray.size(); i++) {
            if (addressArray.get(i).getFirstName().equalsIgnoreCase(name)) {
                UserInterface ui = addressArray.get(i);
                addressArray.remove(ui);
            }
        }
        System.out.println(addressArray);
    }


    //Editing the contacts
    private void editContact() {
        System.out.println("Enter a name:");
        String name = sc.next();
        for (int i = 0; i < addressArray.size(); i++) {
            if (addressArray.get(i).getFirstName().equalsIgnoreCase(name)) {
                System.out.println("select options");
                System.out.println("\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip\n7.Phone Number\n8.Email");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter a First name:");
                        String editFirstName = sc.next();
                        addressArray.get(i).setFirstName(editFirstName);
                        System.out.println(editFirstName);
                        break;
                    case 2:
                        System.out.print("Enter a Last name:");
                        addressArray.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.print("Enter a Address:");
                        addressArray.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.print("Enter a city:");
                        addressArray.get(i).setCity(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter a state:");
                        addressArray.get(i).setState(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("Enter a zip code:");
                        addressArray.get(i).setZipCode(sc.nextInt());
                        break;
                    case 7:
                        System.out.print("Enter a phone number:");
                        addressArray.get(i).setPhoneNumber(sc.nextLong());
                        break;
                    case 8:
                        System.out.print("Enter a email:");
                        addressArray.get(i).setEmail(sc.nextLine());
                        break;
                    default:
                        System.out.println("enter valid contact");
                }
            }
            System.out.println("Edited list is:");
            System.out.println(addressArray);
        }
    }
}
