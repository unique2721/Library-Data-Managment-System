package project;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Student {

    private  String name;
    private  String password;
    boolean login;
    ArrayList<Book> borrowedBooksList = new ArrayList<>();
    public Student( ) {

    }

    public Student(String name, String password) {
                this.name = name;
                this.password =password;
                this.login = false;

    }
    public  String getName(){
        return  this.name;
    }
    public  String getPassword(){
        return this.password;
    }


static void studentPage(String name){
    System.out.println("___________ welcome back "+ name +" ___________________");
    System.out.println("  _____________________________________________________");
    System.out.println("||                                                     ||");
    System.out.println("||     Press A to show available books.                ||");
    System.out.println("||     Press B to show borrow books.                   ||");
    System.out.println("||     Press C to borrow book.                         ||");
    System.out.println("||     Press D to return book.                         ||");
    System.out.println("||     Press E to log out from student account.        ||");
    System.out.println("||     Press F to exit.                                ||");
    System.out.println("||_____________________________________________________||");
    try{
        Scanner in = new Scanner(System.in);
        String option;
        System.out.print("\t choose: ");
        option = in.next();
        option = option.toUpperCase();
        switch(option){
            case "A":
                Student.showBook(name);
                break;
            case "B":
                Student.showBorrowBook(name);
                break;
            case "C":
                Student.borrow(name);
                break;
            case"D":
                Student.returnBorrow(name);
                break;
            case "E":
                UserInterface.logOutAll();
                UserInterface.loginPage();
                break;
            case "F":
                System.exit(0);
                break;
            default:
                System.out.println("\tInvalid Option");
                UserInterface.studentLoginPage();
        }
    }catch (InputMismatchException e){
        System.out.println("Invalid Option");
    }
}

public static void borrow(String name){
        Scanner input = new Scanner(System.in);
    Book bk = null;
    if(Book.bookslist.isEmpty()){
        System.out.println("    !!! There is no book available !!!");
    }else {
        System.out.println("Enter serial number");
        String sn = input.next();
        boolean flag = false;
        for(Book book :Book.bookslist){
            if (Objects.equals(book.getSerialNumber(), sn)){

                bk = book;
                Book.bookslist.remove(book);
                flag =true;
                break;
            }
        }

        if(!flag){
            System.out.println("Book not found");
            borrow(name);
        }
        else {
            for (Student st:LibraryManagementSystem.getStudentslist()){

                if(st.login){

                    st.borrowedBooksList.add(bk);
                    System.out.println("    !!! Borrowed successfully !!!");

                    break;
                }
            }

        }


    }
    System.out.print("Write anything and press to continue...... ");
    input.next();
    Student.studentPage(name);

}

public static  void showBook(String name){
    if (Book.bookslist.isEmpty()) {
        System.out.println("   !!! There is no book !!!  ");
    } else {
        for (Book book :Book.bookslist) {

            System.out.println("The full information of book: ");
            System.out.println("*****************************************************");
            System.out.println("* Serial Number: " + book.getSerialNumber());
            System.out.println("* Book Name: " + book.getBookName());
            System.out.println("* Book Author: " + book.getAuthor());
            System.out.println("* Publisher: " + book.getPublisher());
            System.out.println("* Year of Edition: " + book.getYear());
            System.out.println("*****************************************************");
        }
    }
    System.out.print("Write anything and press to continue...... ");
    Scanner input = new Scanner(System.in);
    input.next();
    studentPage(name);
}
public static void showBorrowBook(String name){

        for (Student st: LibraryManagementSystem.getStudentslist()){
            if(st.login){
                showStBorrowBook(st);
                break;
            }
        }
    System.out.print("Write anything and press to continue...... ");
        Scanner input = new Scanner(System.in);
        input.next();
    studentPage(name);
}
public  static  void  showStBorrowBook(Student st){
        if(st.borrowedBooksList.isEmpty()){
            System.out.println("  !!! No book borrowed !!!");

    }
        for (Book book :st.borrowedBooksList){
            System.out.println("The full information of book:");
            System.out.println("*****************************************************");
            System.out.println("* Serial Number: " + book.getSerialNumber());
            System.out.println("* Book Name: " + book.getBookName());
            System.out.println("* Book Author: " + book.getAuthor());
            System.out.println("* Publisher: " + book.getPublisher());
            System.out.println("* Year of Edition: " + book.getYear());
            System.out.println("*****************************************************");
        }
        studentPage(st.getName());
}
public static void returnBorrow(String name){
        Scanner input = new Scanner(System.in);

    for (Student std : LibraryManagementSystem.getStudentslist()){
        if(std.login){
            if(std.borrowedBooksList.isEmpty()){
                System.out.println("   !!! No book borrowed !!!  ");
            }
            else{
                System.out.println("Enter the book serial number ");
                String sn = input.next();
                boolean found = false;
                for(Book book : std.borrowedBooksList){
                    if(Objects.equals(book.getSerialNumber(), sn)){
                        found = true;
                        Book.bookslist.add(book);
                        std.borrowedBooksList.remove(book);
                        System.out.println("Book returned to the library");
                        System.out.println();
                        System.out.print("Write anything and press to continue...... ");
                        input.next();
                        Student.studentPage(name);
                        break;
                    }
                }
                if(!found){
                    returnBorrow(name);
                }

            }
        }

    }


}

}
