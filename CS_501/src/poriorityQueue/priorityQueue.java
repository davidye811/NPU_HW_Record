package poriorityQueue;

import java.util.Arrays;


public class priorityQueue {
	static int[] sortedChildHeap;
	public priorityQueue(int []sortedChildHeap){
		this.sortedChildHeap=sortedChildHeap;
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
	public void heapIncreaseKey(int index,int valueAfterIncreased){
		sortedChildHeap[index]=valueAfterIncreased;
		int parent=(index-1)>>1;
		if(parent<0)
			return ;
		System.out.println(Arrays.toString(sortedChildHeap));
		//int anotherNode= ((index-1)^1+1);
		int temp;
		if(sortedChildHeap[parent]<sortedChildHeap[index]){
			
			temp=sortedChildHeap[parent];
			sortedChildHeap[parent]=sortedChildHeap[index];
			sortedChildHeap[index]=temp;
			heapIncreaseKey(parent,valueAfterIncreased);
		}
		
	}
	public void maxHeapInsert(int keyToInserted){
		int[] newsortedChildHeap=new int[sortedChildHeap.length+1];
		int index=0;
		for(int m:sortedChildHeap){
			newsortedChildHeap[index++]=m;
		}
		newsortedChildHeap[index]=Integer.MIN_VALUE;
		sortedChildHeap=newsortedChildHeap;
		heapIncreaseKey(index,keyToInserted);
	}
	public String toString(){
		return Arrays.toString(sortedChildHeap);
	}
	public static void main(String[] argv){
		int[] heap = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		priorityQueue a = new priorityQueue(heap);
		a.heapIncreaseKey(7, 20);
		System.out.println(a);

	}
}
