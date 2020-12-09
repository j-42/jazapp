package com.jm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jm.model.Permission;

@Repository
public interface PermissionsDao extends JpaRepository<Permission, Integer> {
	Permission findById(int id);
}
