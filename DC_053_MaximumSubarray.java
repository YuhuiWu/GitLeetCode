/**
 *  Find the contiguous subarray within an array (containing at least one number) 
 *  which has the largest sum.
 *  For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 *  the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *  click to show more practice.
 *  If you have figured out the O(n) solution, 
 *  try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 */
public class DC_053_MaximumSubarray {
	/*
	 * O(n) Solution
	 */
//	public int maxSubArray(int[] A) {
//        int max=Integer.MIN_VALUE;
//        int sum=0;
//        for(int i=0;i<A.length;i++){
//            sum+=A[i];
//            if(sum>max){
//                max=sum;
//            }
//            if(sum<0){
//                sum=0;
//            }
//        }
//        return max;
//    }
	/*
	 * DaC Solution
	 */
	public int maxSubArray(int[] A,int left,int right){
		if(left==right)
			return A[left];
		int mid=left+(right-left)/2;
		return Math.max(
				Math.max(maxSubArray(A,left,mid),maxSubArray(A,mid+1,right)),
				maxCrossSubArray(A,left,mid,right));
	}
	public int maxCrossSubArray(int[] A,int left,int mid,int right){
      int leftmax=Integer.MIN_VALUE,rightmax=Integer.MIN_VALUE;
      int sum=0;
      for(int i=mid;i>=left;i--){
          sum+=A[i];
          if(sum>leftmax){
              leftmax=sum;
          }
      }
      sum=0;
      for(int i=mid+1;i<=right;i++){
          sum+=A[i];
          if(sum>rightmax){
              rightmax=sum;
          }
      }
      return leftmax+rightmax;

	}
	public int maxSubArray(int[] A){
		return maxSubArray(A,0,A.length-1);
	}
}
