package project;

import java.util.Scanner;
import java.util.ArrayList;
public class Book  {
    private String name;

    protected String author;
    private String publisher;
    private int year;
    private String serialNumber;


    public static ArrayList<Book> bookslist = new ArrayList<>();



    Scanner SC = new Scanner(System.in);

    public Book(String serialNumber, String bookName, String author, String publisher, int year) {
        this.name = bookName;
        this.serialNumber = serialNumber;
        this.author = author;
        this.publisher = publisher;
        this.year = year;

    }


    public String getSerialNumber(){
        return this.serialNumber;
    }
    public String setSerialNumber() {
        return this.serialNumber;
    }

    public String getBookName() {
        return this.name;
    }

    public void setBookName(String bookName) {
        this.name = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;

    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


       
}
