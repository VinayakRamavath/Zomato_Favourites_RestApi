package com.stackroute.foodapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity // This tells Hibernate to make a table out of this class
public class Restaurant {
    @Id
    @Column(name="id")
    @ApiModelProperty(notes = "The database generated product ID")
    private Integer id;

    @Column(name="name")
    @ApiModelProperty(notes = "The database generated product ID")
    private String name;
    
    @Column(name="featured_image")
    @ApiModelProperty(notes = "The database generated product ID")
    private String featured_image;
    
    @Column(name="cuisines")
    @ApiModelProperty(notes = "The database generated product ID")
    private String cuisines;
    
    @Column(name="average_cost_for_two")
    @ApiModelProperty(notes = "The database generated product ID")
    private String average_cost_for_two;
    
    @Column(name="rating")
    @ApiModelProperty(notes = "The database generated product ID")
    private String rating;
    
    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name="comments")
    @ApiModelProperty(notes = "The database generated product ID")
    private String comments;
    
	public String getFeatured_image() {
		return featured_image;
	}

	public void setFeatured_image(String featured_image) {
		this.featured_image = featured_image;
	}

	public String getCuisines() {
		return cuisines;
	}

	public void setCuisines(String cuisines) {
		this.cuisines = cuisines;
	}

	public String getAverage_cost_for_two() {
		return average_cost_for_two;
	}

	public void setAverage_cost_for_two(String average_cost_for_two) {
		this.average_cost_for_two = average_cost_for_two;
	}


	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Restaurant(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public Restaurant(Integer id, String name, String featured_image, String cuisines, String average_cost_for_two,
			String rating, String comments) {
		super();
		this.id = id;
		this.name = name;
		this.featured_image = featured_image;
		this.cuisines = cuisines;
		this.average_cost_for_two = average_cost_for_two;
		this.rating = rating;
		this.comments = comments;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}

