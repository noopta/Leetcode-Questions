class Solution {
    public boolean detectCapitalUse(String word) {
        int i = 0;

        if (Character.isUpperCase(word.charAt(0))) {
            if (i + 1 < word.length() && Character.isUpperCase(word.charAt(i + 1))) {
                for (i = 1; i < word.length(); i++) {
                    if (Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else if (i + 1 < word.length() && Character.isLowerCase(word.charAt(i + 1))) {
                for (i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else if (i + 1 >= word.length()) {
                return true;
            }

        } else {
            for (i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}