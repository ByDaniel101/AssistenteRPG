package br.com.danielmsa.RPG.Controllers;

import br.com.danielmsa.RPG.Models.CronicaModel;
import br.com.danielmsa.RPG.Repositories.CronicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cronica")
public class CronicaController {

    private final CronicaRepository cronicaRepo;

    @Autowired
    public CronicaController(CronicaRepository cronicaRepo) {
        this.cronicaRepo = cronicaRepo;
    }

    @GetMapping("{id}")
    public CronicaModel getCronicaById(@PathVariable long id){
        Optional<CronicaModel> cronica = cronicaRepo.findById(id);
        if(cronica.isEmpty())
            throw new RuntimeException("ERRO: Crônica não encontrada");

        return cronica.get();
    }

    @GetMapping("/byname/{nome}")
    public List<CronicaModel> getCronicaByName(@PathVariable String nome) {
        List<CronicaModel> cronicas = cronicaRepo.findByNome(nome);
        if(cronicas.isEmpty())
            throw new RuntimeException("ERRO: Nenhuma crônica não encontrada");

        return cronicas;
    }

    @GetMapping
    public List<CronicaModel> getAllCronicas(){
        return cronicaRepo.findAll();
    }

    @PostMapping
    public @ResponseBody CronicaModel createCronica(CronicaModel cronica) {
        return cronicaRepo.save(cronica);
    }
}
