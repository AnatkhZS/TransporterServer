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
			OutputStream os = socket.getOutputStream();//�ֽ������
			PrintWriter pw =new PrintWriter(os);//���������װ�ɴ�ӡ��
			pw.write("hello");
			pw.flush();
			socket.shutdownOutput();
			
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			while((info=br.readLine())!=null){
				System.out.println("Hello,���ǿͻ��ˣ�������˵��"+info);
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
