package com.boot.database.test2repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.database.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
        
}
