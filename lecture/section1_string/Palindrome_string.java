package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_string {

    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);

        String reverseStr = String.valueOf(sb.reverse());

        boolean flag;

        if(reverseStr.toUpperCase().equals(str.toUpperCase())){
            flag = true;
        } else flag = false;

        if(flag == true) return "YES";
        else return "NO";
    }
    public static void main(String[] args) throws IOException {
        Palindrome_string p = new Palindrome_string();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = p.solution(str);

        System.out.println(str);
    }
}
