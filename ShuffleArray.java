class Solution {
    public int[] shuffle(int[] nums, int n) {
        int size = 2*n;
        int[] aux  =  new int[size];
        int odd;
        int even;

        for(int i = 0; i < n; i++){
                odd = 2*(i+1)-1;
                even = 2*(i+1)-2;
        
                aux[odd] = nums[i+n];
                aux[even] = nums[i];
        }
       
       return aux;
    }
}