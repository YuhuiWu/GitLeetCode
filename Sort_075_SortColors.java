/*
*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
*
*Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/
public class Sort_075_SortColors {
    public void sortColors(int[] A) {
        int length=A.length;
        int left=-1;
        int right=length;
        int i=0;
        //If the current is 0, then swap to the left, left index++
        //If the current is 2, then swap to the right, right index--; 
        int temp=-2;
        while(i<right)
        {
            if(A[i]==0)
            {
                left++;
                temp=A[i];
                A[i]=A[left];
                A[left]=temp;
                i++;
            }
            else if(A[i]==2)
            {
                right--;
                temp=A[i];
                A[i]=A[right];
                A[right]=temp;
            }
            else
                i++;
        }
    }
}