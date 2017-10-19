package random;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        int i =0;
        int j =0;
        int temp=-1;
        while(i<length1||j<length2||((i+j+2)*2>(length1+length2))){
            if(i<length1&&nums1[i]<nums2[j]){
                i++;
                temp=0;
                break;
            }
            if(j<length2&&nums1[i]>=nums2[j]){
                j++;
                temp=1;break;
            }
            if(i>=length1&&j<length2){
                j++;
                temp=1;break;
            }
            if(j>=length2&&i<length1){
                i++;
                temp=0;break;
            }
        }
        if(((length1+length2)&1)==1){
            if(temp==0){
                return nums2[j]*1.0;
            }else{
                return nums1[i]*1.0;
            }
        }else{
            return (nums1[i]+nums2[j])/2.0;
        }
    }
    public static void main(String[] argv){
    	Solution a = new Solution();
    	int[] nums1={1, 3};
    	int [] nums2= {2};
    	System.out.println(a.findMedianSortedArrays(nums1, nums2));
    }
}