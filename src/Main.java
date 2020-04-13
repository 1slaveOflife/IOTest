import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public  static void main(String args[])
    {

        try {
            FileInputStream input = new FileInputStream("E:\\test.txt");
            int len=0;
// read() 从此输入流中读取一个数据字节。
// read(byte[] b) 从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中。
            while (len!=-1)
            {
                byte[] b = new byte[16];
                len=input.read(b);
// 打印
                String str=new String(b,"gbk");

                System.out.println(str);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
