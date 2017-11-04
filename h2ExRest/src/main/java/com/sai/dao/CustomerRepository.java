package com.sai.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sai.model.Customer;

@Component
@Repository
public class CustomerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//find all customers using rowMapper
	
	public List<Customer> findAll(){
		List<Customer> result = jdbcTemplate.query("select id, name, email, created_date from customer",
				(rs,rowNum)-> new Customer(rs.getInt("id"),
						rs.getString("name"),rs.getString("email"),rs.getDate("created_date"))
				);
		return result;
	}
	
	public void addCustomer(String name, String email) {
		jdbcTemplate.update("Insert into customer (name,email, created_date) values (?,?,?)",
				name,email,new Date());
	}
}
