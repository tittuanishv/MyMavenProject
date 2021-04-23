package org.MainClassPackage;
import java.io.IOException;
import org.FunctionModule.FaceBookModuleFunction;

public class FacebookLogin extends FaceBookModuleFunction
{
 public static void main(String[] args) throws IOException 
 {	 
		browserChromeLaunch();
		toload("https://www.facebook.com/");
		maximizeWindow();
		toGetCurrentURL();
		toGetTitle();
		toLoginFromExcel("facebook", "Login", 2);
		
 }	 
}
