package ifpb.edu.br.api_cadastro_tarefas.model;

public class Tarefa {
    private long id;
    private String titulo;
    private String descricao;
    private boolean concluida;


public Tarefa(){

}
public Tarefa(long id, String titulo, String descricao, boolean concluida){
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.concluida = concluida;
}

public long  getId(){
    return this.id;
}
public void setId(long id){
    this.id = id;
}
public String getTitulo(){
    return this.titulo;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
}

    public String getDescricao() {
        return descricao;
    }

public void setDescricao(String descricao) {
    this.descricao = descricao;
    }
    public boolean getConcluida(){
        return concluida;

    }
    public void setConcluida(boolean concluida){
    this.concluida = concluida;
    }

}
