package Client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Serveur.ServerMessagerieIF;

public class MainClientMessagerie {

	public static void main(String[] args) throws MalformedURLException, RemoteException,NotBoundException{
		String chatServerURL="rmi://localhost/RMIChatServer";
		ServerMessagerieIF chatServer=(ServerMessagerieIF) Naming.lookup(chatServerURL);
		new Thread(new ClientMessagerie(args[0],chatServer)).start();
	}
}
