const API_URL = "http://localhost:8080/api/tarefas"

let tarefasAtuais = []

function escapeHTML(texto){
    const div = document.createElement("div");
    div.textContent = texto;
    return div.innerHTML;
}

async function criarTarefa(){
    console.log("Botão clicado!");

    const titulo = document.getElementById("titulo").value;
    const descricao = document.getElementById("descricao").value;

    console.log(titulo);
    console.log(descricao);

    const tarefa = {
        titulo: titulo,
        descricao: descricao,
        concluida: false
    };

    const resposta = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(tarefa)
    });

    console.log("Resposta: ", resposta);
    if (resposta.ok) {
        document.getElementById("titulo").value = "";
        document.getElementById("descricao").value = "";
    }
    else {
        console.error(resposta.status);
    }
    listarTarefas();
};

async function concluirTarefa(id){
    const tarefa = tarefasAtuais.find(t => t.id == id);
    if (!tarefa) return;

    const tarefaAtualizada = {
        titulo: tarefa.titulo,
        descricao: tarefa.descricao,
        concluida: !tarefa.concluida
    };

    const resposta = await fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(tarefaAtualizada)
    });

    console.log("Resposta: ", resposta);

    listarTarefas();
};

async function listarTarefas(){
    const resposta = await fetch(API_URL);
    const tarefas = await resposta.json();

    tarefasAtuais = tarefas;

    const lista = document.getElementById("lista_tarefas");
    lista.innerHTML = "";

    tarefas.forEach(tarefa => {
        const item = document.createElement("li");

        item.innerHTML = `
    <input type="checkbox" ${tarefa.concluida ? "checked" : ""} onchange="concluirTarefa(${tarefa.id})">
        ${escapeHTML(tarefa.titulo)} - ${escapeHTML(tarefa.descricao)}
    <button onclick="atualizarTarefa(${tarefa.id})">
        Editar
    </button>
    <button onclick="apagarTarefa(${tarefa.id})">
        Apagar
    </button>
`;
        lista.appendChild(item);
    })
}

async function apagarTarefa(id){
    await fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })

    listarTarefas();
}

listarTarefas();
