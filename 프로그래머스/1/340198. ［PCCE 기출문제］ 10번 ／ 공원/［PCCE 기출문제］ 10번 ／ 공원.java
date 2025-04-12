import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        Arrays.sort(mats);
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[0].length; j++) {
                if("-1".equals(park[i][j])) {
                    for(int idx = mats.length-1; idx >= 0; idx--) {
                        if(answer > mats[idx]) break;
                        if(isMatting(mats[idx], i, j, park)) answer = Math.max(answer, mats[idx]);
                    }   
                }
            }
        }
        return answer;
    }
    
    static boolean isMatting(int matLength, int startY, int startX, String[][] park) {
        if(startY + matLength > park.length) return false;
        for(int y = startY; y < startY+matLength; y++) {
            if(startX + matLength > park[0].length) return false;
            for(int x = startX; x < startX+matLength; x++) {
                if(!"-1".equals(park[y][x])) return false;
            }
        }
        return true;
    }
    
    
}