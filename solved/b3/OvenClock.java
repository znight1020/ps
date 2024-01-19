package b3;

import java.util.Scanner;

public class OvenClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int plus = sc.nextInt();

        int time = minute + plus;

        while(time >= 60){
            if(time >= 60) {
                time -= 60;
                hour++;
            }
        }

        if(hour >= 24){
            hour -= 24;
        }

        System.out.print(hour + " " + time);
    }
}
