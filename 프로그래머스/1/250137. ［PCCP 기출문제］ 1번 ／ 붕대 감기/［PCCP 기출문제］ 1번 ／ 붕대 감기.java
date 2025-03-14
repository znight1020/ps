class Solution {
    
    static int current = 0, t, x, y, threshold;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        t = bandage[0];
        x = bandage[1];
        y = bandage[2];
        threshold = health;
        
        for(int i = 0; i < attacks.length; i++) {
            health = attack(health, attacks[i][0], attacks[i][1]);
            if(health <= 0) break;
            
            System.out.println(health);
        }
        
        if(health <= 0) answer = -1;
        else answer = health;
        
        return answer;
    }
    
    static int attack(int health, int time, int damage) {
        int cnt = time - current;
        health += cnt / t * y;
        health += cnt * x;
        
        if(health > threshold) health = threshold;
        
        current = time+1;
        return (health-damage);
    }
}