package ifpb.edu.br.api_cadastro_tarefas.model;

public class tarefa {
    private long id;
    private String titulo;
    private String descricao;
    private boolean concluida;


public tarefa(){

}
public tarefa(long id,String titulo,String descricao,boolean concluida){
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.concluida = concluida;
}

public long  getId(){
    return this.id;
}
public void setId(long id1){
    this.id = id1;
}
public String getTitulo(){
    return this.titulo;
}
public void setTitulo(String t){
    this.titulo = t;
}

    public String getDescricao() {
        return descricao;
    }

public void setDescricao(String dc) {
    this.descricao = dc;
    }
    public boolean getConcluida(){
        return concluida;

    }
    public void setConcluida(boolean c){
    this.concluida = c;
    }

}
