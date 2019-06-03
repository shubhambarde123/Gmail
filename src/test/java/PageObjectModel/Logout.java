package PageObjectModel;

import Utilities.ActionMethods;

public class Logout 
{
	public static String icon = "//a[@class='gb_x gb_Ea gb_f']";
	public static String logoutButton = "gb_71";
	
	public static void clickOnIcon()
	{
		ActionMethods.clickButton("xpath", icon);
	}
	
	public static void clickLogout()
	{
		ActionMethods.clickButton("ID", logoutButton);
	}
}
