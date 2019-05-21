package single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/8
 * @Description: single
 * @Version: 1.0
 */
public class SingleThreadServer {
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器端口建立成功");
        System.out.println("等待客户端连接");
        Socket socket = serverSocket.accept();
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("hello i im server");
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户端："+scanner.nextLine());
        }
        printStream.close();
        scanner.close();
        serverSocket.close();

    }
}
