import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class Test5 {
    public static void main(String[] args) throws Exception {
        File file=new File("E:\\网络安全资料\\44aaac34ab1449fe8df001fcb0ec4e24.txt");
        FileInputStream in = new FileInputStream(file);
        int len=0;
        byte[] bytes=new byte[1024];
        StringBuffer stringBuffer = new StringBuffer();
        while ((len=in.read(bytes))!=-1)
        {
            stringBuffer.append(new String(bytes,0,len));
        }
       String str=stringBuffer.toString();
        str=str.replace('1','-');
        str=str.replace('0','.');
       // str=str.replace('\\','|');

        File file1 = new File("E:\\网络安全资料\\摩尔斯密码表.txt");

        FileInputStream in2 = new FileInputStream(file1);
        int len2=0;
        byte[] bytes2=new byte[1024];
        StringBuffer stringBuffer1 = new StringBuffer();
        String str2="";
        HashMap<String, String> map = new HashMap<>();
        while((len2=(in2.read(bytes2)))!=-1)
        {
            stringBuffer1.append(new String(bytes2,0,len2));
        }
        str2=stringBuffer1.toString();

        str2=str2.replaceAll("\n|\r|\t","").replace(" ","").trim();

        String[] split = str2.split(",");

        for (int i=0;i<split.length;i++)
        {
            String[] split1 = split[i].split(":");

            for (int j = 0; j < split1.length; j++) {
               // String s=split1[j];
                split1[j]=split1[j].replace("\'","").replace("\"","");
              // split1[j]= s;
            }
           map.put(split1[1],split1[0]);

        }
        map.put("---...",":");
        map.put("--..--",",");
      /*  for (String k:map.keySet()) {
            System.out.println(k+":"+map.get(k));
        }*/
        //开始查找
        String[] ciphertext = str.split("/");//密文
        String plaintext="";//明文
            for (int l = 0; l <ciphertext.length; l++) {

                for (String k:map.keySet()) {
                    if (ciphertext[l].equals(k))
                    {
                        plaintext=plaintext+map.get(k);
                    }
                }
            }

        System.out.println(plaintext);
    }
}
