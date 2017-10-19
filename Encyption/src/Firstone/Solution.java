package Firstone;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;
import javax.xml.bind.DatatypeConverter ;
public class Solution {
	public static void main(String[] argv){
		int[] result=modulus(3,0x10001);
		int r=result[0];
		int e= result[1];
		BigInteger N=new BigInteger("402394248802762560784459411647796431108620322919897426002417858465984510150839043308712123310510922610690378085519407742502585978563438101321191019034005392771936629869360205383247721026151449660543966528254014636648532640397857580791648563954248342700568953634713286153354659774351731627683020456167612375777",10);
		BigInteger C1=new BigInteger("239450055536579126410433057119955568243208878037441558052345538060429910227864196906345427754000499641521575512944473380047865623679664401229365345208068050995600248796358129950676950842724758743044543343426938845678892776396315240898265648919893384723100132425351735921836372375270138768751862889295179915967",10);
		BigInteger C2=new BigInteger("138372640918712441635048432796183745163164033759933692015738688043514876808030419408866658926149572619049975479533518038543123781439635367988204599740411304464710538234675409552954543439980522243416932759834006973717964032712098473752496471182275216438174279723470286674311474283278293265668947915374771552561",10);
		BigInteger c3=new BigInteger("5");
		BigInteger c4=new BigInteger("3");
		BigInteger c5=new BigInteger("4");
		System.out.println(calculate(N,C1,C2,r,e));
	}
	public static  String calculate(BigInteger N,BigInteger c1,BigInteger c2,int r,int e){
			//System.out.println(c1.pow(r));
			//System.out.println(c2.pow(-e));
			//System.out.println(c1.pow(r).divide(c2.pow(-e)));
			//System.out.println(c1.pow(r).divide(c2.pow(-e)).mod(N));
			 BigInteger a=c1.pow(r);
			 System.out.println(a);
			
			 //System.out.println(N.bitLength()+" "+c1.bitLength()+" "+c2.bitLength()+" ");
		//byte[] m= a.toByteArray();
		//byte[] k= Base64.getDecoder().decode(m);
		return a.toString();
	}
	public static int[] modulus(int a,int b){
		int[] result = new int[2];
		int i =1;
		while(true){
			if((b*i+1)%a==0){
				result[1]=-i;
				result[0]=(b*i+1)/a;
				break;
			}
			i++;
		}
		return result;
	}
	   
}
