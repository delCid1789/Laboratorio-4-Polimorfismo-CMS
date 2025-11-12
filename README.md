# Laboratorio 4 - Polimorfismo: CMS

Sistema de Gestión de Contenidos (CMS) para el Estudio de Grabación Audiovisual (EGA)

## Descripción

CMS desarrollado con Java aplicando los principios de Programación Orientada a Objetos y el patrón MVC.

## Características

- Crear, editar y eliminar contenidos (artículos, videos, imágenes)
- Publicar y despublicar contenidos
- Buscar contenidos por palabra clave
- Filtrar contenidos por tipo
- Interfaz de consola interactiva

## Estructura del Proyecto

```
├── Main.java                  # Punto de entrada
├── model/                     # Modelos de datos
│   ├── Content.java          # Clase abstracta base
│   ├── Article.java          # Contenido tipo artículo
│   ├── Video.java            # Contenido tipo video
│   ├── Image.java            # Contenido tipo imagen
│   ├── Category.java         # Categorías
│   └── ContentModel.java     # Gestión de contenidos
├── Vista/                     # Capa de presentación
│   ├── CMSView.java          # Interfaz de vista
│   └── ConsoleView.java      # Implementación consola
├── controller/                # Controladores
│   └── ContentController.java
└── interfaces/                # Interfaces
    ├── Publishable.java
    ├── Categorizable.java
    └── Searchable.java
```

## Conceptos POO Aplicados

### Herencia
- `Content` es clase abstracta base
- `Article`, `Video`, `Image` heredan de `Content`

### Polimorfismo
- **Vía interfaces**: `Publishable` implementado en los 3 tipos de contenido
- **Vía herencia**: Métodos abstractos `display()` y `validate()`
- **En controladores**: Uso de `instanceof` para verificar `Publishable`

### Interfaces
- `Publishable`: Publicar/despublicar contenidos
- `Categorizable`: Gestionar categorías
- `Searchable`: Búsqueda y filtrado

### Arquitectura MVC
- **Modelo**: Clases de datos y lógica de negocio
- **Vista**: `ConsoleView` para interacción con usuario
- **Controlador**: `ContentController` coordina modelo y vista

## Compilación y Ejecución

```bash
# Compilar
javac Main.java

# Ejecutar
java Main
```

## Uso

Al ejecutar el programa, verás un menú con las siguientes opciones:

1. Crear Contenido
2. Ver Contenidos
3. Buscar Contenido
4. Editar Contenido
5. Eliminar Contenido
6. Publicar/Despublicar
7. Filtrar por Tipo
0. Salir

El sistema incluye 3 contenidos de ejemplo precargados.

