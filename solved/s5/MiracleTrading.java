package solved.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MiracleTrading {
    static int[] stock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        stock = new int[14];

        int cash = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < stock.length; i++){
            stock[i] = Integer.parseInt(st.nextToken());
        }

        int bnp = bnp(cash);
        int three = threeee(cash);

        if(bnp > three) System.out.print("BNP");
        else if(bnp < three) System.out.print("TIMING");
        else System.out.print("SAMESAME");

    }

    static int bnp(int cash){
        int revenue = 0;
        int i = 0;

        while(cash > 0 && i < stock.length){
            if(cash / stock[i] > 0) {
                revenue += cash / stock[i];
                cash %= stock[i];
            }
            i++;
        }
        return cash + revenue * stock[13];
    }
    static int threeee(int cash){
        int revenue = 0;
        int upCnt = 1, downCnt = 1, i = 1;
        while(i < stock.length){
            if(upCnt >= 3) {
                cash += revenue * stock[i]; // 3일 이상 전일 대비 상승 = 전량 매도
                revenue = 0;
            }
            if(downCnt >= 3){ // 3일 이상 전일 대비 하락 = 전량 매수
                revenue += cash / stock[i];
                cash %= stock[i];
            }

            if(stock[i-1] < stock[i]) {
                upCnt++; // 전날 대비 상승
                downCnt = 1;
            }
            if(stock[i-1] > stock[i]){
                downCnt++; // 전날 대비 하락
                upCnt = 1;
            }
            i++;

        }
        if(revenue != 0) cash += revenue * stock[13];

        return cash;
    }
}
