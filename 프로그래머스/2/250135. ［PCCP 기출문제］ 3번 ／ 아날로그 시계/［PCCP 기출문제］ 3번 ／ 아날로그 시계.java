class Solution {

    static Degree d;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0, start = 60*60*h1 + 60*m1 + s1, end = 60*60*h2 + 60*m2 + s2;
        d = initDegree(h1, m1, s1);
        if(Double.compare(d.hD, d.sD) == 0 || Double.compare(d.mD, d.sD) == 0) answer++;
        
        
        while(start < end) {
            start++;
            answer += countDuplicate(start);
        }
        
        d = initDegree(h2, m2, s2);
        if(Double.compare(d.hD, d.sD) == 0 || Double.compare(d.mD, d.sD) == 0) answer++;
        
        return answer;
    }
    
    static int countDuplicate(int start) {
        int cnt = 0;
        double preHD = d.hD;
        double preMD = d.mD;
        double preSD = d.sD;
        
        d.hD += 0.008333333333;
        d.mD += 0.1;
        d.sD += 6;
        
        if(Double.compare(preHD, preSD) > 0 && Double.compare(d.hD, d.sD) <= 0) cnt++;
        if(Double.compare(preMD, preSD) > 0 && Double.compare(d.mD, d.sD) <= 0) cnt++;
        if((Double.compare(preHD, preMD) > 0 && Double.compare(preHD,preSD) > 0) 
           && (Double.compare(d.hD, d.mD) <= 0 && Double.compare(d.hD, d.sD) <= 0)) cnt--;
        
        if(d.hD >= 360) d.hD %= 360;
        if(d.mD >= 360) d.mD %= 360;
        if(d.sD >= 360) d.sD %= 360;
        return cnt;
    }
    
    static Degree initDegree(int h1, int m1, int s1) {
        double hD = 0;
        hD += (30*(h1%12)) + (0.5*m1) + (0.0083*s1);
        double mD = 0;
        mD += (6*m1) + (0.1*s1);
        return new Degree(hD, mD, 6*s1);
    }
    
    static class Degree {
        double hD, mD, sD;
        Degree(double hD, double mD, double sD) {
            this.hD = hD;
            this.mD = mD;
            this.sD = sD;
        }
    }
}