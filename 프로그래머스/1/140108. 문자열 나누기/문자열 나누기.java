class Solution {
    public int solution(String s) {
        int answer = 0;
        int iter = 0;
        
        int startCharCnt = 0; // 시작 문자의 개수
        char startChar = ' '; // 시작 문자
        int diffCnt = 0; // 다른 문자의 cnt
        
        while(iter != s.length()){  
            
            
            if(startCharCnt > 0){
                if(s.charAt(iter) == startChar) startCharCnt++; // startChar와 같은 문자인 경우
                else diffCnt++; // 다른 문자인 경우
                
                if(startCharCnt == diffCnt) {
                    answer++;
                    startCharCnt = 0;
                }
            } else{
                startChar = s.charAt(iter);
                startCharCnt ++;
                diffCnt = 0;
            }
            
            iter++;
            if(startCharCnt > 0 && iter == s.length()) answer++;
        }
        return answer;
    }
}