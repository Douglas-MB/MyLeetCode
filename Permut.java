class Permut {
    

    public int[] buildArray(int[] nums) {

            int[] test = new int[nums.length];

            for (int i = 0; i < nums.length ; i++) {
            test[i] = nums[nums[i]];
            
            }
      return test;
    }
}