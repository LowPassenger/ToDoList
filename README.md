
#   <center>ToDoList application</center>  

Small help application for our team. It's inner app for close ToDo cases for me and my team members. So, 

# Project description

This application is backend part for creating, updatind, deleting ans so on the ToDo tasks 'stickers'. The following code provides such possibilities:

  *  New user registration via login and password
  *  User login and authentication
  *  RBAC (role based access control) with USER role only (code open for update) 
  *  Displaying all tasks, task by id, all tasks by status, delete tasks and update it
  *  The task has a status from enum list. It can be NEW, CURRENT, URGENT, DONE, ARCHIVE. The just created task has automatically NEW status
  *  Role is enum class and the database table. For now Role can be USER, ADMIN, MODERATOR. The only USER role is presented in app yet
  *  All traffic between frontend and backend is protected via HTTPS protocol (8443 port by default) and JWT token procedure
  *  Application uses the MySQL database to store the data
  *  The application is in the Docker-container, the database has another one
  *  The application use the FlyWay to service MySQL database
 

This app build using **SOLID** principles. All operations with the database implemented using **Hibernate** framework. Application use **Spring** framework and **Project Lombok** library.
  
#   <center>Realization details</center> 
 
To create the service I was used following technologies: Spring Framework 6.0.11, Spring Web MVC, Spring Security, Project Lombok Slf4j for logging, MySQL 8 server as database management system and MySQL Workbench as a shell, Hibernate framework 6.2 version, Apache Maven 3.8.4 as development tool package. 

The project uses following N-tier architecture:
  
  * Data Access Layer (Repository tier)
  * Application layer (service tier)
  * Security level (security tier)


#   <center>Installation and using</center>

Must have: JDK (Intellij IDEA Ultimate, Eclipse e.t.c), Git, Apache Maven, Postman API to create HTTP requests, MySQL or any other server and (optional) MySQL Workbench. Use guides and Google search for troubleshoot apps installation issues. 
Configure inner logger, use logback.xml file from
src/main/resources/
Standard path to log file is 
${HOME}/ToDoList/logs/
Maybe you need to change it to absolute path like "D:/Projects/cinema-application/logs/"
Also You can change log messages and log levels for messages in your code.
Create a database. I'm use a local MySQL database
In a src/main/resources/application.properties fill in your database credentials

You can use HTTP protocol for requests. All URL starts with localhost:8089 (Please comment HTTPS block on application.properties and uncomment the server.port=8089 line
For the best security use the HTTPS protocol. Please uncomment HTTPS block on application.properties and comment the server.port=8089 line
For request body blocks please use JSON data format.

The application and the database uses the two differet Docker containers! For run the Docker application, use:
docker run -p 3306:13306 --link musqlcont:mysql todolist


Here is the list of ends for URL address, what uses for:

/api/v1/login - here are two endpoints for the authorization and registrtion. Please, use 
login: root password: password for register as a User. 
Yes, I know that using these awful credentials is not a good idea, but it's a test project. Please, never do that on your real projects!

/api/v1/login/sign-up - POST request for registration of new user. Use the JSON {"login" : "root", "password" : "password"}

/api/v1/login/sign-in - POST request for login. Params: 
Authorization: none
Headers: Content-Type  application/json
Body: Use the JSON {"login" : "root", "password" : "password"} Give you the JWT token for authorization

/ - Congrats! Login complete, you can make requests to use the application.

For use those endpoints you must have the JWT authorization token!

/api/v1/tasks - work endpoints for the:

/api/v1/login/create - POST request for the task creation. Params: 
Authorization: Bearer token, use JSON like:
{
  "user": {
    "id": 1
  },
  "creationTime": "11-09-2023T01:13:23+02:00",
  "expirationTime": "10-12-2023T01:13:23+02:00",
  "status": "NEW",
  "description": "Dummy",
  "body": "bla bla bla"
}

/api/v1/login/update -  PUT request for aupdate task. Params: 
Authorization: JWT token
Headers: Content-Type  application/json
Body: {
    "id": 1,
  "creationTime": "11-09-2023T01:13:23+02:00",
  "expirationTime": "10-12-2023T01:13:23+02:00",
  "status": "URGENT",
  "description": "Aaaaaa",
  "body": "bla bla bla"
}

/api/v1/login - GET request returns actual list of tasks. Params: 
Authorization: JWT token

/api/v1/login/{id} - GET request returns task with {id}. Params: 
Authorization: JWT token

/api/v1/login/all-by-status - POST request for get list of tasks with same status. Params: 
Authorization: JWT token
Headers: Content-Type  application/json
Body: {"status": "NEW"}

/api/v1/login/{id} - DELETE request for delete task with {int movie session id} from database.
Authorization: JWT token


