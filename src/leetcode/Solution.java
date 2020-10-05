package leetcode;
/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Random;

class Solution {
    private static boolean debug;
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.addStrings("35829",  "498989"));
        //System.out.println(solution.addStrings("119019",  "2193"));
        debug=false;

        if(debug){
            Random random = new Random();
            int count=random.nextInt(20)+5000000;

            for (int i = 0; i < count; i++) {
                int a = random.nextInt(200000);
                int b = random.nextInt(500000);
                String s = solution.addStrings(a + "", b + "");
                if(!s.equals((a+b)+"")){
                    System.out.println("计算："+s+"\t实际"+(a+b));
                    System.out.println("num1:"+a);
                    System.out.println("num2:"+b);
                    return ;
                }
            }
        }


    }
    public String addStrings(String num1, String num2) {
        if(num1==null||num1.length()==0){
            return num2;
        }
        if(num2==null||num2.length()==0){
            return num1;
        }

        int len1=num1.length();
        int len2=num2.length();
        StringBuilder s=new StringBuilder();

        //防止写多个if判断
        if(len1<len2){
            int temp=len1;
            String tempStr=num1;

            len1=len2;
            len2=temp;

            num1=num2;
            num2=tempStr;

        }

        int bit=0;
        int i=0;
        for (; i <len2; i++) {
            int a=num1.charAt(len1-i-1)-'0';
            int b=num2.charAt(len2-i-1)-'0';

            int d=(a+b+bit)%10;
            bit =(a+b+bit)/10;

            s.append(d);
        }
        if(i==len1&&bit>0){
            return s.append(bit).reverse().toString();
        }
        for(;i<len1;i++){
            int a=num1.charAt(len1-i-1)-'0';
            int d=(a+bit)%10;
            bit =(a+bit)/10;
            s.append(d);
        }
        if(bit>0){
            return s.append(bit).reverse().toString();
        }
        return s.reverse().toString();
    }
}