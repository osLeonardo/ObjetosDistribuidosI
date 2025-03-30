# Projeto de Serviços RMI

## Instruções de Uso

### Pré-requisitos
- Certifique-se de que o Java está instalado no seu sistema.
- Compile o projeto para gerar os arquivos `.class`.

### Iniciar o Registro RMI
Antes de iniciar qualquer serviço, você precisa iniciar o registro RMI. Execute o seguinte comando no terminal:
```sh
rmiregistry
```

### Executar os Serviços Individualmente
1. **Iniciar o Serviço de Estudantes**:
- Execute o servidor de estudantes:
```sh
java -cp out Servers.StudentServer
```
- Execute o cliente de estudantes:
```sh
java -cp out Clients.StudentClient
```

2. **Iniciar o Serviço de Conversão para Maiúsculas**:
- Execute o servidor de conversão para maiúsculas:
```sh
java -cp out Servers.UpperCaseServer
```
- Execute o cliente de conversão para maiúsculas:
```sh
java -cp out Clients.UpperCaseClient
```

3. **Administrar Estudantes**:
- Execute o cliente de administração de estudantes:
```sh
java -cp out Clients.StudentClient
```

4. **Iniciar o Serviço de Livros**:
- Execute o servidor de livros:
```sh
java -cp out Servers.BookServer
```
- Execute o cliente de livros:
```sh
java -cp out Clients.BookClient
```

5. **Iniciar o Serviço de Votação**:
- Execute o servidor de votação:
```sh
java -cp out Servers.VotingServer
```
- Execute o cliente de votação:
```sh
java -cp out Clients.VotingClient
```

6. **Iniciar o Serviço de Produtos**:
- Execute o servidor de produtos:
```sh
java -cp out Servers.ProductServer
```
- Execute o cliente de produtos:
```sh
java -cp out Clients.ProductClient
```

### Troubleshooting

#### Comando `rmiregistry` Não Reconhecido

Se você encontrar o erro:
```
rmiregistry : The term 'rmiregistry' is not recognized as the name of a cmdlet, function, script file, or operable program.
```
Isso geralmente acontece porque o diretório `bin` do Java não está incluído na variável de ambiente `PATH` do seu sistema.

**Opção 1: Adicionar o Diretório `bin` do Java ao `PATH`**
1. Abra o Menu Iniciar e procure por "Variáveis de Ambiente".
2. Clique em "Editar as variáveis de ambiente do sistema".
3. Na janela Propriedades do Sistema, clique no botão "Variáveis de Ambiente".
4. Na janela Variáveis de Ambiente, encontre a variável `Path` na seção "Variáveis do sistema" e selecione-a.
5. Clique em "Editar" e depois em "Novo" para adicionar uma nova entrada.
6. Adicione o caminho para o diretório `bin` do Java (por exemplo, `C:\Program Files\Java\jdk-21\bin`).
7. Clique em "OK" para fechar todas as janelas.

**Opção 2: Especificar o Caminho Completo para `rmiregistry`**
Execute o comando `rmiregistry` com o caminho completo para o executável:
```sh
"C:\Program Files\Java\jdk-21\bin\rmiregistry"
```

Após realizar uma dessas opções, tente executar o comando `rmiregistry` novamente.

## Notas
- Certifique-se de que o registro RMI esteja em execução e acessível.
- Cada serviço é vinculado ao registro RMI no localhost com um nome específico.
- Modifique o código se precisar alterar o host ou a porta do registro.

## Licença
Este projeto é licenciado sob a Licença MIT.