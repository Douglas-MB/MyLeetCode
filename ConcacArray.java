class ConcacArray {
    public int[] getConcatenation(int[] nums) {
        int[] newArray = new int[nums.length*2];
        int num;
        int oldSize =  nums.length;

        for (int i = 0; i < nums.length; i++) {
                num = nums[i];
                newArray[i] = num;
                newArray[i+oldSize] = num;
        }

        return newArray;
    }
}