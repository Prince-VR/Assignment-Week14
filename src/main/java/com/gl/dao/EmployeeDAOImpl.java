package com.gl.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.model.Employee;


@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

	SessionFactory sf;
	Session session;
	
	@Autowired
	public EmployeeDAOImpl(SessionFactory sf) {
		this.sf=sf;
		this.session=sf.openSession();
	}
	
	@Override
	@Transactional
	public void addEmployee(Employee e) {
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();

	}

	@Override
	@Transactional
	public void deleteEmployeeById(int eid) {
		Transaction tx = session.beginTransaction();
		Employee e1 = getEmployeeById(eid);
		if(e1!=null) {
			session.delete(e1);
			
		}
		else {
			System.out.println("No Employee id doesn't exist");
		}
		tx.commit();

	}

	@Override
	@Transactional
	public void updateEmployeeById(Employee employee) {
		Transaction tx = session.beginTransaction();
		
		Employee newEmp = getEmployeeById(employee.getEid());
		
		newEmp.setEmpName(employee.getEmpName());
		newEmp.setEmpAdd(employee.getEmpAdd());
		newEmp.setEmpPhone(employee.getEmpPhone());
		newEmp.setEmpSalary(employee.getEmpSalary());
		
		session.save(newEmp);
		tx.commit();

	}

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> emp = session.createQuery("from Employee").list();
		return emp;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		
		return session.get(Employee.class, eid);
	}

}
