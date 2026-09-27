package ifpb.edu.br.api_cadastro_tarefas.service;

import ifpb.edu.br.api_cadastro_tarefas.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public List<Tarefa> listarTodas() {
        return tarefas;
    }
}