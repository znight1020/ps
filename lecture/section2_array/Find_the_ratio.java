package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Find_the_ratio {
    public int[] solution(int[] arr){
        int i, j, rank;
        int[] rankArr = new int[arr.length];
        for(i = 0; i < arr.length; i++){
            rank = 1;
            for(j = 0; j < arr.length; j++){
                if(arr[i] < arr[j]) rank++;
            }
            rankArr[i] = rank;
        }
        return rankArr;
    }
    public static void main(String[] args) throws IOException {
        Find_the_ratio f = new Find_the_ratio();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine()), i = 0;
        int[] arr = new int[num];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        arr = f.solution(arr);

        for(i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
