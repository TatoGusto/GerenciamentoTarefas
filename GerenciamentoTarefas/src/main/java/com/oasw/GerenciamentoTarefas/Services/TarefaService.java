package com.oasw.GerenciamentoTarefas.Services;

import com.oasw.GerenciamentoTarefas.Models.TarefaModel;
import com.oasw.GerenciamentoTarefas.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    public TarefaModel create(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public List<TarefaModel> getAll(){
        return tarefaRepository.findAll();
    }

    public TarefaModel getById(Long id){
        return tarefaRepository.getById(id);
    }

    public void deleteById(Long id){
        tarefaRepository.deleteById(id);
    }
}
