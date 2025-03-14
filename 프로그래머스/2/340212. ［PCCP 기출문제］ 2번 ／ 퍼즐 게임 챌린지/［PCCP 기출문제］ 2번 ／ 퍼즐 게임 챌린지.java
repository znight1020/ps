

class Solution {
    
    static int min = 100_000;
    static long timePrev = 0, timeLimit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0, size = diffs.length, start = 1, end = min;
        timeLimit = limit;
        
        while(start <= end) {
            long currentTime = 0;
            timePrev = 0;
            int mid = (start+end) / 2;
            
            boolean flag = true;
            
            for(int i = 0; i < size; i++) {
                currentTime += solvingTime(diffs[i], times[i], mid);
                
                if(!check(currentTime)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                end = mid-1;
                min = Math.min(min, mid);
            }
            else start = mid+1;
        }
        
        return min;
    }
    static boolean check(long currentTime) {
        if(currentTime > timeLimit) return false;
        return true;
    }
    
    static long solvingTime(int diff, int time, int level) {
        long sTime = 0;
        int d = diff - level;
        
        if(d <= 0) sTime = time;
        else sTime = (timePrev+time) * d + time;
        timePrev = time;
        
        return sTime;
    }
}