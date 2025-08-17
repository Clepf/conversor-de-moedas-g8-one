# 💰 Conversor de Moedas

## 📋 Índice

* [Descrição do Projeto](#-descrição-do-projeto)
* [Status do Projeto](#status-do-projeto)
* [Funcionalidades](#-funcionalidades)
* [Acesso ao Projeto](#-acesso-ao-projeto)
* [Tecnologias Utilizadas](#tecnologias-utilizadas)
* [Pessoas Desenvolvedoras](#-pessoas-desenvolvedoras)

## 📝 Descrição do Projeto

O **Conversor de Moedas** é uma aplicação Java que permite realizar conversões entre diferentes moedas em tempo real utilizando a Exchange Rate API. Com uma interface de console intuitiva, o sistema oferece acesso a 20 das principais moedas globais, proporcionando conversões precisas e atualizadas para facilitar transações internacionais e controle financeiro.

## ⏱️ Status do Projeto

✅ Projeto Finalizado ✅

## 🔨 Funcionalidades

- `Seleção de 20 Moedas`: Acesso às principais moedas mundiais (USD, EUR, JPY, GBP, BRL, etc.)
- `Conversão em Tempo Real`: Taxas de câmbio atualizadas via Exchange Rate API
- `Interface Intuitiva`: Menu numerado com códigos e nomes completos das moedas
- `Histórico Completo`: Registro de todas as conversões realizadas na sessão
- `Logs com Timestamp`: Rastreamento detalhado com data/hora usando java.time
- `Validação Robusta`: Tratamento de erros para entradas inválidas e falhas de API
- `Configuração Externa`: Chave da API armazenada em arquivo properties separado

## 🔗 Acesso ao Projeto

Para executar o projeto localmente:

```bash
# Clone este repositório
git clone https://github.com/user/conversor-moedas.git

# Acesse a pasta do projeto
cd conversor-moedas

# Configure sua chave da API no arquivo config.properties
echo "api.key=SUA_CHAVE_AQUI" > src/main/resources/config.properties

# Compile e execute (usando Maven)
mvn clean compile exec:java

# Ou execute diretamente (se usar javac)
javac -cp "lib/*:src/main/java" src/main/java/Principal.java
java -cp "lib/*:src/main/java" Principal
```

**Pré-requisitos:**
- Java 11 ou superior
- Biblioteca Gson (para manipulação JSON)
- Chave de API da Exchange Rate API (gratuita)

## 🛠️ Tecnologias Utilizadas

- `Java 11+` - Linguagem de programação principal
- `HttpClient` - Para requisições HTTP nativas
- `Gson` - Biblioteca para serialização/deserialização JSON
- `java.time` - API moderna para manipulação de datas
- `Exchange Rate API` - Fonte de taxas de câmbio em tempo real
- `Properties` - Configuração externa da aplicação
- `Maven` - Gerenciamento de dependências (opcional)

## 👥 Pessoas Desenvolvedoras

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/88713149?s=400&u=4104bd7a1fb2143ecf5d1470b0c829bc5898c250&v=4" width=115><br><sub>Clepf</sub>](https://github.com/Clepf) |
| :---: |

---

> Este projeto foi desenvolvido como parte do Challenge Oracle Next Education (ONE) e demonstra aplicação prática de Java backend, consumo de APIs REST e programação orientada a objetos.