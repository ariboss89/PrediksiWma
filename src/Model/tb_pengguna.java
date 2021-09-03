/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ariboss89
 */
public class tb_pengguna {
    private static String username;
    private static String role;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_pengguna.username = username;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_pengguna.role = role;
    }
    
    
}
