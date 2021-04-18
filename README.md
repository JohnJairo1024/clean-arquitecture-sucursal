# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando
con los componentes core de negocio (dominio) y por ultimo el inicio y configuracion de la aplicacion.

Lee el
articulo [Clean Architecture  Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)




# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el modulo mas interno de la arquitectura, pertenece a la capa del dominio y encapsula la logica y reglas del negocio
mediante modelos y entidades del dominio.

## Usecases

Este modulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define logica de
aplicacion y reacciona a las invocaciones desde el modulo de entry points, orquestando los flujos hacia el modulo de
entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no estan arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genericos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patron de
diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicacion o el inicio de los flujos de negocio.

##

##

![Arqutectura Limpia](https://user-images.githubusercontent.com/17706660/115155574-40306380-a046-11eb-9f1e-10f513757993.png)

##

##

### Endpoint

**POST** 
``{url}/api/v1/quote``

**HEADER:**

| Parameter    | Required     | Descripction | Example      |
| ------------ | ------------ | ------------ | ------------ |
|  channel      | ✓ |Channel or entity where the request is made | BANCO |
|  flow         |   |Flow or system where the request is made| ONBOARDING_CMR |
|  transactionId|   |Transaction identifier from Integration to Insurance |  123456|
|  country      | ✓ |Country Acronyms |  CO |
|  source       |   |Platform through which the client or user entered the data to make the offer | WEB_OMNI2 |
|  executiveId  |   |Executive id |  12345678|
|  branchId     |   |Branch Id |79, 78, 65, etc|
|  originIp     |   |Origin Ip |200.23.34.00|

**BODY:**

```json
{
   "payload": {
      "quote": {
         "branchCode": "179",
         "quoteNumber": "111111111",
         "consecutiveNumber": "0",
         "startDate": "2020-09-13",
         "endDate": "2021-09-13"
      },
      "insurance": {
            "line": "1",            
            "product": "10001" 
      }, 
      "vehicle": {
         "plate": "TKG777",
         "use": {
            "code": "001",
            "name": "PARTICULAR"
         },
         "type": {
            "code": "1",
            "name": "AUTO"
         },
         "brand": {
            "code": "80",
            "name": "RENAULT"
         },
         "model": {
            "code": "1188",
            "name": "SANDERO"
         },
         "address": {
            "area": {
               "level1": {
                  "code": "05001",
                  "name": "BOGOTA"
               },
               "level2": {
                  "code": "",
                  "name": ""
               },
               "level3": {
                  "code": "",
                  "name": ""
               }
            }
         },
         "year": "2018",
         "engineSerial": "APIMO1701009P",
         "chasisSerial": "APISERIE170221009P",
         "seats": "5",
         "condition": "NEW", 
         "commercialValue": {           
            "amount": "5000000",
            "currency": "CLP"
         }  
      },
      "customer": {
         "identificationDocument": {
            "type": "1",
            "number": "80497816",
            "validator":""  
         },
         "personType": {
            "code": "001",
            "name": "NATURAL"
         },
         "names": "CARLOS ANDRE",
         "paternal": "NAVARRO",
         "maternal": "COLMENARES",
         "birthdate": "1975-09-06",
         "gender":"M",
         "maritalStatus": "S",
         "nationality": "M", 
         "primaryContact": {
            "phoneNumber": "952802253",
            "cellphone": "",
            "email": "prueba@prueba.com.co"
         },
         "address": {
            "street": "MONEDA",
            "number": "970",
            "area": {
               "level1":{
                  "code": "05001",
                  "name": "BOGOTA"
               },
               "level2":{
                  "code": "001",
                  "name": "AVENIDITA"
               },
               "level3":{
                  "code": "05001",
                  "name": "BOGOTA"
               }
            }  
          }  
      }
   }
}
```

