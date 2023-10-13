package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Extract_numbers {
    public int solution(String str){
        str = str.replaceAll("[^0-9]", "");
        int num = Integer.parseInt(str);
        return num;
    }
    public static void main(String[] args) throws IOException {
        Extract_numbers e = new Extract_numbers();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(e.solution(str));
    }
}
