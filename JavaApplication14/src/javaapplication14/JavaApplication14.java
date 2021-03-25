/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

class Student
{
    //attributes
    private String TPNo;
    private String Name;
    //methods 1.Accessor or Getters 2.Mutator or Setters
    //accessors for private members
    public String getTPNo()
    {
        return TPNo;
    }
    public String getName()
    {
        return Name;
    }
    //setters for private members
    public void setTpNo(String Tno){TPNo = Tno;}
    public void setName(String Na) {Name = Na;}
    
}
public class JavaApplication14 {

    public static void main(String[] args){
        Greetings();
    }
       public static void Greetings()
        {
           System.out.println("IDEK");
        }
    
}
