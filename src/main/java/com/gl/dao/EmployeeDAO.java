package com.gl.dao;

import java.util.List;

import com.gl.model.Employee;
	
public interface EmployeeDAO {
	
	public void addEmployee(Employee e);
	public void deleteEmployeeById(int eid);
	public void updateEmployeeById(Employee employee);
	
	public List<Employee> getEmployeeList();
	public Employee getEmployeeById(int eid);

}
