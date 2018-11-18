package Serveur;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Client.ClientMessagerieIF;
public  class ServerMessagerie  extends UnicastRemoteObject implements ServerMessagerieIF{
	private static final long serialVersionUID=1L;
	private ArrayList<ClientMessagerieIF> chatClients;
	protected ServerMessagerie() throws RemoteException{
		chatClients=new ArrayList<ClientMessagerieIF>();
	}
	public synchronized void registerChatClient(ClientMessagerieIF chatClient)
		throws RemoteException{
		this.chatClients.add(chatClient);
	}
	public synchronized void broadcastMessage(String message)throws RemoteException{
		int i=0;
		while(i<chatClients.size()) {
			chatClients.get(i++).retrieveMessage(message);
		}
	}
}
