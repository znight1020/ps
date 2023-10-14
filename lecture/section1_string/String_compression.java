package lecture.section1_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class String_compression {
    public String solution(String str){
        int cnt, i = 0;
        char target;
        ArrayList<Character> reArr = new ArrayList<>();
        ArrayList<Integer> iArr = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str + " ");

        while(i < str.length()){
            target = sb.charAt(i);
            cnt = 0;
            for(int n = i; n < str.length() + 1; n++){
                if(sb.charAt(n) == target){
                    cnt++;
                }
                else {
                    reArr.add(target);
                    iArr.add(cnt);
                    i += cnt - 1;
                    break;
                }
            }
            i++;
        }

        str = "";
        for(int k = 0; k < reArr.size(); k++){
            str += reArr.get(k);
            if(iArr.get(k) != 1) str += iArr.get(k);
        }

        return str;
    }

    public static void main(String[] args) throws IOException {
        String_compression s = new String_compression();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(s.solution(str));
    }
}
