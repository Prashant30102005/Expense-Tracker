package com.example.buildexpenseanalyzer.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.buildexpenseanalyzer.Dto.ProjectDto;
import com.example.buildexpenseanalyzer.Repo.ProjectRepo;
import com.example.buildexpenseanalyzer.model.Project;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepo repo;

    public ProjectDto create(ProjectDto projectDto) {
        Project p = new Project(projectDto.getId(),projectDto.getName(),projectDto.getBudget(),projectDto.getStartDate(),projectDto.getEndDate());
        repo.save(p);
        return new ProjectDto(p.getId(),p.getName(),p.getBudget(),p.getStartDate(),p.getEndDate());
    }

    public ProjectDto getById(Long id) {
        Project p = repo.findById(id).get();
        return new ProjectDto(id, p.getName(), p.getBudget(),p.getStartDate(),p.getEndDate());
    }

    public List<ProjectDto> getAll() {
        List<Project> projects = repo.findAll();
        List<ProjectDto> projectDtos = new ArrayList<>();
        for(Project p : projects){
            projectDtos.add(new ProjectDto(p.getId(), p.getName(), p.getBudget(),p.getStartDate(),p.getEndDate()));
        }
        return projectDtos;
    }

    public String deleteById(Long id) {
        repo.deleteById(id);
        return "deleted";
    }

}
