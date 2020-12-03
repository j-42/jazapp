package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.User;

@Repository
public interface UsersDao extends JpaRepository<User, Integer> {
	User findById(int id);
}
