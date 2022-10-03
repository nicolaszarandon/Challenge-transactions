# challenge-transactions
finalizacion challenge transactions

Especificación del servicio
PUT /transactions/$transaction_id

1
2 Body:
3
4 { "amount":double,"type":string,"parent_id":long }
5
6
Codigo 1: PUT transaction


En dónde:
• transaction_id Es de tipo ’long’ identificador de una nueva transacción.
• amount Es de tipo ’double’ espcificando el monto.
• type es un ’string’ que identifica el tipo de la transacción.
• parent_id Es de tipo ’long’, opcional. El cual especifica el id de la transacción padre.


GET /transactions/types/$type
1
2 Returns:
3
4 [ long, long, .... ]
5
6


Codigo 2: GET by type

Una lista json de todos los ids de las transacciones para el tipo especificado.


GET /transactions/sum/$transaction_id
1
2 Returns:
3
4 { "sum", double }
5
6

Codigo 3: GET SUM

La suma de todas las transacciones que estan transitivamente conectadas por su parent_id a
$transaction_id.


Algunos ejemplos simples podrian ser:

1
2 PUT /transactions/10 { "amount": 5000, "type": "cars" }
3 => { "status": "ok" }
4
5 PUT /transactions/11 { "amount": 10000, "type": "shopping", "parent_id": 10 }
6
7 GET /transactions/types/cars => [10]
8 GET /transactions/sum/10 => {"sum":15000}
9 GET /transactions/sum/11 => {"sum":10000}
10
11
Codigo 4: Ejemplos


utilice docker-compose.yml con la siguiente configuracion:

version: '3.9'
name: postgres
services:

  postgres:
    image: postgres:14.1
    container_name: db-postgres
    #restart: unless-stopped
    environment:
      - DATABASE_HOST=127.0.0.1
      - POSTGRES_USER=postgres
      - POSTGRES_PASSWORD=1234
      - POSTGRES_DB=prueba
    ports:
      - '5432:5432'
    networks:
      - net_postgres
    volumes:
      - $PWD/data:/var/lib/postgresql/data      

networks:
  net_postgres:
