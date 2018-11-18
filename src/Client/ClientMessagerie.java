package Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import Serveur.ServerMessagerieIF;

public class ClientMessagerie extends UnicastRemoteObject implements ClientMessagerieIF, Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServerMessagerieIF chatServer;
	private String name=null;
	
	protected ClientMessagerie(String name,ServerMessagerieIF chatServer) throws RemoteException{
		this.name=name;
		this.chatServer=chatServer;
		chatServer.registerChatClient(this);
	}
	public void retrieveMessage(String message) throws RemoteException{
		System.out.println(message);
	}
	public void run() {
		Scanner scanner=new Scanner(System.in);
		String message;
		while(true) {
			message=scanner.nextLine();
			try {
				chatServer.broadcastMessage(name+" : " +message);
			} catch(RemoteException e) {
				e.printStackTrace();
			}
		}
	}



}
