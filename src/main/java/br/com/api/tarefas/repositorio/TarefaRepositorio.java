package br.com.api.tarefas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.tarefas.modelo.TarefaModelo;

@Repository
public interface TarefaRepositorio extends CrudRepository<TarefaModelo, Long>{
    
}
