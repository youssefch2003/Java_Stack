package com.youssef.loginregistration.models;

import java.util.Date;

import org.apache.tomcat.jni.Library;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ninjas")
public class Ninja {
	// MEMBER VARIBALES
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotBlank
		@Size(min = 4, max = 20, message="you need a name!!!!")
		private String first_name;
		@NotBlank
		@Size(min = 4, max = 20, message="you need a name!!!!")
		private String last_name;
		@NotNull
		private Integer age;
		
		// M:1
		@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="dojo_id")
		private Dojo dojo;

		
		// This will not allow the createdAt column to be updated after creation
				@Column(updatable = false)
				@DateTimeFormat(pattern = "yyyy-MM-dd")
				private Date createdAt;

				@DateTimeFormat(pattern = "yyyy-MM-dd")
				private Date updatedAt;
				
				
				
		public Dojo getDojo() {
					return dojo;
				}

				public void setDojo(Dojo dojo) {
					this.dojo = dojo;
				}

				// EMPTY CONSTRUCTOR
				public Ninja() {}
				
//				----- methods ---
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

				public String getFirst_name() {
					return first_name;
				}

				public void setFirst_name(String first_name) {
					this.first_name = first_name;
				}

				public String getLast_name() {
					return last_name;
				}

				public void setLast_name(String last_name) {
					this.last_name = last_name;
				}

				public Integer getAge() {
					return age;
				}

				public void setAge(Integer age) {
					this.age = age;
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
