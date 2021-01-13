package com.jm.dao;

import com.jm.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionsDao extends JpaRepository<Permission, Integer> {
	Permission findById(int id);
}
