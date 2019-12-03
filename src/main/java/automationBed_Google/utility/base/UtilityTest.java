package automationBed_Google.utility.base;

import java.util.ArrayList;
import automationBed_Google.utility.excelManager.ExcelUtility;
import automationBed_Google.utility.excelManager.Read_XLS;

public class UtilityTest {
	public static void main(String[] args) {

		/*JSONReader jr = new JSONReader(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRRJsonResources\\PRADAXA_MICHAEL_BRADY_LYNCH.json");
		
		Object[] formFields= (jr.getJsonObject("VERTICALS").getJsonObject("MRR").getJsonObject("EXCEL_UPLOAD_TEMPLATE").getArray("FORM_FIELDS"));
		 int i=0;
		while(formFields.length>i){
			System.out.println((String)formFields[i]);
			i++;
		}*/
		
		
	
		
/*		
		System.out.println(WdmConfig.getBoolean("wdm.capabilities.*"));
		Read_XLS loginDetails = new Read_XLS(System.getProperty("user.dir")
				+ "//src//main//resources//datafiles//MRRJsonResources//LoginDetails.xlsx");

		// login for each reviewer
		ArrayList<ArrayList<Object>> reviewerLogin = new ExcelUtility().getDataAsArrayList(loginDetails, "Reviewer");

		
		Read_XLS caseTemplate = new Read_XLS(
			System.getProperty("user.dir") + "//src//main//resources//datafiles//MRR_case_upload_template//100_caseDetails.xlsx");
		
		
		
		// uploaded caseDetails
		
		for (ArrayList<Object> reviewer : reviewerLogin) {
			System.out.println(caseTemplate.isWorksheetExist((String)reviewer.get(1)));
			if (caseTemplate.isWorksheetExist((String)reviewer.get(1))) {
				Object[][] CaseDetails = new ExcelUtility().getData(caseTemplate,(String)reviewer.get(1));
	
				for (Object[] caseDetails : CaseDetails) {
					
					for (Object object : caseDetails) {
						System.out.println((String)object);
					}
					System.out.println("************************************************");
				}
			} else {
				System.out.println((String)reviewer.get(1)+" not found");
			}
			
		}
		
		
		
*/	//	ArrayList<ArrayList<Object>> CaseDetails = new ExcelUtility().getDataAsArrayList(caseTemplate, "Case Sheet");
		
		
	/*	
		
		Read_XLS sortedCaseDetails = new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRR_case_upload_template\\100_caseDetails.xlsx","w");
		ArrayList<Object> sortedCaseDetailsColumn=caseTemplate.getRowAt("Case Sheet", 0);
		String assigneeName="sanchit";
		for (ArrayList<Object> casedetails : CaseDetails) {
			
			if(!sortedCaseDetails.isWorksheetExist(assigneeName)){
				sortedCaseDetails.addRowAt(assigneeName, sortedCaseDetailsColumn,0);
			}
				sortedCaseDetails.addRow(assigneeName, casedetails);
				
		}*/
		
		
		/*Read_XLS caseTemplate1 = new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRR_case_upload_template\\cearteTest.xlsx","w");
		*/
		
		
		
		
		
		
		/*ArrayList<ArrayList<Object>> CaseDetails = new ExcelUtility().getDataAsArrayList(caseTemplate, "VerifiedCases");
		
		for (ArrayList<Object> casedetails : CaseDetails) {
			
			System.out.println(casedetails.toString());
		}*/
		
		
		/*String tempDirPath=System.getProperty("user.dir")+"//src//main//resources//datafiles//MRR_case_upload_template//";
		tempDirPath=tempDirPath.replace("//", "\\");
		System.out.println(tempDirPath);*/
		
	/*	Read_XLS caseTemplate = new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRR_case_upload_template\\"+"PROGRAM1-AUTOMATION_case_1.xlsx");
		
		Read_XLS sortedCaseDetails = new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRR_case_upload_template\\"+"PROGRAM1-AUTOMATION_case_1_caseDetails.xlsx","w");
		ArrayList<Object> sortedCaseDetailsColumn=caseTemplate.getRowAt("Case Sheet", 0);
		*/
		
/*Read_XLS GRG_Collection = new Read_XLS(System.getProperty("user.dir")+"//src//main//resources//datafiles//schedullingCase//GRG_Collection.xlsx");
		
		ArrayList<ArrayList<Object>> GRG_Details = new ExcelUtility().getDataAsArrayList(GRG_Collection, "GRGID_Data");
		
		Read_XLS GRG_Report = new Read_XLS(System.getProperty("user.dir")+"//src//main//resources//datafiles//schedullingCase//GRG_Report.xlsx","w");
		
		ArrayList<Object> GRG_ReportColumn=GRG_Collection.getRowAt("GRGID_Data", 0);
		
		GRG_Report.addRowAt("Report", GRG_ReportColumn, 0);
		
		for (ArrayList<Object> GRG_Detail : GRG_Details) {
			if(new ExcelUtility().getToRunFlag(GRG_Collection, "GRGID_Data", (String)GRG_Detail.get(0))){
				System.out.println("running :"+(String)GRG_Detail.get(0));
				System.out.println("with data :"+(String)GRG_Detail.get(1));
				
				GRG_Report.addRow("Report", GRG_Detail);
				
				System.out.println("wrting Neurology : ");
				new ExcelUtility().writeResult(GRG_Report, "Report", "Neurology", (String)GRG_Detail.get(0), "blah blah");
				new ExcelUtility().writeResult(GRG_Report, "Report", "NeuroPyschology", (String)GRG_Detail.get(0), "blah blah");
				
			}
		}*/
		
		Read_XLS caseTemplate = new Read_XLS(
				System.getProperty("user.dir") + "\\src\\main\\resources\\datafiles\\MRR_case_upload_template\\PRADAXA - MICHAEL BRADY LYNCH_case.xlsx");
		
		// uploaded caseDetails
		ArrayList<ArrayList<Object>> CaseDetails = new ExcelUtility().getDataAsArrayList(caseTemplate, "Case Sheet");
		
	}

}
