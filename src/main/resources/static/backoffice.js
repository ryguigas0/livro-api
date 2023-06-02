function actionsHTML(idLivro) {
    return `
    <button onClick="deletarLivro('${idLivro}')">Deletar</button>
    `
}

function livro2HTML(livro) {
    return `
    <tr class="livro">
        <th scope="row">${livro.id}</th>
        <td class="name">${livro.titulo}</td>
        <td class="autor">${livro.autor}</td>
        <td>${livro.editora}</td>
        <td>${livro.ano}</td>
        <td>${livro.preco}</td>
        <td>${actionsHTML(livro.id)}</td>
    </tr>
    `
}

async function listarLivros() {
    console.log("listando")


    let url = "/api/livro/list?"

    let targetAuthor = document.querySelector("#target-autor").value
    if (targetAuthor) {
        url += `author=${targetAuthor}`
    }

    let targetTitle = document.querySelector("#target-titulo").value
    if (targetTitle) {
        url += `title=${targetTitle}`
    }

    try {
        const response = await fetch(url, {
            method: "get",
            headers: {
                "Content-Type": "application/json"
            },
        });

        const listaLivros = await response.json();

        console.log("Sucesso:", listaLivros);

        const livroTable = document.querySelector("#table-livros")

        livroTable.innerHTML = "";

        for (let i = 0; i < listaLivros.length; i++) {
            livroTable.innerHTML += livro2HTML(listaLivros[i])
        }

    } catch (error) {
        console.error("List error:", error);
    }
}

listarLivros()

async function deletarLivro(idLivro) {
    console.log("Deletar:", idLivro)

    try {
        const response = await fetch(`/api/livro/delete/${idLivro}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json",
            }
        });

        if (response.status == 200) {
            listarLivros()
        }
    } catch (error) {
        console.log("Delete error: ", error)
    }
}

async function upsertLivro() {
    console.log("upsert livro")
    
    let method = "post"
    let url = "/api/livro/insert"

    const livroId = document.querySelector("#livro-id").value
    if (livroId) {
        method = "put"
        url = `/api/livro/update/${livroId}`
    }

    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "titulo": document.getElementById("livro-titulo").value,
                "autor": document.getElementById("livro-autor").value,
                "editora": document.getElementById("livro-editora").value,
                "ano": document.getElementById("livro-ano").value,
                "preco": document.getElementById("livro-preco").value,
            })
        });

        if (response.status == 201 || response.status == 200) {
            listarLivros()
        } else {
            console.error(response.status, response.body)
        }
    } catch (error) {
        console.log("Create error: ", error)
    }
}