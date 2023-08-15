package br.com.danielmsa.RPG.Controllers;

import br.com.danielmsa.RPG.Models.CronicaModel;
import br.com.danielmsa.RPG.Models.PersonagemModel;
import br.com.danielmsa.RPG.Repositories.CronicaRepository;
import br.com.danielmsa.RPG.Services.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {
private PersonagemService servicePersonagem;
    private CronicaRepository cronicaRepo;

    @Autowired
    public PersonagemController(PersonagemService servicePersonagem, CronicaRepository cronicaRepo) {
        this.servicePersonagem = servicePersonagem;
        this.cronicaRepo = cronicaRepo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemModel> getPersonagemById(@PathVariable long id){
        PersonagemModel personagem = servicePersonagem.findById(id);
        if(personagem != null)
            return ResponseEntity.ok(personagem);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/bycronica/{idCronica}")
    public ResponseEntity<List<PersonagemModel>> getAllPersonagensByCronica(@PathVariable long idCronica){

        List<PersonagemModel> personagens = servicePersonagem.findByCronica(idCronica);
        if(personagens.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(personagens);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<PersonagemModel> addPersonagem(@RequestParam PersonagemModel personagem){
        PersonagemModel saved = servicePersonagem.add(personagem);
        if(saved == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public @ResponseBody ResponseEntity<PersonagemModel> updatePersonagem(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "personagem")PersonagemModel personagem){

        PersonagemModel updated = servicePersonagem.update(id, personagem);

        if(updated == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    @PatchMapping
    public @ResponseBody ResponseEntity<PersonagemModel> updatePartiallyPersonagem(
            @RequestParam(name = "id") long id,
            @RequestParam(name = "personagem")PersonagemModel personagem){

        PersonagemModel updated = servicePersonagem.updatePartially(id, personagem);
        if(updated == null)
            ResponseEntity.notFound().build();

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/alterarDinheiro/{id}/{novaQuantia}")
    public @ResponseBody ResponseEntity<PersonagemModel> updateDinheiro (@PathVariable long id, @PathVariable long novaQuantia){
        PersonagemModel personagem = servicePersonagem.updateDinheiro(id, novaQuantia);
        if (personagem == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(personagem);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deletePersonagem(long id) {
        if (servicePersonagem.delete(id))
            return ResponseEntity.ok("Personagem apagado com sucesso");
        else
            return ResponseEntity.notFound().build();
    }
}
