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

    public Tarefa criar(Tarefa tarefa) {
        tarefa.setId((long) (tarefas.size() + 1));
        tarefas.add(tarefa);
        return tarefa;
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == (id)) {
                tarefa.setTitulo(tarefaAtualizada.getTitulo());
                tarefa.setDescricao(tarefaAtualizada.getDescricao());
                tarefa.setConcluida(tarefaAtualizada.getConcluida());

                return tarefa;
            }
        }

        return null;
    }
    public boolean deletar(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == (id)) {
                tarefas.remove(tarefa);
                return true;
            }
        }

        return false;
    }




}