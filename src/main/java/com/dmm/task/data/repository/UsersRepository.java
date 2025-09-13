package com.example.task.data.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.task.data.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {
	@Query("select a from Tasks a where a.date between :from and :to and name = :name")
	List<Tasks> findByDateBetween(@Param("from") LocalDateTime from, @Param("to") LocalDateTime to, @Param("name") String name);
	


}