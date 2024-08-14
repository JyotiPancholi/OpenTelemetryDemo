# OpenTelemetryDemo
**Setups**
  * **Clone the Repository**
  * **Build the Project**
     - mvn clean install
  * **Run the Spring Boot Application**
     - mvn spring-boot:run
  * **Simulate a Failed Login Attempt**
     - curl -X POST "http://localhost:8080/login/fail?username=testuser"
  * **Export the Failed Logins to a CSV File**
     - curl -X GET "http://localhost:8080/login/export"
  * **Check the Exported CSV File**

After running the export command, you should find the CSV file named failed-logins.csv in the project's root director    
