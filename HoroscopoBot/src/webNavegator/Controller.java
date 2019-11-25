/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webNavegator;

/**
 *
 * @author Rodrigo
 */
import org.json.JSONObject;

public class Controller {

        public static void main(String[] args) {
            
            //searchEngine a = new searchEngine();
            //a.procuraIdade("Roberto Carlos");
            botTwitter bot = new botTwitter();
            bot.login();

        }

}