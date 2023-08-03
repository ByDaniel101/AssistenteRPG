package br.com.danielmsa.RPG.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@Table(schema = "public", name = "relacionamentos")
public class RelacionamentoModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_relacionamento")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_personagem")
    private PersonagemModel personagem;

    @ManyToOne
    @JoinColumn(name = "id_relacionado")
    private PersonagemModel relacionado;

    @Column
    private List<String> opnioesRelação;
}
