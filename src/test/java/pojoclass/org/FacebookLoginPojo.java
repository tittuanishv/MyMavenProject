package pojoclass.org;

import org.FunctionModule.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPojo extends LibGlobal {
	
	public FacebookLoginPojo()
	{
		PageFactory.initElements(driver, this);
	}
		@FindBy(name="email")
		private WebElement txtUser;
		@FindBy(id="pass")
		private WebElement txtPass;
		@FindBy(xpath="//button[text()='Log In']")
		private WebElement btnLogin;
		
		public WebElement getBtnLogin() {
			return btnLogin;
		}
		public WebElement getTxtUser() {
			return txtUser;
		}
		public WebElement getTxtPass() {
			return txtPass;
		}
		
				
		
	

}
