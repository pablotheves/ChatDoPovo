/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Mensagem implements Serializable{
    String nome; String mensagem;
    Mensagem(String n, String m){
        nome = n;
        mensagem = m;
    }
    
}
