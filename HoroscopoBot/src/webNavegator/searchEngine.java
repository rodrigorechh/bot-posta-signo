/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author Rodrigo
 */
public class searchEngine {
        private String Nome;
            
        public WebDriver abreGoogleChrome(){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Cliente\\Desktop\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            return driver;
        }   
        
        public void procuraIdade(String Nome){    
            WebDriver driver = abreGoogleChrome();
            driver.get("http://www.google.com");	
            WebElement element = driver.findElement(By.cssSelector("[type=\"text\"]"));
            element.sendKeys(Nome + " idade");
            element.submit();
            element = driver.findElement(By.cssSelector("[class=\"yxAsKe kZ91ed\"]"));
            System.out.println(element.getText());
            System.out.println(achaSigno(element.getText()));            
        }
        
        public String achaSigno(String data){
            System.out.println("achasigno:"+ data); 
            String[] dateArray = data.split(" ");
            int dia = Integer.parseInt(dateArray[0]);
            String mes = dateArray[2];
            switch(mes){
                case "janeiro":
                    if(dia <= 19)
                        return "Capricórnio";
                    else
                        return "Aquário";
                 
                case "fevereiro":
                    if(dia <= 18)
                        return "Aquário";
                    else
                        return "Peixes";
                
                case "março":
                    if(dia <= 19)
                        return "Peixes";
                    else
                        return "Áries";
                case "abril":
                    if(dia <= 18)
                        return "Áries";
                    else
                        return "Touro";
                case "maio":
                    if(dia <= 19)
                        return "Touro";
                    else 
                        return "Gêmeos";
                case "junho":
                    if(dia <= 20)
                        return "Gêmeos";
                    else
                        return "Câncer";
                case "julho":
                    if(dia <= 21)
                        return "Câncer";
                    else
                        return "Leão";
                   
                case "agosto":
                    if(dia <= 22)
                        return "Câncer";
                    else 
                        return "Virgem";
                case "setembro":
                    if(dia <= 21)
                        return "Virgem";
                    else
                        return "Libra";
                case "outubro":
                    if(dia <= 22)
                        return "Libra";
                    else
                        return "Escorpião";
                case "novembro":
                    if(dia <= 21)
                        return "Escorpião";
                    else
                        return "Sagitário";
                case "dezembro":
                    if(dia <= 21)
                        return "Sagitário";
                    else 
                        return "Capricórnio"; 
            }
            return "erro, signo não encontrado";
        }
        
        public void fechaNavegador(WebDriver driver){
            driver.quit();
        }
}