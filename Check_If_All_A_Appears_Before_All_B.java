class Solution {
    public boolean checkString(String s) {
        int lastA = 0;
        int firstB = 0;
        boolean foundB = false;
        int i = 0;

        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            }
        }

        i = 0;

        while (i < s.length() && !foundB) {
            if (s.charAt(i) == 'b') {
                firstB = i;
                foundB = true;
            }
            i++;
        }

        if (lastA > firstB) {
            return false;
        }

        return true;
    }
}