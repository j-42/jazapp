package com.jm.dao;

import com.jm.model.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworksDao extends JpaRepository<Framework,Integer>{
	 Framework findById(int id);
}
