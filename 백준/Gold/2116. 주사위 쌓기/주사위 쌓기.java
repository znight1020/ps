import java.util.*;
import java.io.*;

public class Main {

    static int N, answer = 0;
    static int[] diceNumbers = new int[]{1,2,3,4,5,6};
    static List<Dice> dices = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int[] side1 = new int[]{a, f};
            int[] side2 = new int[]{b, d};
            int[] side3 = new int[]{c, e};

            Dice dice = new Dice();
            dice.sides.addAll(List.of(side1, side2, side3));
            dices.add(dice);
        }

        Dice firstDice = dices.get(0);
        for (int[] sides : firstDice.sides) {
            dfs(sides[0], 1, maxNumber(sides));
            dfs(sides[1], 1, maxNumber(sides));
        }

        System.out.println(answer);
    }

    static void dfs(int upside, int n, int sum) {
        if(n == dices.size()) {
            if(sum > answer) answer = sum;
            return;
        }

        Dice dice = dices.get(n);

        for(int i = 0; i < 3; i++) {
            int[] sidePair = dice.sides.get(i);
            if(upside == sidePair[0]) dfs(sidePair[1], n+1, sum + maxNumber(sidePair));
            else if(upside == sidePair[1]) dfs(sidePair[0], n+1, sum + maxNumber(sidePair));
        }
    }

    static int maxNumber(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : diceNumbers) {
            if(num != arr[0] && num != arr[1]) max = Math.max(num, max);
        }
        return max;
    }

    static class Dice {
        List<int[]> sides = new ArrayList<>();
    }
}
