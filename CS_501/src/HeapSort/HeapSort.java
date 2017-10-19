package HeapSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HeapSort {
	static int[] sortedChildHeap;
	static int n=0;
	public HeapSort(int []sortedChildHeap){
		this.sortedChildHeap=sortedChildHeap;
	}
	public void sort(int index){
		if(index==1)
			return;
//		buildMaxHeap(index);
		if(index==sortedChildHeap.length-1){
			buildMaxHeap(index);
		System.out.println("After building maxHeap:"+Arrays.toString(sortedChildHeap));
		System.out.println("***************************************************");
		System.out.println("Arrays which display each step");
		}
		maxHeapify(0,index);
		System.out.println("Step "+n+++": "+Arrays.toString(sortedChildHeap));
		int temp=sortedChildHeap[index];
		sortedChildHeap[index]=sortedChildHeap[0];
		sortedChildHeap[0]=temp;
		
		sort(index-1);
		
	}
	public void buildMaxHeap(int index){
		for(int i=(index-1)>>1;i>=0;i--){
			maxHeapify(i,index);
		}
	}
	public  void maxHeapify(int index,int len){
		int left=(index<<1)+1;
		int right=(index<<1)+2;
		int maxIndex;
		if(left>len)
			return ;
		maxIndex=left;
		int temp;
		if(right<=len&&sortedChildHeap[right]>sortedChildHeap[left])
			maxIndex=right;
		if(sortedChildHeap[index]<sortedChildHeap[maxIndex]){
			temp=sortedChildHeap[maxIndex];
			sortedChildHeap[maxIndex]=sortedChildHeap[index];
			sortedChildHeap[index]=temp;
			maxHeapify(maxIndex,len);
		}
		return ;
	}
	public static void main(String[] argv){
		int[] array = {12, 8, 15, 10, 5, 20, 7, 18, 22, 14};
		HeapSort a = new HeapSort(array);
//		
//		a.sort(array.length-1);
//		System.out.println("Step "+n+": "+Arrays.toString(a.sortedChildHeap));
		System.out.println(a.getClass().getName().equals("HeapSort.HeapSort"));
	}
	}
			
	

