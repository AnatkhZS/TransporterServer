import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Test {
	public static void main(String args[]){
		new Test().startClient();
	}
	public void startClient(){
		try {
			Socket socket=new Socket("127.0.0.1",8081);
			OutputStream os = socket.getOutputStream();//字节输出流
			PrintWriter pw =new PrintWriter(os);//将输出流包装成打印流
			pw.write("hello");
			pw.flush();
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println("Hello,我是客户端，服务器说："+info);
			}
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
