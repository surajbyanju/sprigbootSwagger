package com.suraj.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.suraj.domain.Person;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {
	
	static final List<Person> listOfUsers = new ArrayList<>();
	
	static{
		listOfUsers.add(new Person(1,"David","Beckham"));
    	listOfUsers.add(new Person(2,"Christiano","Ronaldo"));
    	listOfUsers.add(new Person(3,"David","Luiz"));
	}
	
	
        
    @ApiOperation(value="Get the currently logged in users details",notes="Uses the remote user logged in")
    @ApiResponses (value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(value="/users",method=RequestMethod.GET, produces = "application/json")
    
    public @ResponseBody List<Person> getAllUsers() 
    {
        return listOfUsers;
    }

    @ApiOperation(value="Get a specific users details",notes="Requires uid of user to look up")
    @ApiResponses (value = { 
            @ApiResponse(code = 200, message = "Success", response = Person.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
    @RequestMapping(value="/users/{uid}",method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody Person getFindSpecificUser(@PathVariable("uid") Integer uid)
    {
    	List<Person> p = listOfUsers.stream().filter(per -> per.getId()==uid).collect(Collectors.toList());
    	if (p.size() != 1) {
    	    throw new IllegalStateException();
    	} 	  	
        return  p.get(0);
    }
    
}
