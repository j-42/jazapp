package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.Library;

@Repository
public interface LibrariesDao extends JpaRepository<Library, Integer> {
	Library findById(int id);
}
