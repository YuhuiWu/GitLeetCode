/**
 *Given an array of size n, find the majority element. The majority element is the element that appears more than  n/2  times.
 *
 *You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class DC_169_MajorityElement {
    public int majorityElement(int[] num) {
        int ret=num[0];
        int times=0;
        for(int i=0;i<num.length;i++){
            if(times==0){
                ret=num[i];
                times=1;
            }else{
                if(ret==num[i])
                    times++;
                else
                    times--;
            }
        }
        return ret;
    }
}