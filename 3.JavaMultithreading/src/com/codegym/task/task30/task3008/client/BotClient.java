package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BotClient extends Client{

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hello, there. I'm a bot. I understand the following commands: date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);
            if (message.contains(":")) {
                String name = message.split(": ")[0];
                String text = message.split(": ")[1];
                Calendar data = new GregorianCalendar();
                SimpleDateFormat fr;
                switch (text) {

                    case "date": {
                        fr = new SimpleDateFormat("d.MM.YYYY");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "day": {
                        fr = new SimpleDateFormat("d");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "month": {
                        fr = new SimpleDateFormat("MMMM");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "year": {
                        fr = new SimpleDateFormat("YYYY");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "time": {
                        fr = new SimpleDateFormat("H:mm:ss");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "hour": {
                        fr = new SimpleDateFormat("H");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "minutes": {
                        fr = new SimpleDateFormat("m");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                    case "seconds": {
                        fr = new SimpleDateFormat("s");
                        sendTextMessage("Information for " + name + ": " + fr.format(data.getTime()));
                        break;
                    }
                }

            }

        }
    }

    @Override
    protected String getUserName() {
        int x=(int)(Math.random()*100);
        return String.format("date_bot_%d",x);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
        BotClient botClient=new BotClient();
        botClient.run();
    }
}
