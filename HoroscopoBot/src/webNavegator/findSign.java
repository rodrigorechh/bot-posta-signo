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
public class findSign {
    
        public String achaSigno(String data){
            System.out.println("achasigno:"+ data); 
            String[] dateArray = data.split(" ");
            int dia = Integer.parseInt(dateArray[0]);
            String mes = dateArray[2];
            switch(mes){
                case "janeiro":
                    if(dia <= 20)
                        return "Capricórnio";
                    else
                        return "Aquário";
                 
                case "fevereiro":
                    if(dia <= 19)
                        return "Aquário";
                    else
                        return "Peixes";
                
                case "março":
                    if(dia <= 20)
                        return "Peixes";
                    else
                        return "Áries";
                case "abril":
                    if(dia <= 20)
                        return "Áries";
                    else
                        return "Touro";
                case "maio":
                    if(dia <= 20)
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
                    if(dia <= 22)
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
}
