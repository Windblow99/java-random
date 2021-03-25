package fileexampletutorial21;


public class Employee {
    private String EmpCode; private String EmpName; private int EmpSalary;
    public Employee(String Ec, String En,int Es){EmpCode = Ec; EmpName = En; EmpSalary = Es;}
    public String WriteData(){return EmpCode + "" + EmpName + "" + EmpSalary;}
    
    
}
