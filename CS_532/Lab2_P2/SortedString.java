package Lab2_P2;

public class SortedString {
	static int SizeOfName=0;
	static String[] NameList;
	SortedString(int CapacityOfName){
		NameList=new String[CapacityOfName];
	}
	public void addNameToSortedArrayList(String nameToAdd){
		int SortStringListIndex;
		SizeOfName++;
		for(SortStringListIndex=0;SortStringListIndex<SizeOfName;SortStringListIndex++){
			if(NameList[SortStringListIndex]!=null&&nameToAdd.compareTo(NameList[SortStringListIndex])<0){
				continue;
			}else if(nameToAdd.equals(NameList[SortStringListIndex])){
				SizeOfName--;
				break;
			}else{
			String nameToSwap=nameToAdd;
			String temp;
				for(int swaptemp=SortStringListIndex;swaptemp<SizeOfName;swaptemp++){
					temp=NameList[swaptemp];
					NameList[swaptemp]=nameToSwap;
					nameToSwap=temp;
				}
				break;
			}
		}
		if(SizeOfName==0){
			NameList[SizeOfName]=nameToAdd;
			SizeOfName++;
		}else{
			
		}
	}
	public String toString(){
		StringBuffer stringBuffer=new StringBuffer();
		for(int i = 0;i<SizeOfName;i++){
			stringBuffer.append(NameList[i]+"\n");
		}
		return stringBuffer.toString();
	}
}
