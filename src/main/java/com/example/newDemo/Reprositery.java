package com.example.newDemo;

import org.springframework.web.bind.annotation.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class Reprositery {
    Reprositery(){

    }

	public List<People> getList(){
		try {
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/adarshdb", "root", "root");
			String query="select * from Person";
			PreparedStatement stmt=connection.prepareStatement(query);

			ResultSet result=stmt.executeQuery();
			List<People> list=new ArrayList<People>();

			while(result.next()){
				String name=result.getString("Name");
				int age=result.getInt("Age");
				int salary=result.getInt("Salary");

				People people=new People(name, age, salary);
				people.inquiry();

				list.add(people);

				

			}

			return list;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

    public People addList(@RequestBody People people){
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/adarshdb", "root", "root");
			String query="insert into person(Name,Age,Salary) values(?,?,?)";
			PreparedStatement statement=con.prepareStatement(query);

			statement.setString(1, people.Name);
			statement.setInt(2, people.Age);
			statement.setInt(3, people.Salary);

			statement.executeUpdate();
			System.out.println(people);

			return people;


			
		} catch (Exception e) {
			return new People("nhk", 0, 0);
		}
	}
}
