package exercisePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private By cartProductName=By.xpath("//*[@id=\'tbodyid\']/tr[1]/td[2]");
	private By cartLink=By.id("cartur");
	private By cartProductImg=By.xpath("//*[@id=\'tbodyid\']/tr[1]/td[1]/img");
	private WebDriver chromeDriver;
	public CartPage(WebDriver chromeDriver){
		this.chromeDriver=chromeDriver;
	}
	
	public String validateProductInCart(){
		Duration time = Duration.ofSeconds(5);
		WebDriverWait wait = new WebDriverWait(chromeDriver, time);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(cartLink));

		/*WebElement cartPageLink = chromeDriver.findElement(cartLink);
		//New user 
        Actions builder = new Actions(chromeDriver);
        builder.moveToElement(cartPageLink).click(cartPageLink);
        builder.perform();*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductImg));
		//WebElement cartItem = chromeDriver.findElement(cartProductName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartProductName));
		String itemName=chromeDriver.findElement(cartProductName).getText();
		return itemName;
		
	}

}
