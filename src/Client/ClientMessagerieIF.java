package Client;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ClientMessagerieIF extends Remote{
	void retrieveMessage(String message) throws RemoteException;
}		
