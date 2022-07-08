FROM openjdk:8
EXPOSE 8080
#EXPOSE 3306
#RUN mvn clean package
#ADD target/EmployeeManagementSystem-0.0.1-SNAPSHOT.jar EmployeeManagementSystem-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/EmployeeManagementSystem-0.0.1-SNAPSHOT.jar"]
#finalName
ADD target/employee-management-system.jar employee-management-system.jar
ENTRYPOINT ["java","-jar","/employee-management-system.jar"]