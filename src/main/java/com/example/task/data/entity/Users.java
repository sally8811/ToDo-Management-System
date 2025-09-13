package com.example.task.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "password") 
public class Users {
	@Id
	public String userName;
	public String password;
	public String name;
	public String roleName;
}

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private LocalDateTime dueAt;

    
    @ManyToOne
    @JoinColumn(name = "user_id")  
}