package com.jm.dao;

import com.jm.model.Os;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsDao extends JpaRepository<Os, Integer> {
	Os findById(int id);
}
