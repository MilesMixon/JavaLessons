package com.skillstorm.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.beans.Owner;
import com.skillstorm.data.OwnerDAO;

//need this annotation to mark it as a servlet
@WebServlet(urlPatterns = "/api/owners", loadOnStartup = 1)
public class OwnerServlet extends HttpServlet {
	private OwnerDAO ownerDao = new OwnerDAO();
	
	//jackson gives us object mapping
	//can map our objects to json and vice-versa
	private ObjectMapper mapper = new ObjectMapper();
	
	// Servlet Lifecycle
	// lifecycle methods
	// init, service, destory
	// init: called when the servlet is initialized
	// service: called before each method in the servlet
	// destory: called when the servlet is destroyed
	
	@Override
	public void init() throws ServletException {
		//called once the servlet starts
		System.out.println("Servlet created");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//called before every method
		//intercepts the request and holds on to it
		System.out.println("Servlet Serviced");
		
		//need to to call a method to allow the request to make it to the intended method
		super.service(req, resp); //sends the message along to the intended method
	}
	
	@Override
	public void destroy() {
		//called when the servlet is destroyed
		System.out.println("Servlet destroyed");
	}
	
	
	// /api/owners?id=3
	//servlet methods
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp); //throws a 405 by default
		
		System.out.println("Get Method Called");
		
		//resp.getWriter().print("Hello World");
		//resp.getWriter().print("{ \"data\": {} }");
		
		if (req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			Owner owner = ownerDao.getById(id);
			resp.setContentType("application/json");
			resp.getWriter().print(mapper.writeValueAsString(owner));
		} else {
			List<Owner> owners = ownerDao.getAllOwners();
			
			//need to tell it what the response is
			resp.setContentType("application/json");
			//converts our object to a string, then to json
			resp.getWriter().print(mapper.writeValueAsString(owners));
		}
		
//		String param = req.getParameter("id");
//		Map<String, String[]> params = req.getParameterMap();
//		
//		System.out.println(param);
//		
//		for (String key : params.keySet()) {
//			String[] temp = params.get(key);
//			for (String val : temp) {
//				System.out.println(String.format("%s: %s", key, val));
//			}
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Post method called");
		
		InputStream requestBody = req.getInputStream();
		Owner owner = mapper.readValue(requestBody, Owner.class);
		Owner updatedOwner = ownerDao.addOwner(owner);
		
		resp.setContentType("application/json");
		resp.getWriter().print(mapper.writeValueAsString(updatedOwner));
		//201: CREATED
		resp.setStatus(201); //by default returns a 200: SUCCESS
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Put method called");
		InputStream requestBody = req.getInputStream();
		Owner owner = mapper.readValue(requestBody, Owner.class);
		
		ownerDao.updateOwner(owner);
		resp.setStatus(204); // 204: NO Content
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			ownerDao.deleteOwner(id);
			resp.setStatus(204);
		} else {
			resp.getWriter().print("Invalid Request");
			resp.setStatus(400);
		}
	}
}
