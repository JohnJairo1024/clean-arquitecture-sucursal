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

