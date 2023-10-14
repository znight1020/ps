package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Password {
    public String solution(int num, String str){
        int i, j, alpha, iter;
        char c;
        str = str.replace('#', '1');
        str = str.replace('*', '0');

        int[] bArr = new int[str.length()];
        for(i = 0; i < bArr.length; i++){
            bArr[i] = str.charAt(i) - '0';
        }

        str = "";

        for(i = 0; i < num; i++){
            iter = 0;
            alpha = 0;
            for(j = (i + 1) * 7 - 1; j >= i * 7; j--){
                alpha += bArr[j] * (int)(Math.pow(2, iter));
                iter++;
            }
            c = (char)alpha;
            str += c;
        }
        return str;
    }
    public static void main(String[] args) throws IOException {
        Password p = new Password();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(p.solution(num, str));
    }
}
