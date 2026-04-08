package com.example.buildexpenseanalyzer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.buildexpenseanalyzer.Dto.ProjectDto;
import com.example.buildexpenseanalyzer.service.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProjectController {
    private final ProjectService service;
    @PostMapping("/create")
    public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
        return service.create(projectDto);
    }
    @GetMapping("/get/{id}")
    public ProjectDto getProjectById(@PathVariable Long id) {
        return service.getById(id);
    }
    @GetMapping("/getAll")
    public List<ProjectDto> getAllProject() {
        return service.getAll();
    }
    @DeleteMapping("delete/{id}")
    public String deleteProject(@PathVariable Long id){
        return service.deleteById(id);
    }   
}
