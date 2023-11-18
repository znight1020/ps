package swea.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 간단한_369게임 {
    public void solution(){

    }
    public static void main(String[] args) throws IOException {
        간단한_369게임 g = new 간단한_369게임();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] a;
        String str;
        for(int i = 1; i <= n; i++){
            str = String.valueOf(i);
            str = str.replaceAll("[3, 6, 9]", "-");
            a = str.toCharArray();

            if(str.contains("-")){
                for(int j = 0; j < a.length; j++){
                    if(a[j] == '-') System.out.print('-');
                }
            }
            else System.out.print(str);

            System.out.print(" ");
        }

    }
}
