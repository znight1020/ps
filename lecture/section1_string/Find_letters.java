package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Find_letters {
    public int solution(String str, char c){
        int i = 0, cnt = 0;
        while(i < str.length()) {
            if(str.charAt(i) == Character.toLowerCase(c) || str.charAt(i) == Character.toUpperCase(c)) cnt++;
            i++;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        Find_letters f = new Find_letters();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = br.readLine().charAt(0);
        System.out.println(f.solution(str, c));
    }
}
