package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.Framework;

@Repository
public interface FrameworksDao extends JpaRepository<Framework,Integer>{
	 Framework findById(int id);
}
