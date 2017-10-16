package com.stackroute.foodapp.service.jpa_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stackroute.foodapp.domain.Restaurant;
import com.stackroute.foodapp.repository.UserRepository;
import com.stackroute.foodapp.service.FavouriteService;

@Service
public class FavouriteServiceImpl implements FavouriteService{
	@Autowired
	private UserRepository userRepository;
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Restaurant getbyid(int id) throws UserNotFoundException{

		Restaurant user = userRepository.findOne(id);
		return user;
	}

	@Override
	public Restaurant getByName(String name) throws UserNotFoundException{

		Restaurant user = userRepository.findByName(name);
		return user;
	}

	@Override
	public Iterable<Restaurant> getAllUsers() throws UserNotFoundException{
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@Override
	public Restaurant addNewUser(Restaurant user) throws UserNotFoundException {
		
		user=userRepository.save(user);
		return user;
	}

	@Override
	public void deletebyid(int id) throws UserNotFoundException{
		userRepository.delete(id);
	}

	@Override
	public void updatebyid(int id, String comments)  throws UserNotFoundException {
		Restaurant user = userRepository.findOne(id);
		user.setComments(comments);
		userRepository.save(user);
	}
}
