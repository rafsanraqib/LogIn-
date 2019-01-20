import java.net.ServerSocket;
import java.lang.NullPointerException;
import java.sql.ResultSet;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Server {
	ServerSocket server, server2;
	Socket socket;
	Statement stmt;
	Connection con;
	String message = " ";
	ObjectInputStream input;
	ObjectOutputStream output;
	ResultSet rs;
	
public Server() {
	try {
		// Insert Statement //
	String URL = "jdbc:mysql://localhost/Credentials?user=root";
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(URL);
	stmt = con.createStatement();
	server = new ServerSocket(1097,500);
	server2 = new ServerSocket(1098,500);
    System.out.println("Server is running..");
    while(true) {
	socket = server.accept();
	input = new ObjectInputStream(socket.getInputStream());
	message = (String) input.readObject();
	stmt.execute(message);
	System.out.print("Successfully Added");
	// End of Insert Statement // 
	
	
    }// end of While
	}catch(IOException i) {
		System.out.println(i.toString());
	}catch(ClassNotFoundException c) {
		System.out.println(c.toString());
	}catch(SQLException s) {
		System.out.println(s.toString());
	}catch(NullPointerException n) {
		try {
		socket = server.accept();
		message = (String) input.readObject();
		rs = stmt.executeQuery(message);
		if(rs.next()) {
			message = rs.getString(1);
			System.out.println("Welcome " + message);
		}
		else {
			System.out.println("Wrong username");
		}
		}catch(IOException i) {
			System.out.println(i.toString());
		}catch(ClassNotFoundException c) {
			System.out.println(c.toString());
		}catch(SQLException s) {
		   System.out.println(s.toString());
		}
	}
	// ENd of While
		
}// End of Constructor

	public static void main(String[] args) {
		Server s = new Server();

	}

}
