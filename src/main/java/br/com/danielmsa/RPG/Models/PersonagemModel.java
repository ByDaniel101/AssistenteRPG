package br.com.danielmsa.RPG.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(schema = "public",name = "personagens")
@Getter @Setter
public class PersonagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_personagem")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_cronica")
    private CronicaModel cronica;

    @Column
    @OneToMany(mappedBy = "personagem")
    private List<RelacionamentoModel> relacionamentos;

    @OneToMany(mappedBy = "relacionado")
    private List<RelacionamentoModel> relacionamentosComoRelacionado;
    @Column
    private double dinheiro;

    @Column(length = 50)
    private String nome;

    @Column
    private int idade;

    @Column
    private String resumoHistoria;

}
