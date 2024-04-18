import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] price = new int[5];
    static int lessValue = 0, moreValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++) price[i] = Integer.parseInt(st.nextToken());

        duplicateCombLess(0,0, 0);
        duplicateCombMore(0,0, 0, new ArrayList<>());
        System.out.print(Math.max(lessValue, moreValue));
    }

    static void duplicateCombLess(int L, int sum, int difficult){
        if(L > 4 || difficult > 10) return;
        lessValue = Math.max(lessValue, sum);
        for(int i = 0; i < 5; i++) duplicateCombLess(L+1, sum + price[i], difficult + i+1);
    }
    static void duplicateCombMore(int L, int sum, int difficult, ArrayList<Integer> arr){
        if(difficult > 15) return;
        if(L >= 4) moreValue = Math.max(moreValue, sum);

        for(int i = 0; i < 5; i++) duplicateCombMore(L+1, sum + price[i], difficult + i+1, arr);
    }
}
