package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer>{

}
