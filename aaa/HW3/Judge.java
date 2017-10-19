/*
 * student info: name=YITING PENG  ,ID=19503
 * cs480_hw_nightmare
 */
package HW3;
import java.util.*;
/**
 *
 * @author asus-ad
 */
public class Judge {

    private Dive[] diver;
    private int numdiver;

    /* private Dive dive;
    private float[] rating;*/
    public Judge(int maxnum) {

        this.diver = new Dive[maxnum];
        this.numdiver = 0;

    }

    public float[] gettotalperdiveperpson() {
        float[] max = new float[3];
        float[] min = new float[3];
        float[] sum = new float[3];
        for (int i = 0; i < 3; i++) {
            max[i] = diver[i].getGrade()[i][0];

            for (int j = 0; j < 9; j++) {
                if (diver[i].getGrade()[i][j] > max[i]) {
                    max[i] = diver[i].getGrade()[i][j];
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            min[i] = diver[i].getGrade()[i][0];

            for (int j = 0; j < 9; j++) {
                if (diver[i].getGrade()[i][j] < min[i]) {
                    min[i] = diver[i].getGrade()[i][j];
                }
            }
        }

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 9; j++) {
                sum[i] = sum[i] + this.diver[i].getGrade()[i][j] - max[i] - min[i];

            }

        }
        return sum;
    }

    public float gettotalperson() {
        float total = 0;
        float[] max = new float[3];
        float[] min = new float[3];
        float[] sum = new float[3];
        for(Dive a:this.diver){
        
        for (int i = 0; i < 3; i++) {
            //diver[0].getgrade()[i][0]-9
            max[i] = a.getGrade()[i][0];
            for (int j = 0; j < 9; j++) {
                if (a.getGrade()[i][j] > max[i]) {
                    max[i] = a.getGrade()[i][j];
                }
            }
        }
        }
           for(Dive a:this.diver){
        
        for (int i = 0; i < 3; i++) {
            //diver[0].getgrade()[i][0]-9
            min[i] = a.getGrade()[i][0];
            for (int j = 0; j < 9; j++) {
                if (a.getGrade()[i][j] > min[i]) {
                    min[i] = a.getGrade()[i][j];
                }
            }
        }
        }
           for(Dive a:this.diver){
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 9; j++) {
                sum[i] = sum[i] + a.getGrade()[i][j] - max[i] - min[i];

            }

        }}
         for(Dive a:this.diver){  
        for (int i = 0; i < 3; i++) {

            total += sum[i] * a.getDifficult()[i];

        }}
        return total;
    }
   public static void main(String[] argv) {
       
     /*  Scanner sc=new Scanner(System.in);
       System.out.println("please input the number of the diver");
       int n=sc.nextInt();
      
       String name=sc.next();*/
       float[][]peter_point= {{1,2,4,5,14,15,16,17,2},{6,7,8,9,2,3,4,7,5},{10,11,12,13,3,5,6,7,8}};
       float[]peter_difficulty={1,2,3};
       Dive peter=new Dive("peter",peter_difficulty,peter_point);
       Judge eter=new Judge(1);
       eter.diver[0]=peter;
               
       System.out.print(+eter.gettotalperson());
       
   }
   }
       
   
   
   
   }
}
