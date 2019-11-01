package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.Connection;
import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;
import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected=false;

    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" has joined the chat");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName+" has left the chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected=clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while(true){
                Message newmes=connection.receive();
                if(newmes.getType()==MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME,getUserName()));
                }
                else if(newmes.getType()==MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message newmes = connection.receive();
                if (newmes.getType() == MessageType.TEXT) {
                    processIncomingMessage(newmes.getData());
                } else if (newmes.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(newmes.getData());
                } else if (newmes.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(newmes.getData());
                } else throw new IOException("Unexpected MessageType");
            }
        }

        @Override
        public void run(){
            try {
                connection= new Connection(new Socket(getServerAddress(),getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    protected String getServerAddress(){
        System.out.println("Enter server address: ");
        return ConsoleHelper.readString();

    }

    protected int getServerPort(){
        System.out.println("Enter server port: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        System.out.println("Enter your name: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            clientConnected=false;
        }
    }

    public void run(){
        SocketThread newsocket = getSocketThread();
        newsocket.setDaemon(true);
        newsocket.start();
        try {
            synchronized (this){
                wait();
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (shouldSendTextFromConsole()) {
            if (clientConnected) {
                ConsoleHelper.writeMessage("Connection established. To exit, enter 'exit'.");
            } else ConsoleHelper.writeMessage("An error occurred while working with the client.");
        }

        while(clientConnected) {
            String a = ConsoleHelper.readString();
            if (a.equalsIgnoreCase("exit")) {
                break;
            }
            if (shouldSendTextFromConsole()) sendTextMessage(a);

        }


    }

    public static void main(String[] args){
        Client client=new Client();
        client.run();
    }

}

