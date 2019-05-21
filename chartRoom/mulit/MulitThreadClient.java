package mulit;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/8
 * @Description: 基于多线程的客户端
 * @Version: 1.0
 */

/**
 * 读取服务器发来的信息
 */
class ReadFromServer implements Runnable{
    private Socket client;

    public ReadFromServer(Socket client)  {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //获取输入流来取得服务器发来的信息
            Scanner in = new Scanner(client.getInputStream());
            while(true){
                if(client.isClosed()){
                    System.out.println("客户端已关闭");
                    in.close();
                    break;
                }
                if(in.hasNext()){
                    //一次读取一行
                    String msg = in.nextLine();
                    System.out.println("服务器发来的信息为："+msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

/**
 * 向服务器发送信息线程
 */

class SendMsgToServer implements Runnable{
    private Socket client;

    public SendMsgToServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //获取输出流向服务器发送信息
            PrintStream printStream =
                    new PrintStream(client.getOutputStream(),true,"UTF-8");
            //键盘输入客户端向服务器发送的信息
            Scanner in = new Scanner(System.in);
            while (true){
                System.out.println("请输入要向服务器发送的信息..");
                String strFromUser = "";
                if (in.hasNext()){
                    strFromUser = in.nextLine();
                    System.out.println("客户端输入："+strFromUser);
                }
                //向服务器发送消息
                printStream.println(strFromUser);
                //判断退出，字符串包含bye
                if (strFromUser.contains("bye")){
                    System.out.println("客户端退出聊天室");
                    printStream.close();
                    in.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MulitThreadClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1",6666);
        Thread readThread = new Thread(new ReadFromServer(client));
        Thread sendThread = new Thread(new SendMsgToServer(client));
        readThread.start();
        sendThread.start();
    }
}
