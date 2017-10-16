package com.stackroute.foodapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stackroute.foodapp.domain.Restaurant;
import com.stackroute.foodapp.repository.UserRepository;
import com.stackroute.foodapp.service.jpa_impl.FavouriteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller // This means that this class is a Controller
// This means URL's start with /demo (after Application path)
@RequestMapping("/v1.0/FavouriteService")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class MainController {

	@Autowired
	private FavouriteServiceImpl favouriteService;

	 @ApiOperation(value = "Search a product with an id",response = Restaurant.class)
	 @CrossOrigin(origins = "*")
	 @RequestMapping(value = "/Favourites/{id:[0-9]+}", method= RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<Restaurant> getbyid(@PathVariable("id") int id) {
		try {
		Restaurant movie = favouriteService.getbyid(id);
		return new ResponseEntity<Restaurant>(movie, HttpStatus.OK);
		}
		catch(Exception e) {
			Restaurant user=null;
			return new ResponseEntity<Restaurant>(user, HttpStatus.NOT_FOUND);
		}
	}
	
	 @ApiOperation(value = "Search a product with an name",response = Restaurant.class)
	 @CrossOrigin(origins = "*")
	@RequestMapping(value = "/Favourites/{name:[a-zA-Z]+}", method= RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<Restaurant> getByName(@PathVariable("name") String name) {
		try {
		Restaurant movie = favouriteService.getByName(name);
		return new ResponseEntity<Restaurant>(movie, HttpStatus.OK);
		}
		catch(Exception e) {
			Restaurant user=null;
			return new ResponseEntity<Restaurant>(user, HttpStatus.NOT_FOUND);
		}
	}
		 
	@ApiOperation(value = "View a list of available products", response = Iterable.class)
    @CrossOrigin(origins = "*")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value = "/Favourites", method= RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Restaurant> getAllUsers() {
		try {
		Iterable<Restaurant> ite = favouriteService.getAllUsers();
		return ite;
		}
		catch(Exception e) {
			return null;
		}
	}

	 @ApiOperation(value = "Add a product")
	    @CrossOrigin(origins = "*")
	@RequestMapping(value = "/Favourites", method = RequestMethod.POST, produces = "application/json")
//	 @PostMapping("/Favourites")
	 public @ResponseBody ResponseEntity<String> addNewUser(@RequestBody Restaurant customer) {
		
		try{
			favouriteService.addNewUser(customer);
		return new ResponseEntity<String>("Saved", HttpStatus.OK);
		}
		catch(Exception e) {
			String user="unable to post";
			return new ResponseEntity<String>(user, HttpStatus.NOT_FOUND);
		}
		
	}

	 @ApiOperation(value = "Delete a product")
	    @CrossOrigin(origins = "*")
	@RequestMapping(value="/Favourites/{id}", method = RequestMethod.DELETE, produces = "application/json")
//	 @DeleteMapping("/Favourites/{id}")
	 public @ResponseBody ResponseEntity<String> deletebyid(@PathVariable("id") int id) {
		try {
			favouriteService.deletebyid(id);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK) ;
		}
		catch(Exception e) {
			String user="deletion failed";
			return new ResponseEntity<String>(user, HttpStatus.NOT_FOUND);
		}
	}

	 @ApiOperation(value = "Update a product")
	 @CrossOrigin(origins = "*")
	@RequestMapping(value = "/Favourites/{id}", method = RequestMethod.PUT, produces = "application/json")
//	 @PutMapping("/Favourites/{id}")
	 public @ResponseBody ResponseEntity<String> updatebyid(@PathVariable("id") int id, @RequestParam String comments) {
		try {
		favouriteService.updatebyid(id, comments);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
		}
		catch(Exception e) {
			String user="updation failed";
			return new ResponseEntity<String>(user, HttpStatus.NOT_FOUND);
		}
		
	}
}
