package liben.day03;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;


public class App {
	public static void main(String[] args) {
		try {
			
			URL url = new URL("http://www.madore.org/~david/math/padics.pdf");
			URLConnection uc = url.openConnection();
			
			InputStream is = uc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			FileOutputStream fos = new FileOutputStream("new_padics.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte b[] = new byte[100];
			int count = 0;
			while(bis.read(b) != -1){
				bos.write(b);
				count++;
			}
			System.out.println("一共复制了"+count+"次");
			bis.close();
			bos.close();
			is.close();
			fos.close();
			System.out.println("已经完成了！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
