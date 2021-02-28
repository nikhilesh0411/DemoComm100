import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {
	
	public void loginWithValidCredentials(WebDriver driver,String url,String uname,String pwd) {
		
		driver.get(url);
		driver.findElement(By.id(LoginPageObjects.emailTextFieldId)).sendKeys(uname);
		driver.findElement(By.id(LoginPageObjects.pwdTextFieldId)).sendKeys(pwd);
		driver.findElement(By.id(LoginPageObjects.loginBtn)).click();
		String homePageTitle=driver.getTitle();
		System.out.println(homePageTitle);
		assert homePageTitle=="Comm100 - User Sign In";
	}
public void loginWithInvalidCredentials() {
		
	}

}
