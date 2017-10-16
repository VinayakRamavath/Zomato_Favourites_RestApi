package com.stackroute.foodapp.service;

import com.stackroute.foodapp.domain.Restaurant;
import com.stackroute.foodapp.exceptions.UserNotFoundException;

public interface FavouriteService {
	public Restaurant getbyid(int id) throws UserNotFoundException;
	public Restaurant getByName(String name) throws UserNotFoundException;
	public Iterable<Restaurant> getAllUsers() throws UserNotFoundException;
	public Restaurant addNewUser(Restaurant user)  throws UserNotFoundException;
	public void deletebyid(int id) throws UserNotFoundException;
	public void updatebyid(int id, String name) throws UserNotFoundException;
	
	
}
