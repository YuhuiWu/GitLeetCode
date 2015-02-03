import java.util.Arrays;
import java.util.Comparator;


/**
 * @author Yuhui
 *Given an array of integers, find two numbers such that they add up to a specific target number.
  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
  Please note that your returned answers (both index1 and index2) are not zero-based.
  You may assume that each input would have exactly one solution.
  Input: numbers={2, 7, 11, 15}, target=9
  Output: index1=1, index2=2
 */

public class Array_001_TwoSum {
	//Define Class Data store the value of number and the index
	public class Data{
		public int val;
		public int index;
		public Data(int num,int index){
			val=num;
			this.index=index;
		}
	}
	//Define Class DataCmp that implement the Comparator
	public class DataCmp implements Comparator<Data>{
		@Override
		public int compare(Data d1,Data d2){
			if(d1.val<d2.val)
				return -1;
			else if(d1.val>d2.val)
				return 1;
			return 0;
		}
		
	}
	public int[] twoSum(int[] numbers,int target){
		//Define the array of Data to store nums
		int len=numbers.length;
		Data[] data=new Data[len];
		int index=0;
		for(int num:numbers){
			data[index]=new Data(num,index+1);
			index++;
		}
		//Sort the Data arrays
		Arrays.sort(data,new DataCmp());
		int start=0,end=len-1;
		while(start<end){
			if(data[start].val+data[end].val==target){
				int[] ret={
						Math.min(data[start].index, data[end].index),
						Math.max(data[start].index, data[end].index)
						};
				return ret;
			}
			else if(data[start].val+data[end].val>target)
				end--;
			else
				start++;
		}
		return null;//Because we assume this question has exact one answer
	}
}
