package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]){
		new Server().startServer();
	}
	public void startServer(){
		try {
			ServerSocket ss=new ServerSocket(8081);
			Socket socket=ss.accept();
			InputStream is = socket.getInputStream();
			InputStreamReader isr =new InputStreamReader(is);
			BufferedReader br =new BufferedReader(isr);
			String info =null;
			
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			while((info=br.readLine())!=null){
				System.out.println("Hello,我是服务器，客户端说："+info);	
				pw.write("Hello World！");
				pw.flush();
			}
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
