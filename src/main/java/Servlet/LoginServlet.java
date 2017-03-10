package Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBCEntity.Message;
import service.checkService;

/**
 * Servlet implementation class ServletLogin
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private checkService cs = new checkService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Message msg = new Message();
		System.out.println(1);
		if(username == null || password == null){
			msg.setMsg("用户名或者密码为空");
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			System.out.println(2);
			return;
		}
		
		boolean flag = cs.find(username,password);
		if(flag){
			msg.setMsg("登陆成功");
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			System.out.println(3);
			return;
		}else{
			msg.setMsg("用户名或者密码错误");
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			System.out.println(4);
			System.out.println(msg);
			return;
		}
		
	}

}
