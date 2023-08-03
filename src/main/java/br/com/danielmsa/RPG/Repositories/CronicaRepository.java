package br.com.danielmsa.RPG.Repositories;

import br.com.danielmsa.RPG.Models.CronicaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CronicaRepository extends JpaRepository<CronicaModel, Long> {

    List<CronicaModel> findByNome(String nome);
}
