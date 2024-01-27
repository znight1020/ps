package solved.s5;

public class SelfNumber {
    public static void main(String[] args) {
        boolean[] n = new boolean[10001];
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int sum, indexNum;

        while(i < 10000){
            sum = i; indexNum = i;
            while(indexNum != 0){
                sum += indexNum % 10;
                indexNum /= 10;
            }
            if (sum < 10001) n[sum] = true;
            i++;
        }

        for(i = 1; i < n.length; i++) if(!n[i]) sb.append(i).append("\n");
        System.out.print(sb);
    }
}
