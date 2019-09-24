package com.codegym.task.task20.task2022;

import java.io.*;

/* 
Overriding serialization in a thread

*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    public String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName=fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution s=new Solution(args[0]);
        s.writeObject("STRING1");

        FileOutputStream fs=new FileOutputStream(args[1]);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(s);
        os.close();
        fs.close();

        FileInputStream fis= new FileInputStream(args[1]);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution l= (Solution) ois.readObject();
        ois.close();
        fis.close();

        l.writeObject("STRING2");
        s.close();
        l.close();

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String line1 = reader.readLine();
        line1=line1+reader.readLine();
        reader.close();
        System.out.println(line1);




    }
}
