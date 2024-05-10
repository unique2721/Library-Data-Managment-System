package project;

import java.util.ArrayList;
public class LibraryManagementSystem {
    String libraryName;
    String place;
    private static ArrayList<Student> studentslist = new ArrayList<>();

    LibraryManagementSystem(){
        this.libraryName = "jan";
        this.place = "bd";
    }
    public static ArrayList<Student> getStudentslist(){
        return  studentslist;
    }

    public static void addStudent(Student std){
        studentslist.add(std);
    }

}
