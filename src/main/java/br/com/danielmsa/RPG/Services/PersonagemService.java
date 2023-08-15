package br.com.danielmsa.RPG.Services;

import br.com.danielmsa.RPG.Models.PersonagemModel;
import br.com.danielmsa.RPG.Repositories.PersonagemRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PersonagemService {
    private PersonagemRepository repository;
    private CronicaService serviceCronica;

    public PersonagemService(PersonagemRepository repository, CronicaService serviceCronica) {
        this.repository = repository;
        this.serviceCronica = serviceCronica;
    }

    public PersonagemModel findById(long id){
        return repository.findById(id).orElse(null);
    }

    public List<PersonagemModel> findByCronica(long idCronica){

        return repository.findAllByCronica(serviceCronica.findById(idCronica));
    }

    public PersonagemModel add(PersonagemModel personagem){
        return repository.save(personagem);
    }

    public PersonagemModel update(long idPersonagem, PersonagemModel personagemAtualizado) {
        personagemAtualizado.setId(findById(idPersonagem).getId());
        return repository.save(personagemAtualizado);
    }

    public PersonagemModel updatePartially(long idPersonagem, PersonagemModel personagemAtualizado) {
        PersonagemModel personagemAtual = findById(idPersonagem);

        if(personagemAtualizado.getNome() != null && !personagemAtualizado.getNome().equals(""))
            personagemAtual.setNome(personagemAtualizado.getNome());

        if(personagemAtualizado.getIdade() > 0)
            personagemAtual.setIdade(personagemAtualizado.getIdade());

        if(personagemAtualizado.getCronica() != null)
            personagemAtual.setCronica(personagemAtualizado.getCronica());

        if(personagemAtualizado.getResumoHistoria() != null && !personagemAtualizado.getResumoHistoria().equals(""))
            personagemAtual.setResumoHistoria(personagemAtualizado.getResumoHistoria());

        return repository.save(personagemAtual);
    }

    public PersonagemModel updateDinheiro(long id,long novaQuantia) {
        PersonagemModel personagem = findById(id);
        personagem.setDinheiro(novaQuantia);
        return repository.save(personagem);
    }

    public boolean delete(long id){
       if(repository.existsById(id)){
           repository.deleteById(id);
           return true;
       }
       return false;
    }
}