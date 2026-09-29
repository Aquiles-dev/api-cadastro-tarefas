package ifpb.edu.br.api_cadastro_tarefas.controller;

import ifpb.edu.br.api_cadastro_tarefas.model.Tarefa;
import ifpb.edu.br.api_cadastro_tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listarTodas() {
        return tarefaService.listarTodas();
    }
}
