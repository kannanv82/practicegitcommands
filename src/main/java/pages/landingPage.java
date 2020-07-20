package pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.autoUtilities.autoUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class landingPage {
private AndroidDriver driver;
WebDriverWait wait;
@AndroidFindBy(id="org.wikipedia:id/fragment_onboarding_skip_button")
private MobileElement skip;

@AndroidFindBy(id="android:id/button2")
private MobileElement noThanks;

public landingPage(AndroidDriver driver){
	this.driver=driver;
	 wait = new WebDriverWait(this.driver, 30);
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

public void clickSkip(){
	autoUtils.presenceOfElementLocated(skip, wait);
	Assert.assertTrue(skip.isDisplayed());
	skip.click();
}

public void clickNoThanks(){
	autoUtils.presenceOfElementLocated(noThanks, wait);
	Assert.assertTrue(noThanks.isDisplayed());
	noThanks.click();
}
}
