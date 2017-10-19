
package MyInterger;
import java.util.*;
/**
 *
 * @author Administrator
 */

public class MyInteger {  
  
    /** 
     * @param args 
     */  
    private int A;
    


    
    
    public MyInteger(int A) {    
        this.A = A;    
        
           
    }    
  
    
    public int get() {    
        return this.getA() ;    
    }    
    
   public String toString(){
    
    return A+"";

} 
    
    
    
    public boolean iseven()
    {    if(this.getA()%2==0){
        return true; 
    }
    else{
        return false;
    }
    }    
    
    public boolean isodd()
    {    if(this.getA()%2!=0){
        return true; 
    }
    else{
        return false;
    }
    }   
    
   public boolean isprime()
    {   
    for(int n=2;n<=Math.sqrt(this.getA());n++){
      if(   this.getA()%n==0){return false;}
    
    }
    return true;
    }    
    public static boolean iseven(int A){
        if(A%2==0){
        return true; 
    }
    else{
        return false;
    
    
    
    }}
        public static boolean isodd(int A)
    {    if(A%2!=0){
        return true; 
    }
    else{
        return false;
    }
    }   
     public static boolean isprime(int A)
    {    
    for(int n=2;n<=Math.sqrt(A);n++){
      if(A%n==0){return false;}
    
    }
    return true;
    }  
     public boolean equals(MyInteger A){
     if(this.getA()==A.getA())
    	 return true;
     return false;
     
     
     }
     public static int parseInt(char [] ch){
     int U=0;
     for(int i=0;i<ch.length;i++){
     
     char c =ch[i];
     U=(U+c-'0')*10;
     
     
     }
     return U/10;
     /*String q="";
     for(char c:ch)q+=c;
     return parseInt(q);/*int i=0;i<ch.length;i++]*/

     
     
     }
     public static int paseInt(char[] ch){
         String q="";
         for(int i = 0 ;i<ch.length;i++){
         char c=ch[i];
         q+=c;
         }
      return parseInt(q);   
     }
     public static int parseInt(String str){
       return Integer.parseInt(str);
     
     
     }
     
     public static void main(String[] args)
    {
        MyInteger A=new MyInteger(3);
        
        boolean result1;
        boolean result2;
        boolean result3;
        boolean result4;
        result3=A.isprime(3);
        ;
        System.out.println(A);
        
        result1=iseven(3);
        result2=isodd(3);
        result3=isprime(3);
        result4=A.equals(new MyInteger(3));
        
        if(result1)
        	System.out.println("even");
        if(result2)
        	System.out.println("odd");
        if(result3)
        	System.out.println("prime");
        if(result4)
        	System.out.println("equal");
        char m[]={'1','2'};
        String str="12333";
       System.out.println(+parseInt(m));
        
    System.out.println(+parseInt(str));
    
    
    
    }

    /**
     * @return the A
     */
    public int getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(int A) {
        this.A = A;
    }
}
    
    
    


