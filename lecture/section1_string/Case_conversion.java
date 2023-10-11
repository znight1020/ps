package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Case_conversion {
    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) >= 97) sb.setCharAt(i, Character.toUpperCase(str.charAt(i)));
            else sb.setCharAt(i, Character.toLowerCase(str.charAt(i)));
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        Case_conversion c = new Case_conversion();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(c.solution(str));
    }
}
