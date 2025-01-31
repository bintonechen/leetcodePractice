/**
 * Date: 2025/1/31 15:50
 * https://kamacoder.com/problempage.php?pid=1064
 */

package String;

import java.util.Scanner;

public class KamaCoder54 {


    public class Main {

        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            String answer = replaceInt(s);
            System.out.println(answer);

            sc.close();
        }

        // StringBuilder approach
        public static String replaceInt(String s) {

            char[] original = s.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (char c : original) {
                if (Character.isDigit(c)) {
                    sb.append("number");
                } else {
                    sb.append(c);
                }
            }

            String answer = sb.toString();
            return answer;
        }

        // two-pointer approach
        public static String replaceInt2(String s) {

            int oldLength = s.length();
            int newLength = oldLength;

            for(int i = 0; i<oldLength; i++){
                if(Character.isDigit(s.charAt(i))){
                    newLength += 5;
                }
            }

            char [] newString = new char[newLength];
            char [] oldString = s.toCharArray();

            oldLength--;
            newLength--;

            while(newLength>=0){
                if(!Character.isDigit(oldString[oldLength])){
                    newString[newLength] = s.charAt(oldLength);
                    newLength--;
                    oldLength--;
                } else {
                    newString[newLength] = 'r';
                    newString[newLength-1] = 'e';
                    newString[newLength-2] = 'b';
                    newString[newLength-3] = 'm';
                    newString[newLength-4] = 'u';
                    newString[newLength-5] = 'n';
                    newLength-=6;
                    oldLength--;
                }
            }
            return new String(newString);
        }
    }


}
