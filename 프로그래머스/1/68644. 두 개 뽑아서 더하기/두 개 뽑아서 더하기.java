import java.util.Set;
import java.util.TreeSet;

class Solution {
    Set<Integer> numList = new TreeSet<>();
    boolean[] vtd;
    int[] numbers;
    int len;
    public int[] solution(int[] numbers) {
        int[] answer;
        this.numbers = numbers;
        len = numbers.length;
        vtd = new boolean[len];
        
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                numList.add(numbers[i] + numbers[j]);
            }
        }

        return numList.stream().mapToInt(i -> i).toArray();
    }
}