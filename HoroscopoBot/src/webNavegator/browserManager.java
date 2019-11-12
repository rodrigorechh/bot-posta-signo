/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Cliente
 */
public class browserManager {
        
    /**
     *
     * @return
     */
    public WebDriver openChrome(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cliente\\Desktop\\Faculdade\\Códigos\\!Trabalhos\\horoscopoBot\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }   
}
