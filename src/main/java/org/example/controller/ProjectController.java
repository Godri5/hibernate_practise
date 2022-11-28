package org.example.controller;

import org.example.model.Project;
import org.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("project", projects);
        return "list-projects";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model model) {
        Project project = new Project();
        model.addAttribute("project", project);
        return "projects-form";
    }

    @PostMapping("/saveProject")
    public String saveCustomer(@ModelAttribute("project") Project project) {
        projectService.saveProject(project);
        return "redirect:/project/list";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute("project", project);
        return "project-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Long id) {
        projectService.deleteProject(id);
        return "redirect:/project/list";
    }
}
