package org.cit.shoppinglist.dao;

import java.util.List;

import org.cit.shoppinglist.model.Employee;

//CRUD operations
public interface EmployeeDao {
	//Create
	public void save(Employee employee);
	//Read
	public Employee getById(int id);
	//Update
	public void update(Employee employee);
	//Delete
	public void deleteById(int id);
	//Get All
	public List<Employee> getAll();
}
