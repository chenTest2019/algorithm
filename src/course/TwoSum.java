package course;

public class TwoSum {
    public static void main(String[] args) {
        String a="456";
        String b="1234";
        //两数字之和

        int add=0;
        int i=a.length()-1;
        int j=b.length()-1;
        StringBuilder stringBuilder=new StringBuilder();
        int temp=0;
        int a1=0;
        int a2=0;
        while(i>=0||j>=0){
            a1=i>=0?a.charAt(i)-'0':0;
            a2=j>=0?b.charAt(j)-'0':0;

            temp=(a1+a2+add)%10;
            add=(a1+a2+add)/10;

            stringBuilder.append(temp);

            i--;
            j--;

        }
        System.out.println(stringBuilder.reverse());
    }
}
