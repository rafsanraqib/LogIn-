# LogIn
A simple Log in application using java sockets and mysql server

Program logic
The client.java file initially prompts the user for username and password and either clicks log in if old user or sign up if new user. Once the user has entered their credentials the program then uses sockets to transfer the information to the server.java file. The server then establises connection with the database and checks whether the credentials are valid if user clicked log in. If invalid the program pops up a friendly error message. If the user cliked sign up then a new record is created in the database. 

Database Connectivity 
I used Xaamp to connect to mysql server and the used the shell from the control panel to create a database named Credentials. I used the mysql library in java to establish database connectivity. 


