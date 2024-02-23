package solved.s2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargePhDRestaurant {
    static int[] challengeCost;
    static int[] challengeReward;
    static int money;
    static int challengeCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        challengeCount = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());

        challengeCost = new int[challengeCount];
        challengeReward = new int[challengeCount];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < challengeCount; i++){
            challengeCost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < challengeCount; i++){
            challengeReward[i] = Integer.parseInt(st.nextToken());
        }




    }
}
