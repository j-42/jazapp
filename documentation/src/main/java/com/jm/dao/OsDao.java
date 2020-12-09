package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.Os;

@Repository
public interface OsDao extends JpaRepository<Os, Integer> {
	Os findById(int id);
}
