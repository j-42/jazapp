package com.jm.dao;

import com.jm.model.Langage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangagesDao extends JpaRepository<Langage,Integer> {
	Langage findById(int id);
}
