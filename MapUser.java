package demoLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class MapUser {

	
	@SuppressWarnings("rawtypes")
	public static Map<String, Map<String,String>> readMultipleTestData(String sFilePath, String sSheetName, String sTestCaseName)
			throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Map<String, String>> objTestData = new HashMap();
		try {
			

			String sPreviousTestCaseName = "";
			int iRowNo = 1;
			File file = new File(sFilePath);
			FileInputStream fin = new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet(sSheetName);
			int rows = sh.getLastRowNum()+1 ;
			int cols = sh.getRow(0).getLastCellNum();
			for (int iRowCounter = 1; iRowCounter < rows; iRowCounter++) {
				@SuppressWarnings("unchecked")
				Map<String, String> objRowData = new HashMap();
				String sCurTestCaseName = sh.getRow(iRowCounter).getCell(0).getStringCellValue().trim();
				if ((sPreviousTestCaseName.length() != 0) && (sCurTestCaseName != sPreviousTestCaseName)
						&& (sTestCaseName.trim().length() > 0)) {
					break;
				}
				if (sCurTestCaseName.equalsIgnoreCase(sTestCaseName)) {
					sPreviousTestCaseName = sCurTestCaseName;
					for (int iColCounter = 0; iColCounter < cols; iColCounter++) {
						String sKey = sh.getRow(0).getCell(iColCounter).getStringCellValue().trim();
						String sValue = "";
						if(sh.getRow(iRowCounter).getCell(iColCounter)!= null){
							if(sh.getRow(iRowCounter).getCell(iColCounter).getCellType() == XSSFCell.CELL_TYPE_STRING){
								sValue = sh.getRow(iRowCounter).getCell(iColCounter).getStringCellValue().trim();
							}else if(sh.getRow(iRowCounter).getCell(iColCounter).getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
								sValue = sh.getRow(iRowCounter).getCell(iColCounter).getRawValue();
							} 
						}
						 
						if ((!sValue.equalsIgnoreCase(null)) && (sValue.trim().length() != 0)) {
							objRowData.put(sKey, sValue);
						}
					}
					objTestData.put("Row" + iRowNo, objRowData);

					objRowData = null;

					iRowNo++;
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objTestData;
	}
}
