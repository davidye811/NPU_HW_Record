//a method to realize the queue through array
public class queue {
	int[] aa;							//to store int
	int endex=0;						//the index that we can add new int to the array
	int dedex=0;						//the index that we can drop					rule :FIFO
	public queue(int a){
		this.aa= new int[a];			//so that the user can apply for different size of queue
		};
	public static void main(String[] argv){
		queue mm= new queue(50);									//test one 
		for(int i=0;i<50;i++){									//get a full queue of random int from 1 to 100
			mm.enqueue((int)(Math.random()*100+1));
		}				
		mm.display();											//display the array so that i can easily to debug     ,1st lane in Console
		for(int i=0;i<30;i++){									//dequeue 30 number out and the output will be listed ,2nd lane in Console
			System.out.print(mm.dequeue());;
			System.out.print(' ');
		}
		mm.display();											//display the array in 3rd lane, blank number will be filled with zero 
		
		for(int i=0;i<10;i++){									
			mm.enqueue((int)(Math.random()*100+1));
		}
		mm.display();
		for(int i=0;i<20;i++){									
			mm.enqueue((int)(Math.random()*100+1));
		}
		mm.display();
		for(int i=0;i<1;i++){									
			mm.enqueue((int)(Math.random()*100+1));
		}
		for(int i=0;i<15;i++){									//dequeue 15 number out and the output will be listed
			System.out.print(mm.dequeue());;
			System.out.print(' ');
		}
	}
	void enqueue(int m){
		if(aa[endex]!=0){
			System.out.println("err!!!!!!overflow");
		}
		else{
		aa[endex]=m;
		endex=(endex+1)%(this.aa.length);
		}
	}
	int dequeue(){
		int k=aa[dedex];
		aa[dedex]=0;
		dedex=(dedex+1)%(this.aa.length);
		return k;
	}
	void  display(){
		
		System.out.println();
		System.out.print("Now the array is ");
		for(int i=0;i<aa.length;i++){
			System.out.print(aa[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
}
