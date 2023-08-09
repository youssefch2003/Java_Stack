package com.youssef.ApiBooks.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "burgers")
public class Burger {
	// MEMBER VARIABLES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min = 5, max = 200, message = "you need a title!!!!")
	private String name;

	@NotBlank
	@Size(min = 5, max = 200, message = "you need a restaurantName!!!!")
	private String restaurantName;
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;

	@NotBlank
	@Size(min = 5, max = 200, message = "you need a notes!!!!")
	private String notes;

	 @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		
	    @DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
	    
	    
	    
	public Burger() {

			
			// TODO Auto-generated constructor stub
		}

	// ==============GETTERS & SETTERS========== //
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
