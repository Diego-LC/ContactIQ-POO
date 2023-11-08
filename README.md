# ContactIQ

[![Rama principal](https://github.com/Diego-LC/ContactIQ-POO/tree/main)](https://github.com/Diego-LC/ContactIQ-POO/tree/main)
[![Desarrollo](https://github.com/Diego-LC/ContactIQ-POO/tree/BranchDiego)](https://codecov.io/gh/akshaybabloo/ContactIQ)  

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

```
mvn test
```

## Dependencies

ContactIQ usa las siguientes dependencias:

- JUnit 5.7.2
