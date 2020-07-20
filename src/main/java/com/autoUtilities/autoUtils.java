package com.autoUtilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class autoUtils {
public static void presenceOfElementLocated(MobileElement element, WebDriverWait wait){
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
