package project;

import java.util.Objects;
import java.util.Scanner;

public class Librarian extends LibraryManagementSystem {
    private String name;
    private String password;
    Scanner SC = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Librarian() {
    }

    public static Librarian librarian = new Librarian();

    public static void librarianLogin() {
        boolean log = true;
        while (log){
        librarian.setName("admin");
        librarian.setPassword("123");
        Scanner in = new Scanner(System.in);
        System.out.println("--------------- librarian Log In ---------------");
        System.out.print("\t Librarian Name: ");
        String userName = in.next();
        System.out.print("\t Password: ");
        String passowrd = in.next();
        if (userName.equals(librarian.getName()) && passowrd.equals(librarian.getPassword())) {
            System.out.println("        !!! you logged successfully !!!    ");
            log = false;
            UserInterface.librarianPage();
        } else {
            System.out.println("\t !!! Incorrect Username or Password !!! ");

        }
        }
    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter serial number");
        String serial = sc.nextLine();
        boolean flag = true;
        for (Book book : Book.bookslist) {
            if (Objects.equals(book.getSerialNumber() , serial)) {
                flag = false;
            }

        }
        if (flag) {
            String numPatt = "^[0-9]+$";
            System.out.println("Enter book name");
            String bookName = sc.nextLine();
            System.out.println("Enter author");
            String author = sc.nextLine();
            System.out.println("Enter publisher");
            String publisher = sc.nextLine();
            System.out.println("Enter the year: ");
            String year = sc.next();

            while (!year.matches(numPatt)) {
                System.out.println("   !!! only integer allowed !!");
                year = sc.nextLine();
            }
            int realyear = Integer.parseInt(year);

            Book book = new Book(serial, bookName, author, publisher, realyear);
            Book.bookslist.add(book);
            System.out.println("   !!! Book added successfully !!!  ");
            System.out.print("Write anything and press to continue...... ");
            sc.next();
            UserInterface.librarianPage();
        }
    }

    public static void showBook() {
        if (Book.bookslist.isEmpty()) {
            System.out.println("    !!! There is no book available !!!  ");
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
        UserInterface.librarianPage();

    }

    public static void searchBook() {
        Scanner input = new Scanner(System.in);


        if (Book.bookslist.isEmpty()) {
            System.out.println("     !!! There is no book !!!   ");
        } else {
            System.out.println("Enter the book seral number");
            String searchWord = input.next();
            boolean flag =false;
            for (Book book : Book.bookslist) {

                if (Objects.equals(searchWord, book.getSerialNumber())) {
                    System.out.println("The full information of book: ");
                    System.out.println("*****************************************************");
                    System.out.println("* Serial Number: " + book.getSerialNumber());
                    System.out.println("* Book Name: " + book.getBookName());
                    System.out.println("* Book Author: " + book.getAuthor());
                    System.out.println("* Publisher: " + book.getPublisher());
                    System.out.println("* Year of Edition: " + book.getYear());
                    System.out.println("*****************************************************");
                    flag = true;
                }

            }
            if (!flag){
                System.out.println("    !!! Book not found !!!");
            }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();

    }

    public static void deleteBook() {
        Scanner input = new Scanner(System.in);
        if (Book.bookslist.isEmpty()) {
            System.out.println("There is no book available");
        } else {
            System.out.println("Enter the book serial number");
            String searchWord = input.next();
            boolean found = false;
            for (Book book :Book.bookslist) {
                if (Objects.equals(book.getSerialNumber(), searchWord)) {
                    Book.bookslist.remove(book);
                    System.out.println("Deleted successfully");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println(" !!! Book not found !!!");
                System.out.print("Do you want to return to main page (yes) : ");
                String con = input.next();
                if (con.equalsIgnoreCase("yes")){
                    UserInterface.librarianPage();
                }
                else {
                    deleteBook();
                }

            }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();
    }
    public static void  addStudent(){
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.println("enter the name");
        if(LibraryManagementSystem.getStudentslist().isEmpty()){
            String stname = input.next();
            System.out.println("enter passowrd");
            String passowrd = input.next();
            Student student = new Student(stname,passowrd);
            LibraryManagementSystem.addStudent(student);
            System.out.println("student registered successfully");

            flag = false;
        }
        while (flag){

            String stname = input.next();

        for (Student std : LibraryManagementSystem.getStudentslist()) {
            if(Objects.equals(std.getName(), stname)){
                System.out.println("Enter another valid student name ");
                break;
            }else {
                System.out.println("Enter password");
                String passowrd = input.next();
                flag = false;
                Student student = new Student(stname,passowrd);
                LibraryManagementSystem.addStudent(student);
                System.out.println(" ___________ Student registered successfully!! _______");
                break;
            }
        }
        }
        System.out.print("Write anything and press to continue...... ");
        input.next();
        UserInterface.librarianPage();

    }
    public  static  void showStudents(){
        if (LibraryManagementSystem.getStudentslist().isEmpty()){
            System.out.println("   !!! There is no students !!!");
        }else {
            System.out.println("------------------------------------------");
            for (Student std : LibraryManagementSystem.getStudentslist()) {
                System.out.println("name " + std.getName());
            }
            System.out.println("------------------------------------------");

        }
        UserInterface.librarianPage();


    }


}


