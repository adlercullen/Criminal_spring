package com.example.newDemo;

public class People {
    public String Name;
    public int Age;
    public int Salary;

    public People(String Name,int Age,int Salary){
        this.Name=Name;
        this.Age=Age;
        this.Salary=Salary;
    }

    public void inquiry(){
        System.out.println("Name is "+Name+" Salary is "+Salary+" Age "+Age);
    }

    
}
