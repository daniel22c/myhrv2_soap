package com.example.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.example.model.Employee;
import com.example.model.EmployeeEJB;

@WebService
@Stateless
public class EmployeeWS {
	@Inject
	EmployeeEJB ejb;
	public String helloWorld(@WebParam String name) {
		System.out.println("########"+name);
		return "hello "+name;
	}
	
	@WebMethod(operationName="search")
	public Employee findById(@WebParam(name="emp_id") int id) {
		Employee emp = ejb.find(id);
		return emp;
	}
}
