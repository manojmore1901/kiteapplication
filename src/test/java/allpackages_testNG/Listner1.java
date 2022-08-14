package allpackages_testNG;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import allpackages.BaseClass;

public class Listner1 
	extends BaseClass implements ITestListener 
	{
		BaseClass l=new BaseClass();
		public void onTestStart(ITestResult result) {
			Reporter.log("TC Execution is started"+result.getName(),true);
		}
		public void onTestFailure(ITestResult result)  {
			Reporter.log("TC Execution is failled"+result.getName(),true);
//			String tc1= result.getName();
//			try {
//				l.tackingScreenshot(tc1);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			}
		public void onTestSkipped(ITestResult result) {
			Reporter.log("TC Execution is skipped "+result.getName(),true);
		}
		public void onTestSuccess(ITestResult result) {
			Reporter.log("TC Execution is successful "+result.getName(),true);
		}

	}
