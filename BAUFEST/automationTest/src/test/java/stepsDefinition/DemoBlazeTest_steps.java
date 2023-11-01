package stepsDefinition;

import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import exercisePages.CartPage;
import exercisePages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import utility.WriteDoc;

public class DemoBlazeTest_steps {
	
	String PATH_USERFILEUSER= "../automationTest/user.txt";
	String PATH_USERFILEPRODUCT= "../automationTest/product.txt";

	WebDriver chromeDriver=null;
	String driverPath="../automationTest/driver/chromedriver.exe";
	
	private HomePage homePage;
	private CartPage cartPage;
	private String username;
	private Date date;
	private String userLogin;
	
	
	@Before
    public void initializeObjects() {
    
	date = new Date();
	username="Rodrigo"+ date;
	userLogin=""+username;
	}
    /*@AfterAll
    public static void closeDriver(){
        //DriverSingleton.closeObjectInstance();
    }*/
	
	@Given("^I lunch Google Chrome browser$")
	public void i_lunch_Google_Chrome_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver",driverPath);
		chromeDriver=new ChromeDriver();
		homePage = new HomePage(chromeDriver);
		cartPage= new CartPage(chromeDriver);
		//throw new io.cucumber.java.PendingException();
	}

	@When("^I navigate to the url$")
	public void i_navigate_to_the_url() throws Throwable {
		String url="https://www.demoblaze.com/index.html";
		chromeDriver.get(url);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	
	@SuppressWarnings("deprecation")
	@Then("^I validate the title of the web page$")
	public void i_validate_demoBlaze_https_www_demoblaze_com_index_html_web_page_is_loaded() throws Throwable {
	    String actualTitle=chromeDriver.getTitle();
	    String expectedTitle="STORE";
	    Assert.assertEquals(expectedTitle,actualTitle);
    
}

	// SIGN UP USER
	
	@Given("Navigate to demoBlaze web")
	public void navigate_to_demo_blaze_web() {
		String url="https://www.demoblaze.com/index.html";
		chromeDriver.get(url);
	    //throw new io.cucumber.java.PendingException();
	}
	@When("I signUp a new user")
	public void i_sign_up_a_new_user() {
		try {
			System.out.println(WriteDoc.writeDocumentInfo(username,PATH_USERFILEUSER));
				} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.userSignUpActionOk(username,"Pass");
	}
	@Then("I validate the user was created")
	public void i_validate_the_user_was_created() {
		String alertText=homePage.validateUserCreated(username);
		String expectedText="Sign up successful.";
	    Assert.assertEquals(expectedText,alertText);
	 
	}
	
	//LOG IN USER
	
	@When("I Login with user")
	public void i_login_with_user() {
		try {
			String[] userName = utility.ReadDoc.readDocumentInfo(PATH_USERFILEUSER).split("\\n+");
			System.out.println(userName[0]);
			userLogin=userName[0];
			} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.userLogInActionOk(userLogin,"Pass");
	}
	
	@SuppressWarnings("deprecation")
	@Then("I validate the user logedIn")
	public void i_validate_the_user_loged_in() {
		String actualUserLogedName=homePage.validateUserLogIn();
		String expectedUser = null;
		try {
		String[] userNameSaved = utility.ReadDoc.readDocumentInfo(PATH_USERFILEUSER).split("\\n+");
		expectedUser=userNameSaved[0];
	    Assert.assertEquals(expectedUser,actualUserLogedName);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		/*System.out.println("EXPECTED: "+expectedUser);
		System.out.println("ACTUAL: "+actualUserLogedName);*/
	}
	
	@When("I LogOut with user")
	public void i_log_out_with_user() {
		homePage.userLogOutActionOK();
	  
	}
	@SuppressWarnings("deprecation")
	@Then("I validate the user logedOut")
	public void i_validate_the_user_loged_out() {
	    Assert.assertTrue(homePage.validateUserLogOut());
	    }
	
	//ADD PRODUCT TO CART
	@When("I add a product\\/laptop to cart")
	public void i_add_a_product_laptop_to_cart() {
		/*JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
		js.executeScript("window.scrollBy(0,400)", "");*/
		String productName=homePage.userSelectProductFromGridActionOk();
		try {
			System.out.println(WriteDoc.writeDocumentInfo(productName,PATH_USERFILEPRODUCT));
				} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	@Then("I validate the product\\/laptop was added to cart")
	public void i_validate_the_product_laptop_was_added_to_cart() {
		String alertText=homePage.validateUserAddedProduct();
		String expectedText="Product added.";
	    Assert.assertEquals(expectedText,alertText);
	}
	
	@Then("I LogIn and validate the product is at the cart")
	public void i_vaidate_the_product_is_at_the_cart() {
		String url="https://www.demoblaze.com/cart.html";
		chromeDriver.get(url);
		try {
			String[] userName = utility.ReadDoc.readDocumentInfo(PATH_USERFILEUSER).split("\\n+");
			System.out.println(userName[0]);
			userLogin=userName[0];
			} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.userLogInActionOk(userLogin,"Pass");
		String expectedProduct=null;
	    String actualproductName=cartPage.validateProductInCart();
	    System.out.println(actualproductName);
	try {
		String[] productFileName = utility.ReadDoc.readDocumentInfo(PATH_USERFILEPRODUCT).split("\\n+");
		System.out.println(productFileName[0]);
		expectedProduct=productFileName[0];
		Assert.assertEquals(expectedProduct,actualproductName);
		} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
	}
}
