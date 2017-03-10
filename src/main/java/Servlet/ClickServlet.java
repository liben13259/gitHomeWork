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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClickServlet
 */
public class ClickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClickServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = (String)request.getAttribute("url");
		try {
			URL u = new URL(url);
			URLConnection uc = u.openConnection();
			
			InputStream is = uc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			FileOutputStream fos = new FileOutputStream("new_picther.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte b1[] = new byte[100];
			int count = 0;
			while(bis.read(b1) != -1){
				bos.write(b1);
				count++;
			}
			System.out.println("一共复制了"+count+"次。");
			bis.close();
			bos.close();
			is.close();
			fos.close();
			System.out.println("已经完成了！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

}
