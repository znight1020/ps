class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        for(int r = 0; r < photo.length; r++){
            for(int c = 0; c < photo[r].length; c++){

                for(int i = 0; i < name.length; i++){
                    if(name[i].equals(photo[r][c])) result[r] += yearning[i];
                }
                
            }
        }
        
        return result;
    }
}