A DEVinPharmacy LTDA, uma renomada empresa do ramo farmacêutico, está expandindo a sua rede de lojas. Por conta da expansão, o time de gestão necessita da criação de um sistema online, intitulado PharmacyManagement, para gerenciamento de medicamentos e farmácias. O seu perfil chamou a atenção dos gestores para a criação do back-end do sistema que deverá ser codificado em Java/Spring, e integrado ao front-end React criado anteriormente. Mãos à obra!
 Roteiro: https://docs.google.com/document/d/1fO_m2sjho3n5VL0pB4KETm88LtK__FvvfmHBmkB6oPM/edit#heading=h.dg7uhywn42wb

Documentação:
1 Endpoints
Utilizando o postman, este será o roteiro para acessar os endpoints assim como o JSON que deverá ser utilizado no body da aplicação.

1 -Usuário

cadastro do usuário será feito através do método POST na seguinte URL
http://localhost:8080/usuario/cadastro

Utilizaremos o seguinte JSON no body do postman

{
"email":"Seu usuario",
"senha":"Sua senha"
}

2 -Medicamento

Para o cadastro de um medicamento, utilizaremos o método POST na url
http://localhost:8080/medicamentos

JSON utilizado, lembrando que os campos nome_medicamento, nome_laboratório, dosagem, é obrigatório o preenchimento caso falte essas informações retornará uma resposta de erro:

{
"nome_medicamento":"Dorflex",
"nome_laboratorio":"Sanofi",
"dosagem":"1g",
"desc_medicamento":"Este medicamento é indicado como analgésico (para dor) e antitérmico (para febre). DORFLEX UNO é um medicamento à base de dipirona, utilizado no tratamento da dor e febre.",
"preco_unitario":"21.52",
"tipo_medicamento":"Venda Livre"
}

3 - Farmácia
Para cadastrarmos uma nova farmácia, a url que utilizaremos será a (Método POST)
http://localhost:8080/farmacia

O JSON que utilizaremos para o cadastro, lembrando que dados como razao social, cnpj, nome fantasia, email, celular, cep, numero, latitude e longitude é obrigatório o preenchimento. Dados como Logradouro, bairro, cidade, estado, serão preenchidos de forma automática após o post utilizando a interface FEIGN na API Viacep:


{
"razao_social": "Cia latino americana de medicamentos",
"cnpj": "teste",
"nome_fantasia": "teste",
"email": "testes",
"telefone":"teste",
"celular": "teste",
"endereco": {
"cep": "04296000",
"complemento":"Em frente ao posto de gasolina",
"numero":490,
"latitude":"1",
"longitude":"1"

    }
}

2 Como iniciar o servidor:
Primeiramente o projeto deverá ser clonado do github, após isso seguem os passos a serem feitos:

Após clonar o projeto crie um banco de dados (Projeto configurado para ser utilizado com PostgreSQL) o nome do banco deverá ser pharmacy-api, dentro do projeto tem uma pasta chamada scripts, poderá ser utilizada no query tool para criar as tabelas

Na pasta resources terá o arquivo application.properties que deverá ser configurado da seguinte forma:

spring.datasource.url=jdbc:postgresql://localhost:5432/pharmacy-api
spring.datasource.username=postgres
spring.datasource.password=kieras123

Após configurado poderá rodar o projeto utilizando o atalho SHIFT+F10 e realizar as requisições via postman


2 - FrontEnd:
No repositório será dividido em 2 pastas FrontEnd e BackEnd, onde o FrontEnd foi o projeto realizado em React,

Para inicializar é necessário o BackEnd estar também inicializado,
no terminal do projeto de FrontEnd, utilize npm install para instalar as dependências.



