package com.stackroute.foodapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.stackroute.foodapp.domain.Restaurant;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Restaurant, Integer> {
public Restaurant findByName(String name);
}
