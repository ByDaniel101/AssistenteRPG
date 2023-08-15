package br.com.danielmsa.RPG.Services;

import br.com.danielmsa.RPG.Models.CronicaModel;
import br.com.danielmsa.RPG.Repositories.CronicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronicaService {

    private CronicaRepository repository;

    public CronicaService(CronicaRepository repository) {
        this.repository = repository;
    }

    public CronicaModel findById(long id) {
       return repository.findById(id).orElse(null);
    }

    public List<CronicaModel> findAllByNome(String nome) {
       return repository.findByNomeLike(nome);
    }

    public List<CronicaModel> findAll() {
        return repository.findAll();
    }

    public CronicaModel add(CronicaModel cronica) {
        return repository.save(cronica);
    }
}