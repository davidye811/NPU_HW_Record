
public class Time {
	private int hour;
	private int min;
	private double sec;
	Time(int hour,int min,double sec){
		this.hour = hour;
		this.min=min;
		this.sec= sec;
		};
	 static boolean offtime(Time a,Time b){
		if(a.hour>b.hour)
			return false;
		if(a.hour==b.hour){
			if(a.min>b.min)
				return false;
			if(a.min==b.min)
				return(a.sec < b.sec);
			return true;
		}
		return true;
	}
	public static void main(String[] argv){
		Time a=new Time(3,5,12.5);
		Time b=new Time(3,5,12.5);
		System.out.println(offtime(a,b));
	}
}
