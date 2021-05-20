### Prerequisites

- This application uses [Spring Boot Web Starter](https://spring.io/guides/gs/spring-boot/)
- This application is based on the [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/) tutorial
- This application uses Java 1.8
- This application uses Maven for building and dependency management

### Application Structure

- Files must be located under `/src/main/java` to be picked up by Spring
- The demo source code is located in `src/main/java/com/example/restservice`
- The project assumes `com.example.restservice.DemoApplication` is the Spring Boot Application. To change this, remove the `@SpringBootApplication` annotation from `DemoApplication` and add it to another application class.

### Running the app

Press the "Run" button

-- OR -- 

From the Terminal in repl.it, run:

```
mvn clean package

java -jar target/restservice-0.0.1-SNAPSHOT.jar
```

A subwindow displaying a browser will appear, showing you the output. You may copy the URL and open it in a new browser tab to change the URL, e.g. adding `/greeting` to the end of the URL for the sample app will display the "Hello World" JSON.

### Endpoints

The base project has three endpoints you can build on. They are all defined in the `GreetingController`:

- `/` - a "Welcome to the Spring Boot Application Starter!" default page 
- `GET /greeting` - a GET endpoint that takes an optional `name` String parameter and returns a JSON `Greeting` object
- `POST /greeting` - a POST endpoint that takes a JSON body of the `Person` object with a name, and returns a JSON `Greeting` object

### Troubleshooting

- If the terminal window gets stuck in a loop while trying to run a `java` command, refresh the repl.it browser window for this project.