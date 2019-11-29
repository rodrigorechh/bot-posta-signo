/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *
 * @author Rodrigo
 */
public class botTwitter extends browserManager{
    
    private WebDriver driver;
    
    public void login(){
        /*O método abre o navegador e efetua o login no twitter*/
        this.driver = super.openChrome();
        this.driver.get("http://www.twitter.com/login");
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element;
        element = this.driver.findElement(By.cssSelector(".js-username-field"));
        element.sendKeys("digaorech@hotmail.com");
        element = this.driver.findElement(By.cssSelector(".js-password-field"));
        element.sendKeys("ciamirim5");
        element.submit();
    }
    /*
    Este método só pode ser realizado após o login
    */
    public void searchForQuestions() throws IOException {
        this.driver.get("https://twitter.com/notifications/mentions"); 
        List<WebElement> elements = this.driver.findElements(By.cssSelector("[class = \"css-4rbku5 css-18t94o4 css-901oao r-111h2gw r-1loqt21 r-1q142lx r-1qd0xha r-a023e6 r-16dba41 r-ad9z0x r-bcqeeo r-3s2u2q r-qvutc0\"]"));
        JSONObject mentions = this.createJson(elements);
        
        this.writeJsonInDisc(mentions);
    }
    private JSONObject createJson(List<WebElement> elements) throws IOException{
        String rd = this.readJsonToDisc();
        JSONObject mentionsTemporary;
        if(rd != null){
            mentionsTemporary = new JSONObject(rd);
        }
        else{
            mentionsTemporary = new JSONObject();
        }
        JSONArray array = new JSONArray();
  

        for(int i = 0; i<elements.size(); i++){
            String linkTwitter = elements.get(i).getAttribute("href");
            array = this.updateArray(array, linkTwitter);
        }
        mentionsTemporary.put("mentions", array);
        return mentionsTemporary;
    }
        
    /*
    Escreve no json.txt um JSONObject recebido
    */
    private void writeJsonInDisc(JSONObject mentions) throws IOException{
        
        try (FileWriter save = new FileWriter("json.txt")) {
            save.write(mentions.toString());
        }
    }

    private String readJsonToDisc() throws FileNotFoundException, IOException{
        FileReader arqLeitura = new FileReader("json.txt");
        BufferedReader buffer = new BufferedReader(arqLeitura);
        String readText = buffer.readLine();
	return readText;
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
   
}
