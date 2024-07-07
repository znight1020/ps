import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o1 - o2);
        
        if(score.length < k) {
            answer = new int[score.length];
            for(int i = 0; i < score.length; i++) {
                pq.add(score[i]);
                answer[i] = pq.peek();
            }
        } else {
            answer = new int[score.length];
            for(int i = 0; i < k; i++) {
                pq.add(score[i]);
                answer[i] = pq.peek();
            }
            
            for(int i = k; i < score.length; i++) {
                if(!pq.isEmpty() && (pq.peek() < score[i])) {
                    pq.poll();
                    pq.add(score[i]);
                }
                answer[i] = pq.peek();
            }
        }
        
        return answer;
    }
}