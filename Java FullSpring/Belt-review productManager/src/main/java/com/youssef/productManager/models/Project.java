package com.youssef.productManager.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="projects")
public class Project {
	// MEMBER VARIBALES
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long id;
			@NotBlank
			@Size(min = 4, max = 20, message="you need a title!!!!")
			private String title;
			@NotBlank
			@Size(min = 4, max = 20, message="you need a des!!!!")
			private String description;
			@NotNull
			@Future
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Date duedate;
			// This will not allow the createdAt column to be updated after creation
			@Column(updatable = false)
			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Date createdAt;
			 @ManyToOne(fetch = FetchType.LAZY)
			    @JoinColumn(name="user_id")
			    private User teamlead;
//			 tasks many to many 
			 @OneToMany(mappedBy="project", fetch=FetchType.LAZY)
			    private List<Task> userstask;
			 
			 
			   public User getTeamlead() {
				return teamlead;
			}

			public void setTeamlead(User teamlead) {
				this.teamlead = teamlead;
			}

			@ManyToMany(fetch = FetchType.LAZY)
			    @JoinTable(
			        name = "users_projects", 
			        joinColumns = @JoinColumn(name = "project_id"), 
			        inverseJoinColumns = @JoinColumn(name = "user_id")
			    )
			
			
			   private List<User> users;
			   
			
			public List<User> getUsers() {
				return users;
			}

			public void setUsers(List<User> users) {
				this.users = users;
			}

			@DateTimeFormat(pattern = "yyyy-MM-dd")
			private Date updatedAt;
			// EMPTY CONSTRUCTOR
			public Project() {}
		 
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

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public Date getDuedate() {
				return duedate;
			}

			public void setDuedate(Date duedate) {
				this.duedate = duedate;
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
