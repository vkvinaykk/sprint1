package com.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeepayroll.entity.SantionedLeaves;

public interface SantionedLeavesRepository extends JpaRepository<SantionedLeaves,Integer>{

}



//List<SantionedLeaves> findAllByEmployeeId(int employeeId);