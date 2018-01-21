class Solution {
    public int solution(int[] A) {
    Integer myInt[] = new Integer[(int) (Math.pow(10, 6)+1)];
    for (int i : A){
        if (i>0)myInt[i]=1;
    }
    for (int i = 1;i<myInt.length-1;i++){
        if (myInt[i]==null)return i;
    }
    return 1;
    }
    public static void main(String[] args) {
    	int full[] = new int[1000000];
    	int fuck = 10;
    	for (int i = 0;i<full.length;i++) {
    		full[i]=i;
    	}
    	Solution sol  = new Solution();
    	System.out.println(Math.pow(10, 6));
    	
    	System.out.println(sol.solution(full));
	}
}