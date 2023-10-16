package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prime_num_eratosthenes {
    public int solution(int num){
        int i, j, cnt = 0;
        ArrayList<Boolean> eraArr = new ArrayList<>(num + 1);
        eraArr.add(false);
        eraArr.add(false);

        for(i = 2; i <= num; i++){
            eraArr.add(i, true);
        }

        for(i = 2; (i*i) <= num; i++){
            if(eraArr.get(i)){
                for(j = i*i; j <= num; j += i) eraArr.set(j, false);
            }
        }

        for(i = 0; i <= num; i++){
            if(eraArr.get(i) == true) cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Prime_num_eratosthenes p = new Prime_num_eratosthenes();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(p.solution(num));
    }
}
