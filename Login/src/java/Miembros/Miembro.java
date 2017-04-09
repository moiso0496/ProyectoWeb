/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miembros;

/**
 *
 * @author moisesfallas
 */
public class Miembro {

   
    
    public String user;

    public Miembro(String user, String pass, String email, int tel) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.tel = tel;
    }
    public String pass;
    public String email;
    public int tel;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
