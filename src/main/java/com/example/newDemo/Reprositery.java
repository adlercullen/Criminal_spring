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
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms_lab", "root", "root");
			String query="select * from criminals";
			PreparedStatement stmt=connection.prepareStatement(query);

			ResultSet result=stmt.executeQuery();
			List<People> list=new ArrayList<People>();

			while(result.next()){
				String fname=result.getString("fname");
				String lname=result.getString("lname");
				String dob=result.getString("DOB");
				String crime=result.getString("crime");
				String entry=result.getString("entry");

				People people=new People(fname,lname,dob,crime,entry);
				

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
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms_lab", "root", "root");
			String query="insert into criminals values(null,?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(query);

			statement.setString(1, people.Fname);
			statement.setString(2, people.Lname);
			statement.setString(3, people.DOB);
			statement.setString(4,people.Crime);
			statement.setString(5, people.Entry);

			statement.executeUpdate();
			System.out.println(people);

			return people;


			
		} catch (Exception e) {
			return new People("nhk","","","","");
		}
	}
}
