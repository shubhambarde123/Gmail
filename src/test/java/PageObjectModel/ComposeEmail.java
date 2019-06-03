package PageObjectModel;

import Utilities.ActionMethods;

public class ComposeEmail 
{
	public static String composeEmailButton = "//div[@class='T-I J-J5-Ji T-I-KE L3']" ; ////div[@class='T-I J-J5-Ji T-I-KE L3']
	public static String toEmailId = "to"; //name
	public static String subjectText = "//input[@placeholder='Subject']";
	public static String bodytext = "//div[@class='Am Al editable LW-avf']";
	public static String sendButton = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']";
	
	public static void clickComposeEmail()
	{
		ActionMethods.clickButton("xpath", composeEmailButton);
		//ActionMethods.clickButton("classname", composeEmailButton);
	}
	
	public static void enterToEmailID(String emailID)
	{
		ActionMethods.enterText("name", toEmailId, emailID);
	}
	
	public static void enterSubject(String subject)
	{
		ActionMethods.enterText("xpath", subjectText, subject);
	}
	
	public static void enterBody(String body)
	{
		ActionMethods.enterText("xpath", bodytext, body);
	}
	
	public static void clickSendButton()
	{
		ActionMethods.clickButton("xpath", sendButton);
	}
}
