package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Flip_specific_char {
    public String solution(String str){
        StringBuilder sb = new StringBuilder(str);
        int i = 0;

        ArrayList<Integer> indexArr = new ArrayList<>();
        Stack<Character> charArr = new Stack<>();

        while(i < str.length()){
            if((sb.charAt(i) >= 65 && sb.charAt(i) <= 90) || (sb.charAt(i) >= 97 && sb.charAt(i) <= 122)) {
                indexArr.add(i);
                charArr.add(sb.charAt(i));
            }
            i++;
        }

        for(i = 0; i < indexArr.size(); i++){
            sb.setCharAt(indexArr.get(i), charArr.pop());
        }

        str = sb.toString();
        return str;
    }
    public static void main(String[] args) throws IOException {
        Flip_specific_char f = new Flip_specific_char();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = f.solution(str);

        System.out.println(str);
    }
}
