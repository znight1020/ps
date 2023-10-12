package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Word_in_sentence {
    public String solution(String str){
        StringTokenizer st = new StringTokenizer(str);
        int len = 0;
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(len < token.length()){
                str = token;
                len = token.length();
            }
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        Word_in_sentence w = new Word_in_sentence();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(w.solution(str));
    }
}
