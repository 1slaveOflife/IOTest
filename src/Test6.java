public class Test6 {

        public static void main(String[] args){
            System.out.print("请输入整数：");
            long num = 473398607161l*4511491l;
            String a = "";//用字符串拼接
            while(num!=0) {//利用十进制转二进制除2法
                a=num%2+a;
                num=num/2;
            }
            System.out.println(a);


    }
}
