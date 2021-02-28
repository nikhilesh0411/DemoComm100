import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 
public class TestSuites {
static String loginURL="https://secure.comm100.com/login.aspx";
public WebDriver driver;
public String uname="nik@gmail.com";
public String pwd="password";
@BeforeMethod
public void setup () {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Work\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(loginURL);
	}
	@Test
	public void ValidLogin() {
		driver.findElement(By.id(LoginPageObjects.emailTextFieldId)).sendKeys(uname);
		driver.findElement(By.id(LoginPageObjects.pwdTextFieldId)).sendKeys(pwd);
		driver.findElement(By.id(LoginPageObjects.loginBtn)).click();
		String homePageTitle=driver.getTitle();
		System.out.println(homePageTitle);
		assertEquals(homePageTitle, "Home Page", "Not logged in");
		driver.close();
	}
	@Test
	public void InvalidLogin() throws InterruptedException {
		driver.findElement(By.id(LoginPageObjects.emailTextFieldId)).sendKeys(uname);
		driver.findElement(By.id(LoginPageObjects.pwdTextFieldId)).sendKeys(pwd);
		driver.findElement(By.id(LoginPageObjects.loginBtn)).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.id("ajaxErrorMsg")).getText(), "Email or password is wrong.", "Error message not found.");
		driver.close();
	}
	@Test
	public void PasswordBlank() throws InterruptedException {
		driver.findElement(By.id(LoginPageObjects.emailTextFieldId)).sendKeys(uname);
		driver.findElement(By.id(LoginPageObjects.loginBtn)).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"loginContent\"]/div[2]/label")).getText(), "Password cannot be empty.", "Error message not found.");
		driver.close();
	}
	@Test
	public void EmailBlank() throws InterruptedException {
		driver.findElement(By.id(LoginPageObjects.loginBtn)).click();
		Thread.sleep(5000);
		assertEquals(driver.findElement(By.xpath("//*[@id=\"loginContent\"]/div[1]/label")).getText(), "Email cannot be empty.", "Error message not found.");
		driver.close();
	}
	
}
