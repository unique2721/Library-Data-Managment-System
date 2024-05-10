package project;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class UserInterface {


    static void loginPage(){
        Scanner in = new Scanner(System.in);
        System.out.println("--------------- Welcome to My library ---------------");
        System.out.println("\t A) Login as a librarian");
        System.out.println("\t B) Login as a student");
        System.out.println("\t C) Exit");
        try{
            String option;
            System.out.print("\t choose: ");
            option = in.next();
            option = option.toUpperCase();
            switch(option){
                case "A":
                    Librarian.librarianLogin();
                    break;
                case "B":
                    UserInterface.studentLoginPage();
                    break;
                case"C":
                    System.exit(0);
                default:
                    System.out.println("      !!! Invalid Option !!!   ");
                    loginPage();
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid Option");
        }
    }
    public static void librarianPage(){
        Scanner in = new Scanner(System.in);
        System.out.println("  __________________________________________________");
        System.out.println("||                                                  ||");
        System.out.println("||      Press A to add book.                        ||");
        System.out.println("||      press B to show available books.            ||");
        System.out.println("||      Press C to Search book.                     ||");
        System.out.println("||      Press D to delete book.                     ||");
        System.out.println("||      Press E to add student                      ||");
        System.out.println("||      Press F to show student                     ||");
        System.out.println("||      Press G to log out from librarian account.  ||");
        System.out.println("||      Press H to Exit.                            ||");
        System.out.println("||__________________________________________________||");
        try{
            String option;
            System.out.print("\t choose: ");
            option = in.next();
            option = option.toUpperCase();
            switch(option){
                case "A":
                    Librarian.addBook();
                    break;
                case "B":
                    Librarian.showBook();
                    break;
                case "C":

                    Librarian.searchBook();
                    break;
                case "D":
                    Librarian.deleteBook();
                    break;
                case "E":
                    Librarian.addStudent();
                    break;
                case "F":
                    Librarian.showStudents();
                    break;
                case "G":
                    UserInterface.loginPage();
                    break;
                case "H":
                   System.exit(0);
                    break;
                default:
                    System.out.println("\tInvalid Option");
                    System.out.print("Write anything and press to continue..... ");
                    in.next();
                    librarianPage();
            }
        }catch (InputMismatchException e){
            System.out.println("   !!!Invalid Option !!!  ");
        }
    }
    public static  void studentLoginPage(){
        System.out.println("Enter student name");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        System.out.println("Enter student password");
        String password = in.next();
        boolean flag = false;
        for(Student std :LibraryManagementSystem.getStudentslist()){
            if (Objects.equals(std.getName(), name) && Objects.equals(std.getPassword(), password)){
                flag = true;
                std.login= true;
            }
        }
        if(flag){
            System.out.print("Write anything and press to continue...... ");
            Scanner input = new Scanner(System.in);
            input.next();
            Student.studentPage(name);
        }else {
            System.out.println("        !!! student not found !!!    ");
            System.out.print("Do you want to return to the main page (yes) : ");
            String op = in.next();
            if(op.equalsIgnoreCase("YES")){
                UserInterface.loginPage();
            }else{
                studentLoginPage();

            }
        }


    }
    public static  void logOutAll(){
        for(Student std: LibraryManagementSystem.getStudentslist()){
            std.login = false;
        }
    }
}
