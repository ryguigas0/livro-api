# Livro API

API de cadastro de livros

## Rota interface web

A interface web é acessível pela rota `/backoffice`

## Rotas API

- `POST /livro/insert`: insere um livro

```json
// Exemplo de requisição
{
 "titulo": "Lorem ipsum dolor sit amet",
 "autor": "Lorem ipsum",
 "editora": "Lorem ipsum dolor",
 "ano": 2023,
 "preco": 32.99
}

// Exemplo de resposta
```

- `GET /livro/list?author={authorName}&title={bookTitle}`: lista os livros e filtra ignorando maiusculas e minúsculas com base no nome do autor (`authorName`) e título do livro (`bookTitle`) fornecidos

```json
// Exemplo de resposta
[
 {
  "id": "82e2fe28-1cc7-480a-8d57-5c0a92d3bc43",
  "titulo": "Lorem ipsum dolor sit amet",
  "autor": "Lorem ipsum",
  "editora": "Lorem ipsum dolor",
  "ano": 2023,
  "preco": 32.99
 }
]

```

- `PUT /livro/update/{livroId}`: atualiza o livro com o id igual ao fornecido (`livroId`)

```json
// Exemplo de requisição
{
 "titulo": "amet",
 "autor": "amet",
 "editora": "mattis rhoncus urna neque viverra.",
 "ano": 2023,
 "preco": 12.99
}

// Exemplo de resposta
{
 "id": "2669aa96-b71e-4b4c-ab0a-532a52bfeec4",
 "titulo": "amet",
 "autor": "amet",
 "editora": "mattis rhoncus urna neque viverra.",
 "ano": 2023,
 "preco": 12.99
}
```

- `DELETE /livro/delete/{livroId}`: remove o livro com o id igual ao fornecido (`livroId`), retorna apenas o status `200 OK`

Coleção do Insomnia no arquivo `insomnia_collection.json`
