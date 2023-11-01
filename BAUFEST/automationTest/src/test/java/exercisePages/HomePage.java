package exercisePages;


	import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class HomePage{
	 
		//variables 
		//private By loginMenuActionLink= By.id("login2");
		//private By laptopCategoryMenuButton=By.xpath("/html/body/div[5]/div/div[1]/div/a[3]");

		private By addLaptopToCartSonyButton=By.xpath("//*[@id=\'tbodyid\']/div[2]/div/a");
		private By imgLaptopSony=By.xpath("//*[@id=\"imgp\"]/div/img");
		
		private By loginMenuActionLink=By.id("login2");
		private By signUpMenuActionLink=By.id("signin2");
		private By buttonSignUp=By.xpath("//*[@id='signInModal']/div/div/div[3]/button[2]");
		private By logoutMenuActionLink=By.id("logout2");
		private By inputTextUserNameSU= By.id("sign-username");
		private By inputTextUserPassSU= By.id("sign-password");
		private By inputTextUserNameLI= By.id("loginusername");
		private By inputTextUserPassLI= By.id("loginpassword");
		private By buttonLogin= By.xpath("//*[@id=\'logInModal\']/div/div/div[3]/button[2]");
		private By userLogedLabel=By.id("nameofuser");
		private By productLaptopName=By.xpath("//*[@id=\'tbodyid\']/h2");
		//private By userButton=By.xpath("//[@id=\'mount_0_0_42\']/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/div/svg/g/image");
		
		private WebDriver chromeDriver;
		public HomePage(WebDriver chromeDriver){
			this.chromeDriver=chromeDriver;
			
		}
		
		//ACTIONS VALIDATIONS--------------------------
		
		public String validateUserCreated(String username){
			//get text and accept alert
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String alerText = alert.getText();
	        System.out.println(alerText);
	        //Press the OK button
	        alert.accept();
			return alerText;
		}
		
		
		public String validateUserLogIn(){
			//get user loged name
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(userLogedLabel));
			String userLoged=chromeDriver.findElement(userLogedLabel).getText();
			String sCadena = userLoged;
			String sSubCadena = sCadena.substring(8,43);
			System.out.println(sSubCadena);
			userLoged=sSubCadena;
			//System.out.println();	
			return userLoged;
		}
		
		public boolean validateUserLogOut(){
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loginMenuActionLink));
			WebElement logInMenuAction = chromeDriver.findElement(loginMenuActionLink);

			return logInMenuAction.isDisplayed();
			
		}
		
		public String validateUserAddedProduct(){
			//get text and accept alert
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        String alerText = alert.getText();
	        System.out.println(alerText);
	        //Press the OK button
	        alert.accept();
			return alerText;
		}
		
		
		//USER ACTIONS--------------------------------
		
		public void userLogOutActionOK(){
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(logoutMenuActionLink));
			WebElement logOffMenuAction = chromeDriver.findElement(logoutMenuActionLink);
	        Actions builder = new Actions(chromeDriver);
	        builder.moveToElement(logOffMenuAction).click(logOffMenuAction);
	        builder.perform();
		}
		
		public void userSignUpActionOk(String user,String pass){
			Duration time = Duration.ofSeconds(5);
			WebDriverWait wait = new WebDriverWait(chromeDriver, time);
			
			WebElement signUpMenuAction = chromeDriver.findElement(signUpMenuActionLink);
	
			//New user 
	        Actions builder = new Actions(chromeDriver);
	        builder.moveToElement(signUpMenuAction).click(signUpMenuAction);
	        builder.perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserNameSU));
			
			chromeDriver.findElement(inputTextUserNameSU).sendKeys(user);
			chromeDriver.findElement(inputTextUserPassSU).sendKeys(pass);
	      			
			//click signUp button 
			
			WebElement signUpButton = chromeDriver.findElement(buttonSignUp);
	        builder.moveToElement(signUpButton).click(signUpButton);
	        builder.perform();
	        
		}
	
	public void userLogInActionOk(String user,String pass){
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(chromeDriver, time);
		WebElement logInMenuAction = chromeDriver.findElement(loginMenuActionLink);
		//New user 
        Actions builder = new Actions(chromeDriver);
        builder.moveToElement(logInMenuAction).click(logInMenuAction);
        builder.perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(inputTextUserNameLI));
		
		chromeDriver.findElement(inputTextUserNameLI).sendKeys(user);
		chromeDriver.findElement(inputTextUserPassLI).sendKeys(pass);
		
		
		//click logIn button 
		
		WebElement logInButton = chromeDriver.findElement(buttonLogin);
        builder.moveToElement(logInButton).click(logInButton);
        builder.perform();
        
	}
	
	public String userSelectProductFromGridActionOk(){
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(chromeDriver, time);
		//WebElement laptopCategory = chromeDriver.findElement(laptopCategoryMenuButton);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userLogedLabel));

		String url="https://www.demoblaze.com/prod.html?idp_=8";
		chromeDriver.get(url);
		wait.until(ExpectedConditions.visibilityOfElementLocated(imgLaptopSony));

		Actions builder = new Actions(chromeDriver);
        WebElement sonyLaptopAddCartButton = chromeDriver.findElement(addLaptopToCartSonyButton);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addLaptopToCartSonyButton));
        String productName=chromeDriver.findElement(productLaptopName).getText();
		builder.moveToElement(sonyLaptopAddCartButton).click(sonyLaptopAddCartButton);        
        builder.perform();
        return productName;
	}
	
	}
	
	

	

