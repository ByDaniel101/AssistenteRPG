package br.com.danielmsa.RPG.Repositories;

import br.com.danielmsa.RPG.Models.CronicaModel;
import br.com.danielmsa.RPG.Models.PersonagemModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonagemRepository extends JpaRepository<PersonagemModel, Long> {

    List<PersonagemModel> findAllByCronica(CronicaModel cronica);
}
