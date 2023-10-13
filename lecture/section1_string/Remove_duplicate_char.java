package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Remove_duplicate_char {

    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);
        ArrayList<Character> charArr = new ArrayList<>();
        int i = 0;

        while(i < str.length()){
            if(!charArr.contains(sb.charAt(i))){
                charArr.add(sb.charAt(i));
            }
            i++;
        }
        str = "";
        for(i = 0; i < charArr.size(); i++){
            str += charArr.get(i);
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        Remove_duplicate_char r = new Remove_duplicate_char();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        str = r.solution(str);
        System.out.println(str);
    }
}