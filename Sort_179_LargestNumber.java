/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 *For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 *Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Sort_179_LargestNumber {
	public String largestNumber(int[] num) {
		// Define an array of Integer
		// Copy the value of num into Integer array
    	Integer[] data=new Integer[num.length];
    	for(int i=0;i<num.length;i++){
    		data[i]=new Integer(num[i]);
    	}
    	//Define the new Comparator of Integer
    	//Compare the digits of two Integer one by one
    	Arrays.sort(data, new Comparator<Integer>() {
    		public int compare(Integer i1, Integer i2) {
    			String s1=String.valueOf(i1);
                String s2=String.valueOf(i2);
                int l1=s1.length();
                int l2=s2.length();
                int c1=0,c2=0;
                if(l1<l2){
                    for(int i=0;i<l2+l1;i++){
                        c1=s1.charAt(i%l1);
                        c2=(i-l2>=0)?s1.charAt(i-l2):s2.charAt(i);
                        if(c1<c2)
                            return -1;
                        else if(c1>c2)
                            return 1;
                    }
                }else{//l1>=l2
                     for(int i=0;i<l1+l2;i++){
                        c1=(i-l1>=0)?s2.charAt(i-l1):s1.charAt(i);
                        c2=s2.charAt(i%l2);
                        if(c1<c2)
                            return -1;
                        else if(c1>c2)
                            return 1;
                    }
                }
                return 0;
    		}
    		});
    	//Add the sorted Integer to String ret
        String ret="";
        for(int i=data.length-1;i>=0;i--){
            ret+=String.valueOf(data[i]);
        }
        //Consider the situation "00000"
        int index=0;
        while(index<=ret.length()-1&&ret.charAt(index)=='0'){
            index++;
        }
        if(index==ret.length())
            return "0";
        ret=ret.substring(index);
        //return ret
        return ret;
    }
}
