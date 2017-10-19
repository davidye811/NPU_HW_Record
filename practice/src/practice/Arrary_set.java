package practice;
public class Arrary_set {
	public  static void main(String[] argv){						//just a test example 
		int[][] aa={{1,1,1,1},
					{2,1,1,1},
					{3,2,0,1},
					{1,1,1,1}};
		display(aa);
		setZeroes(aa);
		display(aa);
	}

 public static void setZeroes(int[][] matrix) {						//the main algorithm
	        int m = matrix.length;			
	        int n = matrix[0].length;
	        
	        if(m==0||n==0)
	            return;
	        int[] flagr = new int[m];								//record all the flag row and column that need to be zeroed
	        int[] flagc = new int[n];
	        
	        for(int i=0;i<m;i++){									//do the record
	            for(int j=0;j<n;j++){
	                if(matrix[i][j]==0){
	                    flagr[i]= 1; 
	                    flagc[j]= 1;
	                }
	            }
	        }
	        
	        for(int i=0;i<m;i++){									//let's do the zero 1 by 1
	            for(int j=0;j<n;j++){
	                if(flagr[i]==1||flagc[j]==1){
	                    matrix[i][j]=0;
	                }
	            }
	        }
	    }
 /*
  * space O(m+n)
  * speed O(mn)
  * i'd think that it is enough for solving the problem
  * */
public static void display(int[][] matrix){							//the method to display so that i can easily check it
	for(int i = 0 ; i <matrix.length;i++){
		for(int j = 0; j < matrix[i].length;j++){
			System.out.print(matrix[i][j]);
		}
		System.out.println();
		
	}
}
}