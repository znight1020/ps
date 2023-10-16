package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Flipped_prime {
    public ArrayList<Integer> solution(ArrayList<Integer> numArr, int max){
        int i, j;
        ArrayList<Boolean> eraArr = new ArrayList<>(max + 1);
        eraArr.add(false);
        eraArr.add(false);

        for(i = 2; i <= max; i++){
            eraArr.add(i, true);
        }

        for(i = 2; (i*i) <= max; i++){
            if(eraArr.get(i)){
                for(j = i*i; j <= max; j += i) eraArr.set(j, false);
            }
        }

        for(i = 0; i < numArr.size(); i++){
            if(eraArr.get(numArr.get(i)) != true) {
                numArr.remove(i);
                i--;
            }
        }

        return numArr;
    }

    public static void main(String[] args) throws IOException {
        Flipped_prime f = new Flipped_prime();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()), i = 0, max = 0;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        StringBuilder sb;

        ArrayList<Integer> numArr = new ArrayList<>();

        while(st.hasMoreTokens()){
            sb = new StringBuilder(st.nextToken());
            numArr.add(Integer.parseInt(String.valueOf(sb.reverse())));
            if(numArr.get(i) > max) max = numArr.get(i);
            i++;
        }

        numArr = f.solution(numArr, max);
        for(i = 0; i < numArr.size(); i++){
            System.out.print(numArr.get(i) + " ");
        }
    }
}
