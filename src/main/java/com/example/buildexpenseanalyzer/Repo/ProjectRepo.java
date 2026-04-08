package com.example.buildexpenseanalyzer.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buildexpenseanalyzer.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long> {

}
