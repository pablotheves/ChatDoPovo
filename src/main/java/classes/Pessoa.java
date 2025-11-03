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
class Pessoa implements Serializable{
    String nome; int idade;
    Pessoa(String n, int i){
        nome = n;
        idade = i;
    }
}
