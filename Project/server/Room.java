package Project.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import Project.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    private List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private final static String ROLL = "roll";
    private final static String FLIP = "flip";
    private static Logger logger = Logger.getLogger(Room.class.getName());

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                //String dice;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    /*case ROLL:
                        dice = comm2[1];
                        Room.rollDice(dice, client);
                        break;
                    case FLIP:
                        Room.coinFlip(client);
                        break;
                    */
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /*protected void rollDice(String dice, ServerThread client){ // Rockwell Dela Rosa (rmd2), 4/5/2023
        if(dice.matches("[0-9]+)")){
            int diceNum = Integer.parseInt(dice);
            int result = (int)(Math.random() * (diceNum - 1));
            String message = client.getClientName() + " rolled a " + result + ".";
            sendMessage(null, message);
        }
        else{
            String[] tokens = dice.split("d");
            int diceNum = Integer.parseInt(tokens[0]);
            int sidesNum = Integer.parseInt(tokens[1]);
            int total = 0;
            for (int i = 0; i < diceNum; i++) {
                total += (int)(Math.random() * (sidesNum - 1));
            }
            String message = client.getClientName() + " rolled a " + total + ".";
            sendMessage(null, message);
        }
    }

    protected void coinFlip(ServerThread client){
        double rand = Math.random();
        if(rand >= 0.5){
            sendMessage(null, client.getClientName() + " flipped a coin and landed on heads.");
        }
        else{
            sendMessage(null, client.getClientName() + " flipped a coin and landed on tails.");
        }
    }*/

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     */
    protected synchronized void sendMessage(ServerThread sender, String message) { //Rockwell Dela Rosa, rmd2 4/5/2023
        if(message.startsWith("**") && message.endsWith("**")){
            message = message.substring(2, (message.length() - 2));
            message = "<b>" + message + "<b>";
        }
        if(message.startsWith("__") && message.endsWith("__")){
            message = message.substring(2, (message.length() - 2));
            message = "<u>" + message + "<u>";
        }
        if(message.startsWith("_") && message.endsWith("_")){
            message = message.substring(2, (message.length() - 2));
            message = "<i>" + message + "<i>";
        }
        if(message.startsWith("#r") && message.endsWith("r#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='red'>" + message + "</font>";
        }
        if(message.startsWith("#o") && message.endsWith("o#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='orange'>" + message + "</font>";
        }
        if(message.startsWith("#y") && message.endsWith("y#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='yellow'>" + message + "</font>";
        }
        if(message.startsWith("#g") && message.endsWith("r#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='green'>" + message + "</font>";
        }
        if(message.startsWith("#b") && message.endsWith("b#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='blue'>" + message + "</font>";
        }
        if(message.startsWith("#i") && message.endsWith("i#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='indigo'>" + message + "</font>";
        }
        if(message.startsWith("#v") && message.endsWith("v#")){
            message = message.substring(2, (message.length() - 2));
            message = "<font color='violet'>" + message + "</font>";
        }
        if (!isRunning) {
            return;
        }
        logger.info(String.format("Sending message to %s clients", clients.size()));
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }
        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }
    }

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    private void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        iter.remove();
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}
