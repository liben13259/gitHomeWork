<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.io.FileInputStream"%>
    <%@page import="java.io.FileOutputStream"%>
    
    <%@page import="java.io.BufferedInputStream"%>
    <%@page import="java.io.BufferedOutputStream"%>


    <%@page import="java.io.InputStream"%>   
    <%@page import="java.net.URL"%>
    <%@page import ="java.net.URLConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
<script type="text/javascript">
	function show(){
		<%

		URL url = new URL("http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg");
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);			
		FileOutputStream fos = new FileOutputStream("new_picture.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);			
		byte[] input = new byte[1];	
		while (bis.read(input)!=-1)			
			bos.write(input);
		%>
		alert("download ok!");
		<%	bos.close();
		fos.close();
		bis.close();
		is.close();		
       %>

	}
</script>
</head>
<body>
	<img src="http://www.k73.com/up/allimg/120906/22-120Z6140234L9.jpg" height="500" width="600">
	<button type="button" onclick="show()">下载</button>
	
	
</body>
</html>