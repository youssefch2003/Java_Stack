package com.youssef.DojoandNinja.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
	// MEMBER VARIABLES
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotBlank
		@Size(min = 5, max = 200, message="you need a name!!!!")
		private String name;
		
		// 1:M
		@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
		private List<Ninja> ninjas;
		
		// This will not allow the createdAt column to be updated after creation
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;

		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;

		
		public List<Ninja> getNinjas() {
			return ninjas;
		}

		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
		}

		// EMPTY CONSTRUCTOR
		public Dojo() {}
		
//		----- methods ---
	    // other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

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
	    
		

}
