FROM amazoncorretto AS TODOLIST_BUILD
# copy the project to the container
COPY target/ToDoList-0.0.1-SNAPSHOT.jar /application.jar
WORKDIR /ToDoList
# set the startup command to execute the jar
CMD ["java", "-jar", "/application.jar"]