package com.jm.dao;

import com.jm.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrariesDao extends JpaRepository<Library, Integer> {
	Library findById(int id);
}
