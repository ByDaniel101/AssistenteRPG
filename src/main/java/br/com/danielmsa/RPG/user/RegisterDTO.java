package br.com.danielmsa.RPG.user;

public record RegisterDTO(String login, String password, UserRoles role) {
}
