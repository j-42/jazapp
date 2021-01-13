package com.jm.dao;

import com.jm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<User, Integer> {
	User findById(int id);
}
