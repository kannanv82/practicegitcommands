package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.autoUtilities.autoUtils;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class searchpage {
	private AndroidDriver driver;
	WebDriverWait wait;
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Search Wikipedia')]")
	private MobileElement search;
	
	@AndroidFindBy(className="android.widget.EditText")
	private MobileElement searchText;
	
	public searchpage(AndroidDriver driver){
		this.driver=driver;
		 wait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enterSearchItem(String capital){
		autoUtils.presenceOfElementLocated(search, wait);
		Assert.assertTrue(search.isDisplayed());
		search.click();
		try{
		autoUtils.presenceOfElementLocated(searchText, wait);
		Assert.assertTrue(searchText.isDisplayed());
		searchText.clear();
		searchText.sendKeys(capital);}catch(StaleElementReferenceException e){
			
		}
		((RemoteWebDriver)driver).executeScript("mobile:performEditorAction",ImmutableMap.of("action","search"));
	}
	
	public static void scrollIntoViewByInstance(AndroidDriver driver){
		MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"org.wikipedia:id/search_results_list\")).scrollIntoView("
				+ "new UiSelector().className(\"android.widget.ImageView\").instance(10))"));
		/*driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceId(\"org.wikipedia:id/page_list_item_title\").instance(10)")).click();*/
		//Perform the action on the element
		element.click();
	}

}
