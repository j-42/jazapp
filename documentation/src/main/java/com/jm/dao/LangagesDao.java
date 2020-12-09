package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.Langage;

@Repository
public interface LangagesDao extends JpaRepository<Langage,Integer> {
	Langage findById(int id);
}
