package br.com.api.tarefas.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.tarefas.modelo.RespostaModelo;
import br.com.api.tarefas.modelo.TarefaModelo;
import br.com.api.tarefas.servico.TarefaServico;

@RestController
@CrossOrigin(origins = "*")
public class TarefaControle {

    @Autowired
    private TarefaServico tarefaServico;

    @PutMapping("alterar")
    public ResponseEntity<?> alterar(@RequestBody TarefaModelo tarefaModelo){
        return tarefaServico.cadastrarAlterar(tarefaModelo, "alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody TarefaModelo tarefaModelo){
        return tarefaServico.cadastrarAlterar(tarefaModelo, "cadastrar");
    }

    @GetMapping("/listar")
    public Iterable<TarefaModelo> listar(){
        return tarefaServico.listar();
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
        return tarefaServico.remover(id);
    }

    @GetMapping("/")
    public String rota(){
        return "Tá funcionando!";
    }
    
}
