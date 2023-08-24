// Tsampiras Konstantinos, AM 4508, cse84508

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


class SEP 
{
    public static void main (String[] args) 
    {
    	// Required Attributes
        ArrayList<Room> rooms = new ArrayList<Room>();
		Scanner userInput = new Scanner(System.in);
        String choice = "0";
        PrintWriter outputWriter = null;
        do
        {
            // Main Console Menu
            System.out.println("\n1) Eisagogh mias topothesias sto ktirio.\n2) Ananeosh ton metriseon.\n3) Elegxos pyrkagias.\n4) Exodos.\n");
            System.out.print("Choose: ");
            choice = userInput.next();
            
            // 4 Cases 
            switch (choice) 
            {
            	// Adds a new room to the array (if its already added, it's ignored)
                case "1":
                    while (true) {
                        try {
                            System.out.print("Eisagete arithmo domatiou:  ");
                            int roomID = userInput.nextInt();
                            if (roomID <= 0) {
                                throw new InputMismatchException();
                            }
                            Room aRoom = new Room(roomID);
                            boolean roomContain = false;
                            for (Room inTheList: rooms) {
                                if (inTheList.equals(aRoom)) {
                                    roomContain = true;
                                    break;
                                } 
                            }
                            if (!roomContain) {
                                rooms.add(aRoom);
                                break;
                            }
                            break;
                        } catch (InputMismatchException e) {
                            userInput.nextLine();
                            System.out.println("Dokimaste ksana");
                        } 
                    }
                    break;
                    
                // It sorts the array based on the roomID, saves the previous results to a file and then it
                // refreshes the values of the sensors (if there's an older file with the same name, is overwritten)
                case "2":
                	// Sorting
                    Collections.sort(rooms);
                    // Writing to a file
                    try {
                        outputWriter = new PrintWriter(new FileOutputStream("measures.txt"));
                        for (Room y: rooms) {
                            outputWriter.println(y.toString() + "\tXronos " + y.getTime() + ";\n\n");
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("Error opening the file measures.txt.");
                    }
                    outputWriter.close();
                    // Updating sensors
                    for (Room y: rooms) {
                        y.updater();
                    }
                    System.out.println("Ananeosi epitixis, teleutaies times sto arxeio: measures.txt");
                    break;
                    
                // Checks for fire on a room specified by the user
                case "3":
                    Collections.sort(rooms);
                    while (true) {
                        try {
                            System.out.print("Eisagagete kodiko domatiou h 0 gia ola ta domatia:  ");
                            Integer roomToCheck = userInput.nextInt();
                            boolean weHaveIt = false;
                            for (Room a: rooms) {
                                if (roomToCheck.equals(a.getRoomID())) {
                                    System.out.println(a);
                                    weHaveIt = true;
                                } else if (roomToCheck == 0) {
                                    System.out.println(a);
                                    weHaveIt = true;
                                }
                            }
                            if (!weHaveIt) {
                                throw new InputMismatchException();
                            }
                            break;
                        } catch (InputMismatchException e) {
                            userInput.nextLine();
                            System.out.println("Dokimaste ksana");
                        }
                    }
                    break;
                    
                // Exits the application
                case "4":
                    System.exit(0);

                // Throws a message of invalid option
                default:
                    System.out.println("\nMi egkiri epilogi\n");
            }
        } while (true);
    }
}