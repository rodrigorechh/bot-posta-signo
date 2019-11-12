/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Rodrigo
 */
public class searchEngine extends browserManager {
        private String Nome;
        private final findSign sign;

    public searchEngine() {
        this.sign = new findSign();
    }
    
    public void procuraIdade(String Nome){    
        WebDriver driver = super.openChrome();
        driver.get("http://www.google.com");	
        WebElement element = driver.findElement(By.cssSelector("[type=\"text\"]"));
        element.sendKeys(Nome + " idade");
        element.submit();
        element = driver.findElement(By.cssSelector("[class=\"yxAsKe kZ91ed\"]"));
        System.out.println(element.getText());
        System.out.println(sign.achaSigno(element.getText()));            
    }

    private void closeChrome(WebDriver driver){
        driver.quit();
    }
}