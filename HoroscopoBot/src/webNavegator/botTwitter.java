/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Rodrigo
 */
public class botTwitter extends browserManager{
    
    public WebDriver login(){
        /*O método abre o navegador e efetua o login no twitter*/
        WebDriver driver = super.openChrome();
        driver.get("http://www.twitter.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element;
        element = driver.findElement(By.cssSelector(".js-username-field"));
        element.sendKeys("email");
        element = driver.findElement(By.cssSelector(".js-password-field"));
        element.sendKeys("password");
        element.submit();
        driver.get("https://twitter.com/notifications/mentions");
        return driver;
    }
}
