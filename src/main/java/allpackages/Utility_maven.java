package allpackages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Utility_maven {
	public static String readExcelData(int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		File myfile=new File("C:\\Software\\velocity\\9thAprEvenTest.xlsx");
		 Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet3");
		String value = mysheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	public static String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Velocity_corporate_training\\selenium_9th_april\\validate_user\\objectRepository.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}
	public static void implicitWait(WebDriver driver, int time_in_ms)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time_in_ms));
	}

}
