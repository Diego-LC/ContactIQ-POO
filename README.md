# ContactIQ

[![Build Status](https://travis-ci.com/akshaybabloo/ContactIQ.svg?branch=master)](https://travis-ci.com/akshaybabloo/ContactIQ)
[![codecov](https://codecov.io/gh/akshaybabloo/ContactIQ/branch/master/graph/badge.svg?token=ZQZQZQZQZQ)](https://codecov.io/gh/akshaybabloo/ContactIQ)  

>ContactIQ es un gestor de contactos inteligente escrito en Java. Permite a los usuarios agregar, actualizar, eliminar y recuperar contactos. El proyecto incluye pruebas JUnit para garantizar la funcionalidad de las clases.

## Estructura del proyecto

El proyecto posee los siguientes archivos:

- `src/main/java/com/contactiq/model/Contactiq.java`: Este archivo exporta una clase  `Contacto`  que representa un contacto con propiedades como nombre, correo electrónico y número de teléfono.
- `src/test/`: Este directorio contiene pruebas JUnit para la clase  `Contactiq` .
- `pom.xml`: Este archivo es el archivo de configuración para Maven. Enumera las dependencias y complementos para el proyecto.
- `README.md`: Este archivo contiene información sobre el proyecto.

## Uso

To use ContactIQ, simply create an instance of the `ContactManager` class and call its methods to add, update, delete, or retrieve contacts.

```java
ContactManager contactManager = new ContactManager();
Contact contact = new Contact("John Doe", "johndoe@example.com", "555-1234");
contactManager.addContact(contact);
```

## Testing

To run the JUnit tests, use the following command:

```
mvn test
```

## Dependencies

ContactIQ uses the following dependencies:

- JUnit 5.7.2
