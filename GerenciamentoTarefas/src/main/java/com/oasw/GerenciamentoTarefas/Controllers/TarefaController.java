package com.oasw.GerenciamentoTarefas.Controllers;

import com.oasw.GerenciamentoTarefas.Models.TarefaModel;
import com.oasw.GerenciamentoTarefas.Services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> createTarefa(TarefaModel tarefaModel){
        TarefaModel request = tarefaService.createTarefa(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefaModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> getAll(){
        List<TarefaModel> request = tarefaService.getAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaModel> getById(@PathVariable Long id){
        TarefaModel request = tarefaService.getById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        tarefaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
