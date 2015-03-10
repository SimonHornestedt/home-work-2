import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Server extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	public Server(){
		super("Messenger Server");
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener(){
					public void actionPerformed( ActionEvent evt ){
						sendMessage( evt.getActionCommand() );
						userText.setText("");
						
					}
				}
			);
		this.add( userText, BorderLayout.NORTH );
		chatWindow = new JTextArea();
		this.add( new JScrollPane( chatWindow ));
		this.setSize( 300, 150 );
		this.setVisible( true );
	}
	
	//Set up and run the server
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100);
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
                                        
				}catch(EOFException eofException ){
					showMessage("\n Server ended the connection");
				}finally{
					closeThings();
				}
			}
		} catch ( IOException ioException ){
			ioException.printStackTrace();
		}
	}
	
	//wait for connection, then display connectioninformation
	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect... \n");
		this.connection = server.accept();
		showMessage("Connected to " + connection.getInetAddress().getHostName() +"\n" );
	}
	
	//setting up the stream to send and recieve data
	private void setupStreams() throws IOException {
		this.output = new ObjectOutputStream( connection.getOutputStream() );
		this.output.flush();
		this.input = new ObjectInputStream( connection.getInputStream() );
		showMessage( "\n Streams are now setup" );
		
	}
	
	//during the chat conversation
	private void whileChatting() throws IOException {
		String message = "You are now connected";
		sendMessage( message );
		ableToType(true);
		do{
			try{
				message = (String)input.readObject();
				showMessage( "\n" + message );
			}catch(ClassNotFoundException classNotFoundException){
				showMessage( "\n idk wtf that user sent!" );
			}
		}while( !message.equals("Client - END" ) );
	}
	
	// close streams and sockets
	public void closeThings(){
		showMessage( "\n Closing connections... \n" );
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
                        
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//send a message to the client
	private void sendMessage( String message ){
		try{
			output.writeObject( "Server - " + message );
			output.flush();
			showMessage( "\n Server - " + message );
		} catch (IOException ioException ){
			chatWindow.append( "\n Error: I Can't send that message" );
		}
	}
	
	//updates chatWindow
	private void showMessage( final String text ){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append( text );
				}
			}
		);
	}
	//allow user to type
	private void ableToType(final boolean tof ){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable( tof );
					}
				}
			);
	}
}