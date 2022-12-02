package org.example.controller;

import io.swagger.annotations.Api;
import org.example.model.Project;
import org.example.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "project controller")
public class ProjectController {

    @Autowired
    private EntityService<Project> projectService;


    @RequestMapping(value = "/projects/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> getAllPositions() {
        List<Project> projects = projectService.getAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public ResponseEntity<Project> getPositionById(@PathVariable Long id) {
        Project project = projectService.getById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }


    @RequestMapping(value = "/projects", method = RequestMethod.POST)
    public ResponseEntity<Project> addNewPosition(@RequestBody Project project) {
        Project added = projectService.save(project);
        return new ResponseEntity<>(added, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Project> deletePosition(@PathVariable Long id) {
        projectService.deleteById(id);
        return new ResponseEntity<>(projectService.getById(id), HttpStatus.NO_CONTENT);
    }
}
