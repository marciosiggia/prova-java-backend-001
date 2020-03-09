# Desafio
### Tempo de solução
Você terá 5 dias para realizar esse desafio.
### Plano de Fundo
A Lannister Serviços de Transporte fornece serviços de deslocamento e transporte para várias cidades na grande terra de Westeros. Por razões econômicas e para evitar emboscadas, a maioria das rotas é "de mão única". Ou seja, uma rota de Volantis para King's Landing não implica em uma rota de King's Landing para Volantis. De fato, mesmo que essas duas rotas existam, elas são distintas e não têm necessariamente a mesma distância!
### Fase da história
Como cliente da Lannister Serviços de Transporte, quero conhecer as rotas disponíveis entre as cidades bem como as distâncias, para que eu possa escolher a melhor rota para minha viagem.
### Narrativa / cenário de negócios
O objetivo desta aplicação é ajudar a Lannister Serviços de Transporte a fornecer a seus clientes informações sobre as rotas. Em particular, você calculará a distância ao longo de uma determinada rota, o número de rotas diferentes entre duas cidades e a rota mais curta entre duas cidades.
### Critérios funcionais e de aceitação
A entrada será fornecida como um grafo direcionado em que um nó representa uma cidade e uma aresta representa uma rota entre duas cidades. O número ao lado da aresta, representa a distância entre as duas cidades. Uma determinada rota nunca aparecerá mais de uma vez e, para uma determinada rota, a cidade inicial e final não serão a mesma. <br/><br/>
O grafo direcionado será representado como texto sem formatação, onde as cidades são nomeadas usando letras do alfabeto. Uma rota da cidade A para a cidade B com distância 5 é representada pela sequência AB6. Também pode ser representado como JSON:
~~~json
  { 
    "origem": "A", 
    "destino": "B", 
    "distancia": 6 
  }
~~~

### Exemplo de grafo:
![Texto da propriedade alt](/Graph.png "Exemplo de grafo")

### Exercícios
#### 1. Salvar configuração do grafo
Esse endpoint deve receber um grafo e armazená-lo no banco de dados para futuras referências.
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/grafo
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** CREATED
<br/>
**Contrato:**
*	**Request payload:**
~~~json
{
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia": 6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia": 4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia": 6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia": 2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia": 4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia": 3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia": 1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia": 7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia": 8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia": 5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia": 7 
    }
  ]
}
~~~
* **Response payload:**
~~~json
{
  "id" : 1,
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia":6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia":4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia":6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia":2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia":3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia":1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia":7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia":5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia":7 
    }
  ]
}
~~~

#### 2. Recuperar configuração do grafo
Esse endpoint deve recuperar um grafo salvo anteriormente do banco de dados. Se o grafo não existir, retornar uma resposta de erro NÃO ENCONTRADA.
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/grafo/\<id_grafo\>
<br/>
**Método HTTP:** GET
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:** não possui.
* **Response payload:**
~~~json
{
  "id" : 1,
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia":6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia":4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia":6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia":2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia":3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia":1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia":7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia":5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia":7 
    }
  ]
}
~~~
#### 3. Encontre rotas disponíveis para um determinado par de cidades
Esse endpoint deve calcular todas as rotas disponíveis de qualquer par de cidades dentro de um número máximo especificado de paradas. Se não houver rotas disponíveis, o resultado deve ser uma lista vazia. Caso o parâmetro "qtdMaxParadas" não seja fornecido, você deve listar todas as rotas para o par de cidades especificado. <br/><br/>
Por exemplo, no grafo (AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7), as rotas possíveis de A à C, com no máximo 3 paradas, seriam: ["ABC", "ADC", "AEBC"] 
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/rotas/de/\<cidade_1\>/para/\<cidade_2\>?qtdMaxParadas=\<qtd_maxima_de_paradas\>
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:**
~~~json
{
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia":6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia":4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia":6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia":2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia":3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia":1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia":7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia":5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia":7 
    }
  ]
}
~~~
* **Response payload:**
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

#### 4. Encontre rotas disponíveis para um determinado par de cidades no grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, ele deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/rotas/\<id_grafo\>/de/\<cidade_1\>/para/\<cidade_2\>? qtdMaxParadas=\<qtd_maxima_de_paradas\>
<br/>
**Método HTTP:** GET
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:** não possui.
* **Response payload:**
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
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/distancia
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:** 
~~~json
{
"caminho": ["A", "B", "C", "D"],
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia":6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia":4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia":6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia":2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia":3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia":1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia":7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia":5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia":7 
    }
  ]
}
~~~
* **Response payload:**
~~~json
{ 
  "distancia" : 9 
}
~~~

#### 6. Encontre a distância par o caminho em um grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/><br/>
**Endpoint:** http: //\<host\>:\<port\>/distancia/\<id_grafo\>
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:** 
* **Request payload:**
~~~json
{ 
  "caminho": [
    "A", 
    "B", 
    "C", 
    "D"
  ] 
}
~~~
* **Response payload:**
~~~json
{ 
  "distancia" : 9 
}
~~~

#### 7. Encontre distância entre duas cidades
Esse endpoint deve receber um grafo e encontrar o caminho mais curto entre duas cidades. Se a cidade inicial e final for igual, o resultado deverá ser zero. Se não houver caminho entre essas cidades, deve ser -1.
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/distancia/de/\<cidade_1\>/para/\<cidade_2\>
<br/>
**Método HTTP:** POST
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:**
~~~json
{
  "dados":[
    { 
      "origem": "A", 
      "destino": "B", 
      "distancia":6 
    },
    { 
      "origem": "A", 
      "destino": "E", 
      "distancia":4 
    },
    { 
      "origem": "B", 
      "destino": "A", 
      "distancia":6 
    },
    { 
      "origem": "B", 
      "destino": "C", 
      "distancia":2 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":4 
    },
    { 
      "origem": "C", 
      "destino": "B", 
      "distancia":3 
    },
    { 
      "origem": "C", 
      "destino": "D", 
      "distancia":1 
    },
    { 
      "origem": "C", 
      "destino": "E",  
      "distancia":7 
    },
    { 
      "origem": "B", 
      "destino": "D", 
      "distancia":8 
    },
    { 
      "origem": "E",  
      "destino": "B", 
      "distancia":5 
    },
    { 
      "origem": "E", 
      "destino": "D", 
      "distancia":7 
    }
  ]
}
~~~
* **Response payload:**
~~~json
{
  "distancia" : 3,
  "caminho" :  [
    "A", 
    "B", 
    "C"
  ]
}
~~~

#### 8. Encontre a distância entre duas cidades em um grafo salvo
Esse endpoint deve fazer exatamente o mesmo cálculo descrito no exercício anterior, mas deve usar um grafo salvo anteriormente. Se o grafo não existir no banco de dados, deverá retornar uma resposta de erro NÃO ENCONTRADA.
<br/><br/>
**Endpoint:** http://\<host\>:\<port\>/distancia/\<id_grafo\>/de/\<cidade_1\>/para/\<cidade_2\>
<br/>
**Método HTTP:** GET
<br/>
**Código de resposta HTTP:** OK
<br/>
**Contrato:**
* **Request payload:** não possui.
* **Response payload:**
~~~json
{
  "distancia" : 3,
  "caminho" : [
    "A", 
    "B", 
    "C"
  ]
}
~~~

## Dados de teste
### Grafo de entrada:
AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
### Casos de teste:
1. Distância da rota ABC: 9
2. Distância da rota AD: 5
3. Distância da rota ADC: 13
4. Distância da rota AEBCD: 22
5. Distância da rota AED: Rota não encontrada
6. Rotas começando em C e terminando em C com um máximo de 3 paradas: \
6.1. CDC (2 paradas) \
6.2. CEBC (3 paradas)
7.	Rotas começando em A e terminando em C com um máximo de 4 paradas: \
7.1. ABC (2 paradas) \
7.2. ADC (2 paradas) \
7.3. AEBC (3 paradas) \
7.4. ABCDC (4 paradas) \
7.5. ADCDC (4 paradas) \
7.6. ADEBC (4 paradas) 
8. Percurso mais curto (por distância) de A à C: ABC (distância = 9) 
9. Rota mais curta (por distância) de B à B: B (distância = 0)

### Detalhes técnicos
* Para iniciar o desenvolvimento, crie um fork deste repositório na sua conta de usuário. Essa versão será usada durante a avaliação.
* Você deve implementar mais do que um algoritmo barebone. Esperamos uma aplicação executável com uma estrutura mínima. Você deve criar um modelo de objeto e usar padrões de design onde for apropriado, mas tente manter as coisas simples.
* A aplicação já possui uma configuração do Maven.
* Verifique se o seu conjunto de testes faz parte da compilação depois de criá-lo.
* A aplicação inicia com um comando Maven: mvn spring-boot: run
* Você pode configurar outra maneira de iniciar sua aplicação sem o Spring Boot, mas não interrompa a inicialização do Spring Boot. Sua aplicação deve funcionar corretamente ao usar o comando de inicialização do Spring Boot.
* A aplicação deve ter uma API sem estado e usar um banco de dados para armazenar os dados.
* Um banco de dados H2, em memória, já está disponível para uso na configuração do projeto. Sinta-se à vontade para alterar essa implementação, mas você deve garantir que sua aplicação será inicializado como um processo independente em qualquer ambiente diferente.
* Embora você possa alterar a porta que a aplicação usará no desenvolvimento local, certifique-se de NÃO O MUDAR no seu repositório.
* A criação do banco de dados e das tabelas deve ser feita pelo Maven (estendendo o processo de compilação) ou pela aplicação.
* Documente qualquer informação adicional que julgue necessária para avaliar adequadamente seu teste.

### Avaliação
Depois de concluir sua avaliação, crie um pull request para enviar suas alterações ao repositório do SPC Brasil. A avaliação adotará a versão que você tinha naquele momento e nenhuma alteração futura será aceita.
<br/><br/>
Recomendamos que você use sua versão (do fork) deste repositório para organizar seu processo de desenvolvimento. É recomendado enviar pequenas alterações ao repositório e implementar aos poucos as funcionalidades, pois assim você evitará gastar muito tempo com erros de depuração. Você pode usar muitos commits e ramificações que desejar, mas verifique se a pull request foi criado **SOMENTE AO FINAL DO SEU DESENVOLVIMENTO**.

### Diretrizes de avaliação
Você será avaliado nos seguintes aspectos, classificados por prioridade:
1. Limpeza de código e consistência de nomes
2. Design orientado a objetos
3. Testes automatizados (testes de unidade e / ou integração)
4. Uso adequado da linguagem, recursos da estrutura e melhores práticas
5. Execução correta
6. Conclusão das funcionalidades

Lembre-se de que, para esta avaliação, é mais importante que você entregue um código de qualidade do que uma implementação completa do projeto. Seu código ainda será avaliado, mesmo se você não puder implementar todos os critérios de aceitação.
Espera-se que você complete esta avaliação sem a ajuda de ninguém. Faremos perguntas sobre o seu código em uma entrevista.
