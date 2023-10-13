package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Valid_palindrome {
    public String solution(String str){
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder sb = new StringBuilder(str);
        if(str.equals(sb.reverse().toString())) return "YES";
        else return "NO";
    }
    public static void main(String[] args) throws IOException {
        Valid_palindrome v = new Valid_palindrome();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(v.solution(str));
    }
}
