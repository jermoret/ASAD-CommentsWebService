# ASAD - Web service with SOAP## Members- Mut Horia - Delessert Armand - Laville Jules - Moret Jérôme## SpecificationsWe must be able to post comments, retrieve the list of all comments and delete a comment.## Deploy the service1. Build the artifacts (.war) of the web service with Maven (```mvn clean install```).2. Copy the war deployed in the webapps folder of Tomcat.3. Start the tomcat server.## Service accessYou can access to the service at the URL 	[http://localhost:8080/comments-web-service-1/comments](http://localhost:8080/comments-web-service-1/comments).The WSDL can be accessed by [http://localhost:8080/comments-web-service-1/comments?wsdl](http://localhost:8080/comments-web-service-1/comments?wsdl).