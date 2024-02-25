package solved.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class NumberOfVowels {
    static char[] check = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] temp;
        while(true){
            int cnt = 0;
            temp = br.readLine().toLowerCase().toCharArray();
            if(temp[0] == '#') break;
            for(int i = 0; i < temp.length; i++) for(int j = 0; j < check.length; j++) if(temp[i] == check[j]) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
