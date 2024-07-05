class Solution {
    public String solution(int n) {
        String answer = "";
        int temp = n / 2;
        n %= 2;
        for(int i = 0; i < temp; i++) answer += "수박";
        if(n == 1) answer += "수";
        return answer;
    }
}