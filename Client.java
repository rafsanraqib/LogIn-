import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class Client extends JFrame implements ActionListener {
 JPanel npanel, cpanel = new JPanel();
 JLabel username, password = new JLabel();
 JTextField ufield, pfield = new JTextField();
 JButton lbutton, sbutton = new JButton();
 ServerSocket server;
 Socket socket, socket1;
 ObjectInputStream input;
 ObjectOutputStream output;

 public Client() {
		// Creation of N Panel //
	username = new JLabel("         Username"); // Creating username field
	ufield = new JTextField(20);
	password = new JLabel("         Password"); // Password field                           
	pfield = new JTextField(20);
	npanel = new JPanel(); // Creating panel to store the GUI
	npanel.setLayout(new FlowLayout());
	npanel.add(username);
	npanel.add(ufield);
	npanel.add(password);
	npanel.add(pfield);
	add(npanel, BorderLayout.CENTER);
 // End of N Panel //  
	
	// Creation of C panel //
	lbutton = new JButton("Log in");
	lbutton.addActionListener(this);
	sbutton = new JButton("Sign up");
	sbutton.addActionListener(this);
	cpanel = new JPanel();
	cpanel.setLayout(new FlowLayout());
	cpanel.add(lbutton);
	cpanel.add(sbutton);
	add(cpanel, BorderLayout.SOUTH);
	// End of C Panel //
	
	// Visibility //
	setSize(400,200);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// End of Visibility//
	}// End of Constructor

// Action Listener Method //
public void actionPerformed(ActionEvent event) {
	String username = ufield.getText();
	String password = pfield.getText();
	String select = "Select * from Information where password = " + password;
	String insert = "Insert into Information(Username, Password) values('" + username + "' ,'" + password + "');";
	try {
		output = new ObjectOutputStream(socket.getOutputStream());
	if(event.getSource()== sbutton) {
		socket = new Socket("", 1097);
		output.writeObject(insert);
		output.flush();
		
	}
	else if (event.getSource()== lbutton) {
		socket1 = new Socket("",1098);
		output.writeObject(select);
		output.flush();
	}
	}catch(IOException e) {
			System.out.println(e.toString());
		}
	
	
}
// End of Method//

    

	public static void main(String[] args) {
		Client c = new Client();

	}// end of Main

}// end of Class
