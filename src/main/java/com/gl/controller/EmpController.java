package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.model.Employee;
import com.gl.service.EmployeeService;

@Controller

public class EmpController {
	
	@Autowired
	EmployeeService eser;
	
	@RequestMapping("/list")
	public String goList(@ModelAttribute("emp") Employee emp, Model m) {
		m.addAttribute("list", eser.getEmployeeList());
		m.addAttribute("emp",new Employee());

		return "listEmp";
		
	}
	
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Model m) {
		m.addAttribute("emp",new Employee());
		return "addEmployee";
	}
	

	@RequestMapping("/processAddEmp")
	public String processAddEmp(@ModelAttribute("emp") Employee emp ,Model m) {
		eser.addEmployee(emp);
		return "redirect:/list";
		
	}
	
	
	@PostMapping("/deleteEmpById")
	public String deleteEmpById(@RequestParam("eid") int eid) {
		eser.deleteEmployeeById(eid);
		return "redirect:/list";
	}
	
	
	@PostMapping("/updateEmpById")
	public String updateEmpById(@RequestParam("eid") int eid, Model m){
		m.addAttribute("emp",eser.getEmployeeById(eid));
		return "updateEmployee";
	}
	
	
	@PostMapping("/processUpdateEmp")
	public String processUpdateEmp(@ModelAttribute("emp") Employee emp) {
		eser.updateEmployeeById(emp);
		return "redirect:/list";
	}
	
}
