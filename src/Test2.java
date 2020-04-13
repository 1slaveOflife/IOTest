import java.io.*;

public class Test2 {
    public static void main(String args[]) throws Exception {

        String rederPath="E:\\浏览器下载\\开发工具\\图片.png";
        String writerPath="E:\\1.png";

        FileInputStream fin = new FileInputStream(rederPath);
        FileOutputStream fout=new FileOutputStream(writerPath);

        BufferedInputStream bin=new BufferedInputStream(fin);
        BufferedOutputStream bout=new BufferedOutputStream(fout);

        int len=0;
        byte[] b=new byte[1024];

        while((len=bin.read(b))!=-1)
        {
            bout.write(b,0,len);
        }

        bin.close();
        bout.close();
    }
}
