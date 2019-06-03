package PageObjectModel;

import Utilities.ActionMethods;

public class PasswordPage 
{
	
	public static String passwordText = "password"; //name
	public static String nextButtonPassword = "passwordNext"; //id
	
	public static void enterPassword(String password)
	{
		ActionMethods.enterText("name", passwordText, password);
	}
	
	public static void clickNextButtonPassword()
	{
		ActionMethods.clickButton("ID", nextButtonPassword);
	}
}
