package Serveur;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MainServerMessagerie {

	public static void main(String[] args) throws RemoteException, MalformedURLException{
		Naming.rebind("RMIChatServer", new ServerMessagerie());

	}

}
