package lecture.section2_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Peaks {
    public int solution(int num, int[][] map){
        int i, j, peak = 0;
        for(i = 1; i < num - 1; i++){
            for(j = 1; j < num - 1; j++){
                if(map[i][j] > map[i+1][j] && map[i][j] > map[i-1][j] &&
                        map[i][j] > map[i][j+1] && map[i][j] > map[i][j-1])
                    peak++;
            }
        }
        return peak;
    }
    public static void main(String[] args) throws IOException {
        Peaks p = new Peaks();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, num = Integer.parseInt(br.readLine()) + 2;
        int[][] map = new int[num][num];
        String str;
        StringTokenizer st;
        for(i = 1; i < num - 1; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(j = 1; j < num - 1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(p.solution(num, map));
    }
}
