package br.com.danielmsa.RPG.user;

public enum UserRoles {

    ADMIN("ADMIN"),

    USER("USER");

    String role;
    UserRoles(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
