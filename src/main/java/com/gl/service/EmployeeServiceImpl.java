package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeDAO;
import com.gl.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO edao;
	
	@Override
	public void addEmployee(Employee e) {
		edao.addEmployee(e);

	}

	@Override
	public void deleteEmployeeById(int eid) {
		edao.deleteEmployeeById(eid);

	}

	@Override
	public void updateEmployeeById(Employee employee) {
		edao.updateEmployeeById(employee);

	}

	@Override
	public List<Employee> getEmployeeList() {
		
		return edao.getEmployeeList();
	}

	@Override
	public Employee getEmployeeById(int eid) {
		
		return edao.getEmployeeById(eid);
	}

}
