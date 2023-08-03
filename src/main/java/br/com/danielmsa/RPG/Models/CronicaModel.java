package br.com.danielmsa.RPG.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = "public", name = "cronicas")
public class CronicaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_cronica")
    private long id;

    @Column
    private String nome;

    @Column
    @OneToMany(mappedBy = "cronica")
    private List<PersonagemModel> personagens;
}
