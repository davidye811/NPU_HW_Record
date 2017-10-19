package Lab_1;

public class ArrayAdded {
	class book{
		int isn;
		String name;
		book(int isn,String name){
			this.isn=isn;
			this.name=name;
		}
	}
	int[] array1={-65536};
	int[] array2={-65536};
	book[] array3=new book[0];
	public static void main(String[] argv){
		ArrayAdded mm=new ArrayAdded();
		
		mm.addToListNoDuplicates(1);
		mm.addToListNoDuplicates(3);
		mm.addToListNoDuplicates(4);
		mm.addToListNoDuplicates(2);
		mm.addToSortedListNoDuplicates(1);
		mm.addToSortedListNoDuplicates(3);
		mm.addToSortedListNoDuplicates(4);
		mm.addToSortedListNoDuplicates(2);
		System.out.print(mm);
	}
	void addToListNoDuplicates(int item){
		int i;
		if(array1[0]==-65536){
			array1[0]=item;
			return;
		}
		for(i=0;i<array1.length;i++){
			if(array1[i]==item)
				break;
		}
		if(i==array1.length){
			int[] temp=new int[array1.length+1];
			for(int j =0;j<array1.length;j++){
				temp[j]=array1[j];
			}
			temp[i]=item;
			array1=temp;
		}else{
			System.out.println("This item is duplicated one");
		}
	}
	void addToSortedListNoDuplicates(int item){
		if(array2[0]==-65536){
			array2[0]=item;
			return;
		}
		boolean findflag=findinArray(array2,item);
		if(findflag==true){
			int[] temp= new int[array2.length+1];
			int i;
			for(i=array2.length-1;i>=0;i--){
				if(array2[i]>item){
					temp[i+1]=array2[i];
				}else{
					temp[i+1]=item;
					break;
				}
				
			}
			for(int j=i;j>=0;j--){
				temp[j]=array2[j];
			}
			array2=temp;
		}else{
			System.out.println("This item is duplicated one");
		}
		
	}
	static boolean findinArray(int array2[],int item){
		for(int i =0;i<array2.length;i++){
			if(array2[i]==item)
				return false;
		}
		return true;
	}
	public String toString(){
		StringBuffer ab=new StringBuffer();
		ab.append("Array1");
		for(int i =0;i<array1.length;i++){
			ab.append(" "+array1[i]);
		}
		ab.append("\n");
		ab.append("Array2");
		for(int i =0;i<array2.length;i++){
			ab.append(" "+array2[i]);
		}
		ab.append("\n");
		return ab.toString();
	}
}
