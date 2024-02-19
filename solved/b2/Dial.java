package solved.b2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int time = 0;
        int initTime = 2;
        for (char c : arr) {
            switch (c) {
                case 'A', 'B', 'C' -> time += initTime + 1;
                case 'D', 'E', 'F' -> time += initTime + 2;
                case 'G', 'H', 'I' -> time += initTime + 3;
                case 'J', 'K', 'L' -> time += initTime + 4;
                case 'M', 'N', 'O' -> time += initTime + 5;
                case 'P', 'Q', 'R', 'S' -> time += initTime + 6;
                case 'T', 'U', 'V' -> time += initTime + 7;
                case 'W', 'X', 'Y', 'Z' -> time += initTime + 8;
            }
        }
        System.out.print(time);
    }
}
