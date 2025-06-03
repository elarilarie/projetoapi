
API REST simples para conversão de moedas, feita em Java e Spring Boot. Feito com o objetivo de um projeto para faculdade. 

Para rodar precisa: 

1. Clonar o repositório:

```bash
git clone https://github.com/seu-usuario/currency-converter-api.git
cd currency-converter-api

2. Executar com Maven:

./mvnw spring-boot:run  

- (Ou pode rodar direto pela sua IDE (IntelliJ, Eclipse, VS Code).)

. Endpoint da API
GET /api/currency/convert

- Parâmetro        Tipo	        Descrição
- from	         String	        Código da moeda de origem (ex: USD)
- to	             String	        Código da moeda de destino (ex: EUR)
- amount	         Double	        Valor a ser convertido


. Exemplo de requisição:

GET http://localhost:8080/api/currency/convert?from=USD&to=EUR&amount=100


. Exemplo de resposta:
json
Copiar
Editar
{
  "from": "USD",
  "to": "EUR",
  "original_amount": 100,
  "converted_amount": "92.00",
  "rate_from_USD": 0.92
}


. Moedas suportadas

USD (Dólar)
EUR (Euro)
GBP (Libra)
BRL (Real)
JPY (Iene)
AUD (Dólar australiano)
CAD (Dólar canadense)


. Tecnologias
Java 17
Spring Boot 3
Maven
