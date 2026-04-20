# Consulta Tabela FIPE 🚗
<p align="center">
<img width="461" height="95" alt="image" src="https://github.com/user-attachments/assets/aa70ea6f-5792-4860-a34d-5d365efc6d2f" />
</p>
Este é um projeto desenvolvido em Java com Spring Boot que permite consultar o valor médio de veículos (carros, motos e caminhões) de acordo com a Tabela FIPE. A aplicação consome uma API externa, processa os dados e apresenta os resultados de forma organizada no console, utilizando recursos modernos do Java para filtragem e exibição.

## 🚀 Funcionalidades
- Consulta por Tipo de Veículo: Escolha entre carros, motos ou caminhões.
- Listagem de Marcas: Exibe todas as marcas disponíveis para o tipo de veículo selecionado.
- Busca de Modelos: Permite filtrar modelos por trechos do nome (ex: "Palio").
- Filtro por Ano: Após selecionar o modelo, o sistema lista os valores para diferentes anos/combustíveis.
- Exibição de Dados Detalhados: Mostra o valor, mês de referência, combustível e código FIPE do veículo selecionado.
- Transformação de Dados: Utiliza uma infraestrutura de classes genéricas para desserializar qualquer resposta da API.

## 🛠️ Tecnologias Utilizadas 
- Java 17: Utilização de Lambdas e Streams para manipulação de listas.
- Spring Boot 3: Base do projeto e gerenciamento de dependências.
- Jackson: Para mapeamento e tratamento de dados JSON.
- Java HttpClient: Para realizar requisições assíncronas à API de preços.

## ⚙️ Como executar o projeto
### 1. Pré-requisitos
- Java 17 ou superior.
- Maven instalado (ou uso do ./mvnw).

### 2. Execução
```
# Clone o repositório
git clone https://github.com/Dev-Joao-Medeiros/Tabela-Fipe.git

# Acesse a pasta do projeto
cd Tabela-Fipe

# Execute o projeto
./mvnw spring-boot:run
```

## 📊 Fluxo de Utilização
- O usuário digita o tipo de veículo (carro, moto ou caminhão).
- O sistema lista as marcas e o usuário digita o código da marca desejada.
- O usuário digita um trecho do nome do veículo para filtrar os modelos.
- O sistema exibe os modelos encontrados e o usuário escolhe o código do modelo.
- O sistema apresenta os valores de todos os anos disponíveis para aquele modelo específico.
