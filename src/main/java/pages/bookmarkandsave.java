package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.autoUtilities.autoUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class bookmarkandsave {
	private AndroidDriver driver;
	WebDriverWait wait;
	@AndroidFindBy(id="org.wikipedia:id/article_menu_bookmark")
	private MobileElement bookmark;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,'GOT IT')]")
	private MobileElement gotit;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Saved')]")
	private MobileElement savedOption;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	private MobileElement navigateUp;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private MobileElement navigateBack;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@content-desc='My lists']")
	private MobileElement myList;
	
	public bookmarkandsave(AndroidDriver driver){
		this.driver=driver;
		 wait = new WebDriverWait(this.driver, 30);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickBookmark(){
		autoUtils.presenceOfElementLocated(bookmark, wait);
		Assert.assertTrue(bookmark.isDisplayed());
		bookmark.click();
		autoUtils.presenceOfElementLocated(gotit, wait);
		gotit.click();
	}
	
	public void clickSaved(){
		autoUtils.presenceOfElementLocated(savedOption, wait);
		Assert.assertTrue(savedOption.isDisplayed());
		savedOption.click();
	}
	
	public void clickNavigateUp(){
		navigateUp.click();
		autoUtils.presenceOfElementLocated(navigateBack, wait);
		navigateBack.click();
	}
	
	public void clickMylist(){
		autoUtils.presenceOfElementLocated(myList, wait);
		myList.click();
	}
	
	public void verifySaved(){
		autoUtils.presenceOfElementLocated(savedOption, wait);
		Assert.assertTrue(savedOption.isDisplayed());
	}
}
