package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Flip_words {
    public String[] solution(String[] strArr){
        StringBuilder sb;
        for(int i = 0; i < strArr.length; i++){
            sb = new StringBuilder(strArr[i]);
            strArr[i] = sb.reverse().toString();
        }
        return strArr;
    }
    public static void main(String[] args) throws IOException {
        Flip_words f = new Flip_words();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int i = 0;
        String[] strArr = new String[num];
        while(i < num){
            strArr[i] = br.readLine();
            i++;
        }

        f.solution(strArr);
        for(i = 0; i < strArr.length; i++){
            System.out.println(strArr[i]);
        }
    }
}
