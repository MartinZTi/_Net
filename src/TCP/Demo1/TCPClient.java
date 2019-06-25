package TCP.Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
TCP 通讯的客户端: 向服务器发送连接请求,给服务器发送数据,读取服务器会写的数据
 表示客户端的类:
    java.net.Socket: 此类实现客户端套接字
    套接字: IP地址和端口号的网络单位
     */
//java.net.ConnectException: Connection refused: connect
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);
        //2.使用Socket对象的方法getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        //3.使用网络字节输出流OutputStreaam对象中的方法write,给服务器发送数据
        outputStream.write("你好服务器".getBytes());

        //4.使用Socket对象中的方法getInputStream()获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //5.使用网络字节输入流InputStream对象中的方法read, 读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));


        //6.释放资源(Socket)
        socket.close();

    }



}













