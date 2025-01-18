# ABCfitness-spring-boot-project

Prerequisites
Java 17: Ensure Java is installed .
Maven: Build and manage the project dependencies.

How to Run the Project

Clone the Repository: Clone the project to your local machine using:
bash
git clone https://github.com/nagesh-cheviti/ABCfitness-spring-boot-project.git


Navigate to the Project Directory:
bash
cd ABCfitness-spring-boot-project


Build and Run the Application: Use Maven to build and run the Spring Boot application:
bash
mvn spring-boot:run

Access the API: The API will be available at:
http://localhost:8080


#API Endpoints
1. Create a Class
			POST http://localhost:8080/classes
			Request Body:
			json
			{
			  "name": "Yoga",
			  "startDate": "2025-01-20",
			  "endDate": "2025-01-25",
			  "startTime": "14:00",
			  "duration": 60,
			  "capacity": 10
			}
   
			Response:
			201 Created: Class created successfully.
			400 Bad Request: Validation errors such as endDate in the past or capacity less than 1.
   
2. Get All Classes
			GET http://localhost:8080/classes
			Description: Retrieve all classes and their details.
			Response Example:
			json
			[
			  {
			    "name": "Yoga",
			    "startDate": "2025-01-20",
			    "endDate": "2025-01-25",
			    "startTime": "14:00",
			    "duration": 60,
			    "capacity": 10
			  }
			]
   
3. Book a Class
			POST http://localhost:8080/bookings
			Request Body:
			json
			{
			  "memberName": "nagesh",
			  "className": "Yoga",
			  "participationDate": "2025-01-24"
			}
   
			Response:
			201 Created: Booking created successfully.
			400 Bad Request: Errors such as:
					participationDate is in the past.
					Class is full for the requested date.
					Required fields are missing.
   
4. Search Bookings
			GET http://localhost:8080/bookings
			Query Parameters:
					memberName (string, optional): Filter by member name.
					startDate (date, optional): Start of the date range in yyyy-MM-dd format.
					endDate (date, optional): End of the date range in yyyy-MM-dd format.
   
			Sample Requests:
			Search by member:
			bash
			GET /bookings?memberName=nagesh
   
			Search by date range:
			bash
			GET /bookings?startDate=2025-01-20&endDate=2025-01-25
   
			Combined search:
			bash
			GET /bookings?memberName=John&startDate=2025-01-20&endDate=2025-01-25
   
			Response Example:
			json
			[
			  {
			    "memberName": "John Doe",
			    "className": "Yoga",
			    "participationDate": "2025-01-24"
			  }
			]

	 
Testing the APIs
		Using Postman
