package com.oasw.GerenciamentoTarefas.Repositories;

import com.oasw.GerenciamentoTarefas.Models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel,Long> {
}
