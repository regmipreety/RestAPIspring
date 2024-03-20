# Getting Started

### Reference Documentation

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### JSON to Java POJO

* Convert JSON to Java POJO, call setter methods on POJO
* Convert Java POJO to JSON, call getter methods on POJO
* Jackson will call appropriate getter/setter method for you
* Spring will automatically handle Jackson Integration

### Spring @Controller Advice

* @ControllerAdvice is similar to an interceptor/filter
* Pre-process requests to controllers
* Post-process response to handle exceptions
* Perfect for global exception handling

### Rest API design

* For real time projects, who will use your API?
* How will they use the API?
* Design API based on requirements

#### API Design Process

* Review API requirements
* Identify main resource/entity
* Use HTTP methods to assign action on resource

### HTTP methods to assign action on resource

| HTTP Method | CRUD Application                         |
|-------------|------------------------------------------|
| POST        | Create a new entity                      |
| GET         | Read a list of entities or single entity |
| PUT         | Update an existing entity                |
| DELETE      | Delete an existing entity                |

### Purpose of Service Layer

* Service Facade design pattern
* Intermediate layer of custom business logic
* Integrate data from multiple sources (DAO/repositories)
  ![](C:\Users\priet\Downloads\Capture.JPG)

### Service layer- Best practice

* Best practice is to apply transactional boundaries at the service layer
* It is the service layer's responsibility to manage transaction boundaries
* For implementation code
    * Apply @Transactional on service methods
    * Remove @Transactional on DAO methods if they already exist
