package br.com.danielmsa.RPG.Controllers;

import br.com.danielmsa.RPG.Models.CronicaModel;
import br.com.danielmsa.RPG.Services.CronicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cronica")
public class CronicaController {

    private CronicaService serviceCronica;
@Autowired
    public CronicaController(CronicaService serviceCronica) {
        this.serviceCronica = serviceCronica;
    }

    @GetMapping("{id}")
    public ResponseEntity<CronicaModel> getCronicaById(@PathVariable long id){
        CronicaModel cronica = serviceCronica.findById(id);
        if(cronica == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(cronica);
    }

    @GetMapping("/byname/{nome}")
    public ResponseEntity<List<CronicaModel>> getCronicaByName(@PathVariable String nome) {
        List<CronicaModel> cronicas = serviceCronica.findAllByNome(nome);
        if(cronicas.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cronicas);
    }

    @GetMapping
    public ResponseEntity<List<CronicaModel>> getAllCronicas(){
        List<CronicaModel> cronicas = serviceCronica.findAll();

        return ResponseEntity.ok(cronicas);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<CronicaModel> createCronica(CronicaModel cronica) {
        CronicaModel novaCronica = serviceCronica.add(cronica);
        if (cronica == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(novaCronica);
    }
}
