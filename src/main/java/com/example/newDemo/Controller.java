package com.example.newDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Conditional;
// import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Cache.Connection;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;





@SpringBootApplication
@RestController
@CrossOrigin("*")
public class Controller {
	public static Reprositery reprositery=new Reprositery();

	public static void main(String[] args) {
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch(Exception e)
        {
            System.out.println("JDBC driver not init:"+e);
        }
		SpringApplication.run(Controller.class, args);
	}


	@ConditionalOnWebApplication
	@GetMapping("/check")
	public String check(){
		return "Hello";
	}
	@GetMapping("/getDetails")
	public String show(){
		return "Hello user you are using springboot";
	}

	@GetMapping("/get")
	public List<People> getPeople(){
		List<People> p=reprositery.getList();

		return p;
	}

	@PostMapping("/post")
	public People addPeople(@RequestBody People people){

		return reprositery.addList(people);
	}

	@GetMapping("/generateNo")
	public int random(){
		return (int)(Math.random()*10+1);
	}

}
