package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbOperations {
	@Autowired
	JdbcTemplate jdbcTemplate;
}
