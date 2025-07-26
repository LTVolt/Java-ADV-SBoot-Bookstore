# Java-ADV-SBoot-Bookstore

Bookstore project creating a REST API for a Bookstore.

Using Postman you can easily use API accordingly.

This project serves(d) to learn / improve in:
1. How to create and manage a RESTful API - though a simple book management system;
2. What CRUD operations are and how to use them properly and efficiently;
3. Working with Databases (H2 and /or MySQL);
4. Spring Boot usage, DTOs, Mapping of Entities, Validation (Jakarta) and Exceprion Handling;
5. Dependency Injection;
6. Persistence througb Spring Data JPA.

What features does it have?
1. Checking what books we have in store (All);
2. Adding and removing books;
3. Searching specific books by title, author, ISBN or ID.

Root URL for Postman / curl should be http://localhost:8080/api/books
The JDBC URL is jdbc:h2:mem:bookdb as stated in src/main/java/resources/application.properties 

For example, to add a book using Postman (JSON):
1. POST http://localhost:8080/api/books
2. Body tab -> Select raw type -> Type in: 
  {
    "bookTitle": "Tales of an Orange Cat",
    "author": "John Arb.",
    "isbn": "8276497293045"
  }

Note: Lombok must be installed!

  
