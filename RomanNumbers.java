class RomanNumbers {
    
    public int romanToInt(String s) {

   int result = 0;
        char[] romanArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] numArray = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < s.length(); i++) {

            int romanNum = 0;

            for (int j = 0; j < romanArray.length; j++) {
                if (s.charAt(i) == romanArray[j]) {
                    romanNum = numArray[j];
                    break;
                }
            }

            if (i + 1 < s.length()) {
                int nextRomanNum = 0;
                for (int j = 0; j < romanArray.length; j++) {
                    if (s.charAt(i + 1) == romanArray[j]) {
                        nextRomanNum = numArray[j];
                        break;
                    }
                }
                if (nextRomanNum > romanNum) {
                    result += nextRomanNum - romanNum;
                    i++;
                } else {
                    result += romanNum;
                }
            } else {
                result += romanNum;
            }
        }
        return result;
    }
}