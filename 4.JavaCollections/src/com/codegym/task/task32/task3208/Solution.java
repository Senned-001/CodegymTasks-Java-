package com.codegym.task.task32.task3208;



import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI (part 2)

*/
public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //write your code here
            try {
                Remote stub = null;
                Remote stub2 = null;
                final String UNIC_BINDING_NAME = "animal.dog";
                final String UNIC_BINDING_NAME2 = "animal.cat";
                registry = LocateRegistry.createRegistry(2099);
                final Animal service = new Dog("Dog");
                final Animal service2 = new Cat("Cat");
                stub = UnicastRemoteObject.exportObject(service, 0);
                stub2 = UnicastRemoteObject.exportObject(service2, 0);
                registry.bind(UNIC_BINDING_NAME, stub);
                registry.bind(UNIC_BINDING_NAME2, stub2);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}