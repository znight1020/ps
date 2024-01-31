package swea;

public class 조합 {
    static int[] arr = new int[5];
    static int[] targetArr = new int[3];
    public static void main(String[] args) {
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

        comb(0, 0);
    }

    static void comb(int start, int cnt){
        if(cnt == targetArr.length) {
            for(int x : targetArr){
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < arr.length; i++){
            targetArr[cnt] = arr[i];
            comb(i+1, cnt+1);
        }
    }
}
