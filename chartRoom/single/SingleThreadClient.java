package single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/8
 * @Description: single
 * @Version: 1.0
 */
public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",6666);
        Scanner scanner = new Scanner(socket.getInputStream());
        if (scanner.hasNext()){
            System.out.println("服务器"+scanner.nextLine());
        }
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.print("hello i am client");
        scanner.close();
        printStream.close();
        socket.close();
    }
}
