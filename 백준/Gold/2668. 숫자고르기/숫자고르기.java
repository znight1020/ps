import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    static int[] arr;
    static List<Integer> numbers = new ArrayList<>();
    static int numbersSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            numbersSize = 0;
            dfs(new ArrayList<>(), new ArrayList<>(), i);
        }
        List<Integer> answerNumberList = numbers.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(answerNumberList.size());
        for(int num : answerNumberList) {
            System.out.println(num);
        }
    }

    static void dfs(List<Integer> idxList, List<Integer> numberList, int currentIdx) {
        if (idxList.contains(currentIdx)) {
            if (idxList.size() > numbersSize && checkEquals(idxList, numberList)) {
                numbersSize = idxList.size();
                numbers.addAll(numberList);
            }
            return;
        }

        idxList.add(currentIdx);
        numberList.add(arr[currentIdx]);

        dfs(idxList, numberList, arr[currentIdx]);
    }

    static boolean checkEquals(List<Integer> idxList, List<Integer> numberList) {
        for (Integer integer : idxList) {
            if (!numberList.contains(integer)) {
                return false;
            }
        }
        return true;
    }
}
