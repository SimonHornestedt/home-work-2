import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Client extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;
	private Socket connection;
	
	//konstruktor
	public Client( String host ){
		super("Messenger Client");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent evt){
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
	
	//start to server
	public void startRunning(){
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}catch( EOFException eofException ){
			showMessage( "\n Client terminated connection" );
		}catch( IOException ioException){
			ioException.printStackTrace();
		}finally{
			closeThings();
		}
	}

	//connect to server
	private void connectToServer() throws IOException{
		showMessage( "Attempting connection... \n" );
		connection = new Socket(InetAddress.getByName( serverIP ), 6789 );
		showMessage( "Connected to: " + connection.getInetAddress().getHostName() );
	}
	
	
	//set up streams to send and receive messages
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream( connection.getOutputStream() );
		output.flush();
		input = new ObjectInputStream( connection.getInputStream() );
		showMessage( "\n Streams are good to go" );
	}
	
	//while chatting with server
	private void whileChatting() throws IOException{
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage( "\n" + message );
			}catch( ClassNotFoundException classNotFoundException ){
				showMessage( "\n I don't know that object type" );
			}
			
		}while( !message.equals( "Server - END" ) );
	}
	
	//closing down the streams
	public void closeThings(){
		showMessage( "\n Closing concections..." );
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	//send message to server
	private void sendMessage( String message ){
		try{
			output.writeObject( "Client - " + message );
			output.flush();
			showMessage( "\n Client - " + message );
		}catch( IOException ioException){
			chatWindow.append( "\n Something messed up sending the message!" );
		}
	}
	
	//display message update chatWindow
	private void showMessage( final String message ){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append( message );
				}
			}
		);
	}
	
	//gives user abble to type
	private void ableToType( final boolean tof ){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					userText.setEditable( tof );
				}
			}
		);
	}
}
	
	