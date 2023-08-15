package com.youssef.productManager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.youssef.productManager.models.Project;
import com.youssef.productManager.models.Task;
import com.youssef.productManager.models.User;
import com.youssef.productManager.services.ProjectServ;
import com.youssef.productManager.services.TaskServ;
import com.youssef.productManager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	private ProjectServ ProjectServ;
	@Autowired
	private UserService UserService;
	@Autowired
	private TaskServ TaskServ;
//	display route dashboard
	@GetMapping("/dashboard")
	public String index(HttpSession s,Model m) {
//		grab the user id from session 
		Long userId = (Long) s.getAttribute("user_id");
//		ROUTE GUARD
		if (userId == null ) {
			return "redirect:/login";
			
		}
		User loggedUser = UserService.findOne(userId);
		List<Project> ListProjects = ProjectServ.allDojos();
		m.addAttribute("AllProjects",ListProjects);
		m.addAttribute("loggedUser",loggedUser);
		return "dashboard.jsp";
	}
	
	
	
	// DISPLAY ROUTE - FORM
			@GetMapping("/project/new")
			public String create(@ModelAttribute("project") Project project,HttpSession s) {
//				grab the user id from session 
				Long userId = (Long) s.getAttribute("user_id");
//				ROUTE GUARD
				if (userId == null ) {
					return "redirect:/login";
					
				}
				
				return "createdojo.jsp";
			}
			// ACTION ROUTE - Process Form
			@PostMapping("/process/project")
			public String createBook(@Valid @ModelAttribute("project") Project project, BindingResult result,
									Model m,HttpSession s) {

				if (result.hasErrors()) {
		
					return "createdojo.jsp";
				} else {
					 Long LoggedUserId = (Long) s.getAttribute("user_id");
					 User userLogged = UserService.findOne(LoggedUserId);
					project.setTeamlead(userLogged);
					// save the project
					Project newProject =  ProjectServ.createDojo(project);
					
					
				return "redirect:/dashboard";
				}

			}
//			show one project 
			@GetMapping("/show/project/{id}")
			public String showDojo(@PathVariable("id") Long id, Model model,HttpSession s) {
				 Long LoggedUserId = (Long) s.getAttribute("user_id");
						model.addAttribute("project", ProjectServ.findDojo(id));
						model.addAttribute("LoggedUserId", LoggedUserId);
						return "showninjas.jsp";
					}
			
			
			
//			JOIN THE PROJECT TEAM 
			@GetMapping("/join/{id}")
			public String join(HttpSession s,@PathVariable("id") Long projid) {
//				Grab the current loggin user
				Long userId = (Long) s.getAttribute("user_id");
				User loggedUser = UserService.findOne(userId);
//				Grab the  Project from db
				Project thisProject = ProjectServ.findDojo(projid);
//				add the user to the projects joined by users
				thisProject.getUsers().add(loggedUser);
//				Save the modification added
				ProjectServ.updateDojo(thisProject);
				
				return "redirect:/dashboard";
				
			}
//			REMOVE FROM  THE PROJECT TEAM 
			@GetMapping("/remove/{id}")
			public String remove(HttpSession s,@PathVariable("id") Long projid) {
//				Grab the current loggin user
				Long userId = (Long) s.getAttribute("user_id");
				User loggedUser = UserService.findOne(userId);
//				Grab the  Project from db
				Project thisProject = ProjectServ.findDojo(projid);
//				remove the user to the projects joined by users
				thisProject.getUsers().remove(loggedUser);
//				Save the modification added
				ProjectServ.updateDojo(thisProject);
				
				return "redirect:/dashboard";
				
			}
			// Display Route - Edit form
			
			@GetMapping("/edit/{id}")
			public String editPage(@PathVariable("id") Long id,@ModelAttribute("project") Project project, Model model) {
				
				// find that book with provided id
				Project thisProject = ProjectServ.findDojo(id);
				
				// pass thisBook to the jsp page 
				model.addAttribute("project",thisProject);
				
				return "edit.jsp";
			}
			
			@PutMapping("/{id}/edit")
			public String updateBook(@Valid @ModelAttribute("project") Project project, BindingResult result,@PathVariable("id") Long id
					,Model model,HttpSession s) {
				if (result.hasErrors()) {
					Project thisProject = ProjectServ.findDojo(id);
					model.addAttribute("project",thisProject);
					return "edit.jsp";
				} else {
					 Long LoggedUserId = (Long) s.getAttribute("user_id");
					 User userLogged = UserService.findOne(LoggedUserId);
					project.setTeamlead(userLogged);
					// if there are no errors update one
					ProjectServ.updateDojo(project);
					return "redirect:/dashboard";
				}
			}
//			delete project 
			@DeleteMapping("/destroy/{id}")
			public String destroy(@PathVariable("id") Long projid){
				
				ProjectServ.deleteDojo(projid);
				return "redirect:/dashboard";
			}
// add a task in the project 
			@GetMapping("/projects/{projectId}/tasks")
			public String addtask(@PathVariable("projectId") Long projectId,Model m , HttpSession s,
					@ModelAttribute("task") Task task) {
//				grab the user id from session 
				Long userId = (Long) s.getAttribute("user_id");
//				ROUTE GUARD
				if (userId == null ) {
					return "redirect:/login";
					
				}
				// find that project with provided id
				Project thisProject = ProjectServ.findDojo(projectId);
//				fin tasks by projects
				List<Task> thistasks = TaskServ.findbyproject(projectId);
				
				System.out.println(thistasks.thetask);
				// pass thisBook to the jsp page 
				m.addAttribute("project",thisProject);
				m.addAttribute("alltas",thistasks);
				
				return "addtask.jsp";
			}
			
			@PostMapping("/process/task/{projectId}")
			public String taskprocess(@Valid @ModelAttribute("task") Task task,@PathVariable("projectId") Long projectId,
					BindingResult result,HttpSession s) {
//				Grab the current loggin user
				Long userId = (Long) s.getAttribute("user_id");
				User loggedUser = UserService.findOne(userId);
				if (result.hasErrors()) {
					
					return "addtask.jsp";
				} else {
//				Grab the current project 	
				Project thisProject = ProjectServ.findDojo(projectId);
				task.setProject(thisProject);
				task.setUser(loggedUser);
				// 2. Create the new task
				Task latestTask = (Task) TaskServ.create(task);
								
				return "redirect:/projects/"+ projectId +"/tasks";
			}
				}
					
}
