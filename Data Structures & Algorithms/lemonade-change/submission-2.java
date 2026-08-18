class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        int PRICE = 5;

        for (int bill : bills) {
            int owed = bill - PRICE;

            if (owed == 0) fives++;
            if (owed == 5) { 
                if (fives == 0) return false;
                tens++;
                fives--;
            }
            
            if (owed == 15) {
                if (tens == 0 && fives == 0) return false;

                if (tens >= 1 && fives >= 1) {
                    tens--;
                    fives--;
                    continue;
                }

                if (tens == 0 && fives >= 3) {
                    fives -= 3;    
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}