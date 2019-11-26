/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
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
        element.sendKeys("user");
        element = driver.findElement(By.cssSelector(".js-password-field"));
        element.sendKeys("password");
        element.submit();
        driver.get("https://twitter.com/notifications/mentions"); 
        
        List<WebElement> elements = driver.findElements(By.cssSelector("[class = \"css-4rbku5 css-18t94o4 css-901oao r-111h2gw r-1loqt21 r-1q142lx r-1qd0xha r-a023e6 r-16dba41 r-ad9z0x r-bcqeeo r-3s2u2q r-qvutc0\"]"));
        JSONObject mentions = new JSONObject();
        JSONArray array = new JSONArray();
        for(int i = 0; i<elements.size(); i++){
            String linkTwitter = elements.get(i).getAttribute("href");
            array = this.updateArray(array, linkTwitter);
        }
        //mentions = this.updateJson(elements, mentions);
        mentions.put("mentions", array);
        System.out.println(mentions.toString());
        return driver;
    }
    

    private JSONArray updateArray(JSONArray mentions, String link){
        for(int i=0; i < mentions.length(); i++){
            JSONObject temporaryMention = new JSONObject(mentions.get(i));
            if(temporaryMention.has(link))//caso já esteja no array
                return mentions;
        }
        JSONObject newMention = new JSONObject();
        newMention.put("link", link);
        newMention.put("acessado", false);
        mentions.put(newMention);
        return mentions;
    }
    
//    public void searchJsonWithFalse(JSONObject mentions){
//        System.out.println(mentions.optNumber(1));
//    }

}
