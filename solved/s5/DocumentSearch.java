package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DocumentSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        boolean flag;

        char[] charDocument = document.toCharArray();
        char[] charWord = word.toCharArray();

        int start = 0, answer = 0;
        while(start + charWord.length <= charDocument.length){
            flag = true;
            for(int i = start; i < charDocument.length;) {
                for (int j = 0; j < charWord.length; j++) {
                    if (charDocument[i + j] != charWord[j]) flag = false;
                    if (!flag) break;
                }
                if (flag) {
                    answer++;
                    start += charWord.length;
                }
                else {
                    start++;
                }
                break;
            }
        }
        System.out.print(answer);
    }
}
