package Part3HW;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class Server {
    int port = 3001;
    // connected clients
    private List<ServerThread> clients = new ArrayList<ServerThread>();

    private void start(int port) {
        this.port = port;
        // server listening
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            Socket incoming_client = null;
            System.out.println("Server is listening on port " + port);
            do {
                System.out.println("waiting for next client");
                if (incoming_client != null) {
                    System.out.println("Client connected");
                    ServerThread sClient = new ServerThread(incoming_client, this);
                    
                    clients.add(sClient);
                    sClient.start();
                    incoming_client = null;
                    
                }
            } while ((incoming_client = serverSocket.accept()) != null);
        } catch (IOException e) {
            System.err.println("Error accepting connection");
            e.printStackTrace();
        } finally {
            System.out.println("closing server socket");
        }
    }
    protected synchronized void disconnect(ServerThread client) {
		long id = client.getId();
        client.disconnect();
		broadcast("Disconnected", id);
	}

    protected synchronized void broadcast(String message, long id) {
        if(processCommand(message, id)){

            return;
        }
        // let's temporarily use the thread id as the client identifier to
        // show in all client's chat. This isn't good practice since it's subject to
        // change as clients connect/disconnect
        message = String.format("User[%d]: %s", id, message);
        // end temp identifier
        
        // loop over clients and send out the message
        Iterator<ServerThread> it = clients.iterator();
        while (it.hasNext()) {
            ServerThread client = it.next();
            boolean wasSuccessful = client.send(message);
            if (!wasSuccessful) {
                System.out.println(String.format("Removing disconnected client[%s] from list", client.getId()));
                it.remove();
                broadcast("Disconnected", id);
            }
        }
    }

    private boolean processCommand(String message, long clientId){
        System.out.println("Checking command: " + message);
        if(message.equalsIgnoreCase("disconnect")){
            Iterator<ServerThread> it = clients.iterator();
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    it.remove();
                    disconnect(client);
                    
                    break;
                }
            }
            return true;
        }
        if(message.equalsIgnoreCase("coinflip")){ // rmd2, 2/23/2023, demonstrating coinflip command
            double rand = Math.random(); // determines random double, will be used for heads/tails
            Iterator<ServerThread> it = clients.iterator(); // same process as disconnect command
            while (it.hasNext()) {
                ServerThread client = it.next();
                if(client.getId() == clientId){
                    if(rand >= 0.5){ // 50/50 chance of heads and tails
                        message = clientId + " flipped a coin and it landed on heads!";
                    }
                    else message = clientId + " flipped a coin and it landed on tails!";
                    broadcast(message, clientId); // broadcast the results
                }
            }
            return true;
        }
        if(message.startsWith("shuffle ")){ // looking for shuffle command
            String newmsg = message.replace("shuffle ", ""); // get string without command
            ArrayList<String> list = new ArrayList<String>(); // turning into list
            ArrayList<String> ret = new ArrayList<String>(); // list to get shuffled word
            for(int i=0; i<newmsg.length(); i++){
                list.add(newmsg.substring(i,i+1)); // chars in msg but in list
            }
            while(list.size() != 0){ // add to new list in random order, remove from original list
                int toGet = (int)(Math.random() * (list.size()-1));
                ret.add(list.get(toGet));
                list.remove(list.get(toGet));
            }
            String msg = ""; // blank string at first
            for(int i=0; i<ret.size(); i++){
                msg = msg + ret.get(i); // turn new list into string
            }
            broadcast(msg, clientId); // broadcast the new shuffled string
            return true;
        } //rmd2, 2/23/2023, demonstrating shuffle command in action

        return false;
    }
    public static void main(String[] args) {
        System.out.println("Starting Server");
        Server server = new Server();
        int port = 3000;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            // can ignore, will either be index out of bounds or type mismatch
            // will default to the defined value prior to the try/catch
        }
        server.start(port);
        System.out.println("Server Stopped");
    }
}