package Servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBCEntity.jdbc;
import service.checkService;

/**
 * Servlet implementation class checkServlet
 */
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private checkService cs = new checkService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Long uId = Long.parseLong(id);
		
		ResultSet rs = cs.save(uId);
		
		List<jdbc> list = new ArrayList<jdbc>(); 
		
		try {
			while(rs.next()){
				
				jdbc j = new jdbc();
				
				j.setAddress_id(uId);
				
				j.setAddress_name(rs.getString("address_name"));
				
				j.setName(rs.getString("name"));
				
				j.setHobby(rs.getString("hobby"));
				
				j.setUser_id(rs.getLong("user_id"));
				
				list.add(j);
			
			}
			
			request.setAttribute("list", list);
				
			RequestDispatcher rd = request.getRequestDispatcher("/03/table.jsp");
			
			rd.forward(request, response);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		}
		
		
	}

}
