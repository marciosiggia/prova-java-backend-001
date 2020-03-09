# Desafio - prova-java-backend-001
### Tempo de solução
Você terá 5 dias para realizar esse desafio.
### Plano de Fundo
A Lannister Serviços de Transporte fornece serviços de deslocamento e transporte para várias cidades na grande terra de Westeros. Por razões econômicas e para evitar emboscadas, a maioria das rotas é "de mão única". Ou seja, uma rota de Volantis para King's Landing não implica em uma rota de King's Landing para Volantis. De fato, mesmo que essas duas rotas existam, elas são distintas e não têm necessariamente a mesma distância!
### Fase da história
Como cliente da Lannister Serviços de Transporte, quero conhecer as rotas disponíveis entre as cidades bem como as distâncias, para que eu possa escolher a melhor rota para minha viagem.
### Narrativa / cenário de negócios
O objetivo deste aplicativo é ajudar a Lannister Serviços de Transporte a fornecer a seus clientes informações sobre as rotas. Em particular, você calculará a distância ao longo de uma determinada rota, o número de rotas diferentes entre duas cidades e a rota mais curta entre duas cidades.
### Critérios funcionais e de aceitação
A entrada será fornecida como um grafo direcionado em que um nó representa uma cidade e uma aresta representa uma rota entre duas cidades. O número ao lado da aresta, representa a distância entre as duas cidades. Uma determinada rota nunca aparecerá mais de uma vez e, para uma determinada rota, a cidade inicial e final não serão a mesma.
O grafo direcionado será representado como texto sem formatação, onde as cidades são nomeadas usando letras do alfabeto. Uma rota da cidade A para a cidade B com distância 5 é representada pela sequência AB6. Também pode ser representado como JSON:
~~~json
  { 
    "origem": "A", 
    "destino": "B", 
    "distancia":6 
  }
~~~

### Exemplo de grafo:
![Texto da propriedade alt](/Graph.png "Exemplo de grafo")
### Exercícios
#### 1. Salvar configuração do grafo
Esse endpoint deve receber um grafo e armazená-lo no banco de dados para futuras referências.
<br/>
**Endpoint:** http://\<host\>:\<port\>/grafo
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** CREATED
<br/>
**Contrato:**
*	Request payload:
~~~json
{
      "dados":[
          { "origem": "A", "destino": "B", "distancia":6 },
          { "origem": "A", "destino": "E", "distancia":4 },
          { "origem": "B", "destino": "A", "distancia":6 },
          { "origem": "B", "destino": "C", "distancia":2 },
          { "origem": "B", "destino": "D", "distancia":4 },
          { "origem": "C", "destino": "B", "distancia":3 },
          { "origem": "C", "destino": "D", "distancia":1 },
          { "origem": "C", "destino": "E",  "distancia":7 },
          { "origem": "B", "destino": "D", "distancia":8 },
          { "origem": "E",  "destino": "B", "distancia":5 },
          { "origem": "E", "destino": "D", "distancia":7 }
     ]
}
~~~
•	Response payload:
~~~json
{
     "id" : 1,
     "dados":[
          { "origem": "A", "destino": "B", "distancia":6 },
          { "origem": "A", "destino": "E", "distancia":4 },
          { "origem": "B", "destino": "A", "distancia":6 },
          { "origem": "B", "destino": "C", "distancia":2 },
          { "origem": "B", "destino": "D", "distancia":4 },
          { "origem": "C", "destino": "B", "distancia":3 },
          { "origem": "C", "destino": "D", "distancia":1 },
          { "origem": "C", "destino": "E",  "distancia":7 },
          { "origem": "B", "destino": "D", "distancia":8 },
          { "origem": "E",  "destino": "B", "distancia":5 },
          { "origem": "E", "destino": "D", "distancia":7 }
    ]
}
~~~

#### 2. Recuperar configuração do grafo
Esse endpoint deve recuperar um grafo salvo anteriormente do banco de dados. Se o grafo não existir, retornar uma resposta de erro NÃO ENCONTRADA.
<br/>
Endpoint: http://\<host\>:\<port\>/grafo/\<id_grafo\>
<br/>
Método HTTP: GET
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
* Request payload: não possui.
* Response payload:
~~~json
{
      "id" : 1,
      "dados":[
    { "origem": "A", "destino": "B", "distancia":6 },
    { "origem": "A", "destino": "E", "distancia":4 },
    { "origem": "B", "destino": "A", "distancia":6 },
    { "origem": "B", "destino": "C", "distancia":2 },
    { "origem": "B", "destino": "D", "distancia":4 },
    { "origem": "C", "destino": "B", "distancia":3 },
    { "origem": "C", "destino": "D", "distancia":1 },
    { "origem": "C", "destino": "E", "distancia":7 },
    { "origem": "B", "destino": "D", "distancia":8 },
    { "origem": "E",  "destino": "B", "distancia":5 },
    { "origem": "E", "destino": "D", "distancia":7 }
      ]
}
~~~

#### 3. Encontre rotas disponíveis para um determinado par de cidades
Esse endpoint deve calcular todas as rotas disponíveis de qualquer par de cidades dentro de um número máximo especificado de paradas. Se não houver rotas disponíveis, o resultado deve ser uma lista vazia. Caso o parâmetro "qtdMaxParadas" não seja fornecido, você deve listar todas as rotas para o par de cidades especificado.
Por exemplo, no grafo (AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7), as rotas possíveis de A à C, com no máximo 3 paradas, seriam: ["ABC", "ADC", "AEBC"]
<br/>
Endpoint: http://\<host\>:\<port\>/rotas/de/\<cidade_1\>/para/\<cidade_2\>?qtdMaxParadas=\<qtd_maxima_de_paradas\>
<br/>
Método HTTP: POST
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
<br/>
* Request payload:
~~~json
{
      "dados":[
          { "origem": "A", "destino": "B", "distancia":6 },
          { "origem": "A", "destino": "E", "distancia":4 },
          { "origem": "B", "destino": "A", "distancia":6 },
          { "origem": "B", "destino": "C", "distancia":2 },
          { "origem": "B", "destino": "D", "distancia":4 },
          { "origem": "C", "destino": "B", "distancia":3 },
          { "origem": "C", "destino": "D", "distancia":1 },
          { "origem": "C", "destino": "E",  "distancia":7 },
          { "origem": "B", "destino": "D", "distancia":8 },
          { "origem": "E",  "destino": "B", "distancia":5 },
          { "origem": "E", "destino": "D", "distancia":7 }
     ]
}
~~~
* Response payload:
~~~json
{
      "rotas": [
          { "rota": "ABC", "paradas": 2 },
          { "rota": "ADC", "paradas": 2 },
          { "rota": "AEBC", "paradas": 3 }
      ]
}
~~~

#### 4. Encontre rotas disponíveis para um determinado par de cidades no grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, ele deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/>
Endpoint: http://\<host\>:\<port\>/rotas/\<id_grafo\>/de/\<cidade_1\>/para/\<cidade_2\>? qtdMaxParadas=\<qtd_maxima_de_paradas\>
<br/>
Método HTTP: GET
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
* Request payload: não possui.
* Response payload:
~~~json 
{ 
  "rotas": [
    { 
      "rota": "ABC", 
      "paradas": 2 
    },
    { 
      "rota": "ADC", 
      "paradas": 2 
    },
    { 
      "rota": "AEBC", 
      "paradas": 3 
    }
  ] 
}
~~~

#### 5. Encontrar distância para o caminho
Esse endpoint deve receber um grafo e uma lista ordenada de cidades e recuperar a distância total, ao percorrer a lista de cidades, na ordem em que aparecem na solicitação. Se a lista de cidades estiver vazia ou tiver um único elemento, o resultado deverá ser zero. Se não houver um caminho descrito pela lista de cidades, o resultado deverá ser -1.
<br/>
Endpoint: http://\<host\>:\<port\>/distancia
<br/>
Método HTTP: POST
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
* Request payload: 
~~~json
{
  "caminho": ["A", "B", "C", "D"],
  "dados": [
    	{ "origem": "A", "destino": "B", "distancia":6 },
    	{ "origem": "A", "destino": "E", "distancia":4 },
    	{ "origem": "B", "destino": "A", "distancia":6 },
    	{ "origem": "B", "destino": "C", "distancia":2 },
    	{ "origem": "B", "destino": "D", "distancia":4 },
    	{ "origem": "C", "destino": "B", "distancia":3 },
    	{ "origem": "C", "destino": "D", "distancia":1 },
    	{ "origem": "C", "destino": "E", "distancia":7 },
    	{ "origem": "B", "destino": "D", "distancia":8 },
    	{ "origem": "E",  "destino": "B", "distancia":5 },
    	{ "origem": "E", "destino": "D", "distancia":7 }
  ]
}
~~~
* Response payload:
~~~json
{ 
  "distancia" : 9 
}
~~~

#### 6. Encontre a distância par o caminho em um grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/>
Endpoint: http: //\<host\>:\<port\>/distancia/\<id_grafo\>
<br/>
Método HTTP: POST
<br/>
Código de resposta HTTP: OK
<br/>
Contrato: 
* Request payload:
~~~json
{ "caminho": ["A", "B", "C", "D"] }
~~~
* Response payload:
~~~json
{ "distancia" : 9 }
~~~

#### 7. Encontre distância entre duas cidades
Esse endpoint deve receber um grafo e encontrar o caminho mais curto entre duas cidades. Se a cidade inicial e final for igual, o resultado deverá ser zero. Se não houver caminho entre essas cidades, deve ser -1.
<br/>
Endpoint: http://\<host\>:\<port\>/distancia/de/\<cidade_1\>/para/\<cidade_2\>
<br/>
Método HTTP: POST
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
* Request payload:
~~~json
{
      "dados": [
          { "origem": "A", "destino": "B", "distancia":6 },
          { "origem": "A", "destino": "E", "distancia":4 },
          { "origem": "B", "destino": "A", "distancia":6 },
          { "origem": "B", "destino": "C", "distancia":2 },
          { "origem": "B", "destino": "D", "distancia":4 },
          { "origem": "C", "destino": "B", "distancia":3 },
          { "origem": "C", "destino": "D", "distancia":1 },
          { "origem": "C", "destino": "E",  "distancia":7 },
          { "origem": "B", "destino": "D", "distancia":8 },
          { "origem": "E",  "destino": "B", "distancia":5 },
          { "origem": "E", "destino": "D", "distancia":7 }
     ]
}
~~~
* Response payload:
~~~json
{
  "distancia" : 3,
  "caminho" :  ["A", "B", "C"]
}
~~~

#### 8. Encontre a distância entre duas cidades em um grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/>
Endpoint: http://\<host\>:\<port\>/distancia/\<id_grafo\>/de/\<cidade_1\>/para/\<cidade_2\>
<br/>
Método HTTP: GET
<br/>
Código de resposta HTTP: OK
<br/>
Contrato:
* Request payload: não possui.
* Response payload:
~~~json
{
  "distancia" : 3,
  "caminho" : ["A", "B", "C"]
}
~~~