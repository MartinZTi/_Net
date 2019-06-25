package TCP.Demo05BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 模拟B\S服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        String[] arr = line.split(" ");
        String htmlpath = arr[1].substring(1);

        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os = socket.getOutputStream();
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        //必须要写空行,否则浏览器不解析
        os.write("\r\n".getBytes());

        //一行一行复制文件
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            os.write(bytes,0,len);
        }

        //释放资源
        fis.close();
        socket.close();
        server.close();
    }

}
