package PageObjectModel;

import Utilities.ActionMethods;

public class EmailIdPage 
{
	public static String emailIdText = "identifierId"; // id
	public static String nextButtonEmailID = "identifierNext"; // id
	
	public static void enterEmailId(String emailId)
	{
		ActionMethods.enterText("ID", emailIdText, emailId);
	}
	
	public static void clickNextButtonEmailID()
	{
		ActionMethods.clickButton("ID", nextButtonEmailID);
	}
}
