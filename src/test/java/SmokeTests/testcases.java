package SmokeTests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import pages.bookmarkandsave;
import pages.landingPage;
import pages.searchpage;
public class testcases {
	private static AndroidDriver driver;
	private landingPage landing;
	private searchpage search;
	private bookmarkandsave bookmark;
	String capital;

//code will run before start run the test	

//presetup	

//driver setup and initialize POM	
@BeforeSuite
public void setup() throws MalformedURLException{
	final String urlString = "http://127.0.0.1:4723/wd/hub";
	URL url = new URL(urlString);    
    //launch app
DesiredCapabilities caps = new DesiredCapabilities();
caps.setCapability(MobileCapabilityType.DEVICE_NAME, "B6TKRG8599999999");
caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
caps.setCapability("appPackage","org.wikipedia");
caps.setCapability("appActivity","org.wikipedia.main.MainActivity");

driver = new AndroidDriver(url,caps);

landing = new landingPage(driver);
search = new searchpage(driver);
bookmark = new bookmarkandsave(driver);
}


	@Test()
public void readCapitalFromAPI() throws MalformedURLException{
	RestAssured.baseURI="https://restcountries.eu/rest/v2/name";
	RequestSpecification request = RestAssured.given();
	Response res = request.get("/india?fullText=true");
	String responseString = res.asString();
	
	JSONArray jsonarray = new JSONArray(responseString);
	
	    JSONObject jsonobject = jsonarray.getJSONObject(0);
	    capital = jsonobject.getString("capital");
	    
}

@Test()
public void savePageInToList(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	landing.clickSkip();
	landing.clickNoThanks();
	search.enterSearchItem(capital);
	search.scrollIntoViewByInstance(driver);
	bookmark.clickBookmark();
	bookmark.clickSaved();
	bookmark.clickNavigateUp();
	bookmark.clickMylist();
	bookmark.verifySaved();
}
}
