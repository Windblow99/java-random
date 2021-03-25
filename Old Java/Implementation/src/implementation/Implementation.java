package implementation;

import java.util.Scanner;

class Student{
    //Member Deciration
    private String StudentID;
    private String StudentName;
    //Method Implementation
    public String getStudentInfo(){
        return "Student id= " + StudentID + " Student Name= " + StudentName;
    }
    //Setters
    public void SetStudentID(String C){
        StudentID = C;
    }
    public void SetStudentName(String C){
        StudentName = C;
    }
}

class Degree extends Student{
    //Member Declaration
    private String Major;
    //Method Implementation
    public String getDegreeInfo(){
        return getStudentInfo() + " Major= " + Major;
    }
    public Degree(String a,String b, String c){
        SetStudentID(a);
        SetStudentName(b);
        Major = c;          
    }
}

class Master extends Student{
    //Member Declaration
    private String Mode;
    //Method Implementation
    public String getMasterInfo(){
        return getStudentInfo() + " Mode= " + Mode;
    }
    public Master(String a, String b, String c){
        SetStudentID(a);
        SetStudentName(b);
        Mode = c;
    }
}



public class Implementation {
    public static void main(String[] args) {
       Degree Eren = new Degree("TP046057","Eren Ong","Software Engineering");
       System.out.println(Eren.getDegreeInfo());
       Master Eren2 = new Master("TP046057","Eren Ong","Software Engineering");
       System.out.println(Eren2.getMasterInfo()); 
    }
    
}
