package s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Virus {
    static int[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int vertex = Integer.parseInt(br.readLine());
        int[][] network = new int[vertex][vertex];

        checked = new int[vertex];

        int pairNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < vertex; i++){
               st = new StringTokenizer(br.readLine());
               for(int j = 0; j < vertex; j++){

               }
        }
    }
}
