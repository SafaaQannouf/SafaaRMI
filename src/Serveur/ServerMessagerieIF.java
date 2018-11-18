package Serveur;
import java.rmi.Remote;
import java.rmi.RemoteException;

import Client.ClientMessagerieIF;

public interface ServerMessagerieIF extends Remote{
	void registerChatClient(ClientMessagerieIF chatClient) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;
}

