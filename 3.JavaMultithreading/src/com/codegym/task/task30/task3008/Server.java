package com.codegym.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Handler;

public class Server {
    private static Map<String, Connection> connectionMap=new ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException,
                ClassNotFoundException{
            Message nameuser=null;
            while(true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                nameuser=connection.receive();
                if((nameuser.getType()==MessageType.USER_NAME)&&(nameuser.getData()!=null)&&(!nameuser.getData().equals(""))&&(!connectionMap.containsKey(nameuser.getData()))){
                    connectionMap.put(nameuser.getData(),connection);
                    connection.send(new Message(MessageType.NAME_ACCEPTED));
                    break;
                }
            }
            return nameuser.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> x:connectionMap.entrySet()){
                if(!x.getKey().equals(userName)) connection.send(new Message(MessageType.USER_ADDED,x.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            Message textmessage=null;
            while(true) {
                textmessage=connection.receive();
                if (textmessage.getType()==MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT,userName+": "+textmessage.getData()));
                }
                else ConsoleHelper.writeMessage("Error - message is not TEXT Type");
            }
        }

        public void run(){
            ConsoleHelper.writeMessage("Connection has been establishedget: "+ socket.getRemoteSocketAddress());

            String userName=null;
            try (Connection newconnection = new Connection(socket)) {
                userName=serverHandshake(newconnection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(newconnection,userName);
                serverMainLoop(newconnection,userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error occurred while communicating with the remote address: "+socket.getRemoteSocketAddress());
            }
            if(userName!=null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Connection with the remote address is closed");

        }
    }


    public static void main(String[] args) {
        System.out.println("Enter nuber of port for server: ");
        int port=ConsoleHelper.readInt();
        ServerSocket serverSocket= null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is running");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                Handler newhandler = new Handler(serverSocket.accept());
                newhandler.start();
            } catch (IOException e) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
                break;
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Connection x:connectionMap.values()){
            try {
                x.send(message);
            } catch (IOException e) {
                System.out.println("Message couldn't be sent");
            }
        }
    }
}
