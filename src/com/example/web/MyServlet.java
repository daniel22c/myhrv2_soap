package com.example.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.Employee;
import com.example.model.EmployeeEJB;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet({ "/hr", "/my" })
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    EmployeeEJB ejb;
    
//    @Inject
    Employee emp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * }
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		int id=0;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int did=Integer.parseInt(request.getParameter("did"));
		String action=request.getParameter("action");
		
		String resp="";
		HttpSession session = request.getSession();
		switch(action.toLowerCase()) {
			case "insert":
//				e=new Employee(id,name,salary);
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				resp=ejb.insert(emp);
	//			request.setAttribute("result", resp);
	//			request.setAttribute("emp", e);
				session.setAttribute("result", resp);
				session.setAttribute("emp", emp);
				request.getRequestDispatcher("result.jsp").forward(request, response);
				break;
			case "update":
//				emp=new Employee(id,name,salary);
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				if(ejb.update(emp)) {
					session.setAttribute("result", resp);
					session.setAttribute("emp", emp);
					request.getRequestDispatcher("result.jsp").forward(request, response);
				}
				break;
			case "find":
				Employee emp=ejb.find(id);
//				System.out.println("****"+s);
//				String[] empDetail=s.split(":");// delimiters
//				name=empDetail[1];
//				salary=Double.parseDouble(empDetail[2]);
//				Employee e1=new Employee(id,name,salary);
	//			request.setAttribute("emp", e1);
				session.setAttribute("emp", emp);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case "delete":
				ejb.delete(id);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	
	}

}
