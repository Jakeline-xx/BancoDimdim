
# BancoDimdim

**DDL das tabelas e colunas:**

```sql
Hibernate: 
    create table cliente (
        id bigint identity not null,
        idade int,
        nome varchar(255),
        primary key (id)
    )
Hibernate: 
    create table conta (
        id bigint identity not null,
        saldo int,
        tipo varchar(255),
        cliente_id bigint,
        primary key (id)
    )
Hibernate: 
    alter table conta
       add constraint FKfksaesgpmec0cph81iq5or1wn
       foreign key (cliente_id)
       references cliente


Criação do banco de dados sqlserver via terminal após criação do grupo de recursos:
az sql server create -l brazilsouth -g bancosql -n sqlserver-rm96261 -u admuser -p minhasenha123@ --enable-public-network true
az sql db create -g bancosql -s sqlserver-rm96261 -n dimdim --service-objective Basic --backup-storage-redundancy Local --zone-redundant false
az sql server firewall-rule create -g bancosql -s sqlserver-rm96261 -n AllowAll --start-ip-address 0.0.0.0 --end-ip-address 255.255.255.255

Para deploy desse código em Nuvem da mesma forma mostrada no vídeo:

Utilizar a IDE do VS Code, baixar as extensões da Azure (Azure App Service e Azure Account)
Utilizar ícone da Azure, selecionar o plano, criar um app service com as informações do projeto: 
- Create New App Service (Advanced) 
- Inserir nome da aplicação, selecionar o grupo de recursos criado anteriormente
- Selecionar versão 17 do Java
- Selecionar Web Server Java Embedded
- Escolher sistema operacional Linux
- Criar um novo plano de serviço, escolhendo Free F1
- Skip no Application Insights

Após a criação concluída, clicar com o botão direito no recurso criado e selecionar "Deploy to Web App"
Selecionar a pasta do projeto, aceitar a porta 8080, confirmar Build e Deploy


JSON das operações que foram mostradas em video:

Para GET e DELETE, utilizar a URL passando /{id}

https://appdimdim.azurewebsites.net/clientes
POST:
{
    "nome": "Isabela",
    "idade": 21
}

PUT (utilizar a URL passando /{id}):
{
    "nome": "Jake",
    "idade": 30
}

https://appdimdim.azurewebsites.net/contas
POST:
{
  "tipo": "Conta Poupanca",
  "saldo": 2000,
  "cliente": {
    "id": 2
  }
}

PUT (utilizar a URL passando /{id}):
{
  "tipo": "Conta Corrente",
  "saldo": 2000,
  "cliente": {
    "id": 1
  }
}




