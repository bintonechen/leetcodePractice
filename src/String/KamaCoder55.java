/**
 * Date: 2025/2/10 08:43
 * https://lekamacoder.com/problempage.php?pid=1065
 */

package String;

import java.util.Scanner;

public class KamaCoder55 {

    public class Main {
        public static void main(String[] args){

            // input n and k
            Scanner sc = new Scanner(System.in);
            int n = Integer.parseInt(sc.nextLine());
            String k = sc.nextLine();
            sc.close();

            // using approach 1 with StringBuilder
            String answer = rearrangeString1(n,k);
            System.out.println(answer);

            // using approach 2 with array reversal
            // String answer = rearrangeString2(n,k);
            // System.out.println(answer);
        }

        // approach 1 with StringBuilder
        public static String rearrangeString1 (int n, String k){

            int length = k.length();
            int digit = length - n;
            StringBuilder sb = new StringBuilder();

            for(int i = digit; i<length; i++){
                sb.append(k.charAt(i));
            }

            sb.append(k,0,digit);

            return sb.toString();
        }

        // approach 2 with array reversal

        public static String rearrangeString2 (int n, String k){

            int length = k.length();

            char[] ch = k.toCharArray();
            reverseArray(ch,0,length-1);
            reverseArray(ch,0,n-1);
            reverseArray(ch,n,length-1);


            String answer = new String(ch); // '.toString()' on char[] would return memory reference
            return answer;
        }

        // helper function
        public static void reverseArray(char[] ch, int start, int end){

            while(start<end){
                char temp = ch[start];
                ch[start]= ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }

    }
}
