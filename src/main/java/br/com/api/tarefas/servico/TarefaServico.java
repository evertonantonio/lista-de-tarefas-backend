package br.com.api.tarefas.servico;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.tarefas.modelo.RespostaModelo;
import br.com.api.tarefas.modelo.TarefaModelo;
import br.com.api.tarefas.repositorio.TarefaRepositorio;

@Service
public class TarefaServico {

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    @Autowired
    private RespostaModelo respostaModelo;

    public Iterable<TarefaModelo> listar(){
        return tarefaRepositorio.findAll();
    }
    

    public ResponseEntity<?> cadastrarAlterar(TarefaModelo tarefamodelo, String acao){
        if(tarefamodelo.getDescricao().equals("")){
            respostaModelo.setMensagem("O nome da descrição é necessária");
            return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<TarefaModelo>(tarefaRepositorio.save(tarefamodelo),HttpStatus.CREATED );
            }else{
                return new ResponseEntity<TarefaModelo>(tarefaRepositorio.save(tarefamodelo),HttpStatus.OK );
            }
        }
    }


    public ResponseEntity<RespostaModelo> remover(long id){

        tarefaRepositorio.deleteById(id);

        respostaModelo.setMensagem("Produto removido com sucesso");
        return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.OK);
    }
    
}
