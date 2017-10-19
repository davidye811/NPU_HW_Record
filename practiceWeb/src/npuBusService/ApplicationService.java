package npuBusService;

import npuBus.domain.Application;;
public class ApplicationService {
	public static void main(String[] argv){
		Application testcase=new Application( 3232132, "BMW22", "cat", "need 2 seats");
		insertOrUpadateApplication(testcase);
		System.out.println(getApl(3232132));
		testcase.setCarryon("dog");
		insertOrUpadateApplication(testcase);
		System.out.println(getApl(3232132));
	}
	public static void insertOrUpadateApplication(Application Apl){
		Application curApl=getApl(Apl.getStudentid());
		if(curApl.equals(Apl)){
			updateDbService.updateApplication(Apl);
		}else{
			updateDbService.insertApplication(Apl);
		}
		
	}
	private static Application getApl(int studentid) {
		Application selectedApl=new Application();
		selectedApl= updateDbService.getApplication(studentid);
		return selectedApl;
	}
	
}
