package com.youssef.Lookify.models;

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
@Table(name="songs")
public class Song {
	// MEMBER VARIABLES
			@Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			@NotBlank
			@Size(min = 5, max = 200, message="the expense title is required !!!!")
			private String title;
			@NotBlank
			@Size(min = 5, max = 200, message="you need an amount!!!!")
			private String artist;
			@NotNull
			@Min(1)
			@Max(10)
			private Integer rating;
			// This will not allow the createdAt column to be updated after creation
		    @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
			private Date createdAt;
			
		    @DateTimeFormat(pattern="yyyy-MM-dd")
			private Date updatedAt;
		    
			// EMPTY CONSTRUCTOR
		    public Song() {
			// TODO Auto-generated constructor stub
		}
		    
		    
		    
		    
public Long getId() {
				return id;
			}




			public void setId(Long id) {
				this.id = id;
			}




			public String getTitle() {
				return title;
			}




			public void setTitle(String title) {
				this.title = title;
			}




			public String getArtist() {
				return artist;
			}




			public void setArtist(String artist) {
				this.artist = artist;
			}




			public Integer getRating() {
				return rating;
			}




			public void setRating(Integer rating) {
				this.rating = rating;
			}




			public Date getCreatedAt() {
				return createdAt;
			}




			public void setCreatedAt(Date createdAt) {
				this.createdAt = createdAt;
			}




			public Date getUpdatedAt() {
				return updatedAt;
			}




			public void setUpdatedAt(Date updatedAt) {
				this.updatedAt = updatedAt;
			}




			//			----- methods ---
		    // other getters and setters removed for brevity
		    @PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }

			@PreUpdate
		    protected void onUpdate(){
		        this.updatedAt = new Date();
		    }
}
