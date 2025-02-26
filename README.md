# Sistema de Controle de Aluguel de Veículos

## Descrição
Este repositório contém a implementação de um sistema para auxiliar uma empresa no controle do processo de aluguel de veículos. O sistema permite o gerenciamento de usuários, clientes, veículos e aluguéis, além da geração de relatórios financeiros e operacionais.

## Funcionalidades
- **Gerenciamento de Usuários:** Cadastro, edição e exclusão de usuários (apenas administradores podem criar, editar ou excluir).
- **Gerenciamento de Veículos:** Cadastro, edição e remoção (exclusivo para administradores).
- **Gerenciamento de Clientes:** Cadastro, edição e remoção (exclusivo para administradores).
- **Gerenciamento de Aluguéis:** Registro de retirada e devolução de veículos, com cálculo automático do custo total.
- **Relatórios:** Consulta de veículos alugados/disponíveis por data e receita total mensal.

## Tecnologias Utilizadas
- **Linguagem:** Java
- **Framework:** Spring Boot
- **Banco de Dados:** MySQL
- **ORM:** Hibernate
- **Gerenciamento de Dependências:** Maven
- **Diagramação:** UML para casos de uso e classes

## Estrutura do Projeto
```
/ (Raiz do Repositório)
|-- /src/main/java/com/empresa/aluguel  # Código-fonte principal
|   |-- controllers  # Classes controladoras
|   |-- services     # Regras de negócio
|   |-- repositories # Interfaces de acesso ao banco
|   |-- models       # Classes de entidade
|-- /src/main/resources
|   |-- application.properties  # Configuração do banco de dados
|-- /docs  # Diagramas UML e documentação
|-- README.md  # Documentação do projeto
|-- pom.xml  # Configuração do Maven
```

## Modelos e Diagramas
Os diagramas de casos de uso, classes e modelo entidade-relacionamento estão disponíveis na pasta `docs`.

## Instalação e Execução
### Requisitos
- JDK 17+
- MySQL 8+
- Maven

### Passos para Execução
1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
   ```
2. Configure o banco de dados no `application.properties`.
3. Execute o projeto com o Maven:
   ```bash
   mvn spring-boot:run
   ```
4. Acesse a API no navegador ou Postman: `http://localhost:8080`

## Colaboradores
- **Henrique Lecce** - [GitHub](https://github.com/HSLPines)
- **Fernando Adami** - [GitHub](https://github.com/caicara29)
- **João Pedro Helbel** - [GitHub](https://github.com/joaohelbel)
- **Gabriel Prestes** - [GitHub](https://github.com/gabrielpmcardoso)

### Orientação
Este projeto foi desenvolvido sob a orientação do professor **Carlos Rafael Gimenes das Neves** - [GitHub](https://github.com/carlosrafaelgn)

## Contribuição
Contribuições são bem-vindas! Para contribuir:
1. Fork o repositório.
2. Crie uma branch para sua feature: `git checkout -b minha-feature`
3. Commit suas alterações: `git commit -m 'Adiciona nova funcionalidade'`
4. Envie para o repositório: `git push origin minha-feature`
5. Abra um Pull Request.

## Licença
Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.


