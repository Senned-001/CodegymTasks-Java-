package com.codegym.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/* 
Reading and writing to a file: CodeGym

*/
public class Solution {
    public static void main(String[] args) {
        // You can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            User user = new User();
            user.setFirstName("Anton");
            user.setLastName("Chekhov");
            user.setCountry(User.Country.UNITED_STATES);
            user.setBirthDate(new Date());
            user.setMale(true);
            User user2 = new User();
            user2.setFirstName("Jack");
            user2.setLastName("Vorobey");
            user2.setCountry(User.Country.UNITED_STATES);
            user2.setBirthDate(new Date());
            user2.setMale(true);

            CodeGym codeGym = new CodeGym();
            codeGym.users.add(user);
            codeGym.users.add(user2);

            // Initialize users field for the codeGym object here
            codeGym.save(outputStream);
            outputStream.flush();

            CodeGym loadedObject = new CodeGym();
            loadedObject.load(inputStream);
            // Here check that the codeGym object is equal to the loadedObject object
            //if(!codeGym.equals(loadedObject)) throw new Exception();

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class CodeGym {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            // Implement this method
            PrintWriter writer = new PrintWriter(outputStream);
            String isuserhere = this.users != null ? "yes" : "no";
            writer.println(isuserhere);
            if(this.users!=null) {
                writer.println(this.users.size());
                for (int i = 0; i < users.size(); i++) {
                    String is = this.users.get(i).getFirstName()!=null ? "yes" : "no";
                    writer.println(is);
                    if(is.equals("yes"))
                        writer.println(this.users.get(i).getFirstName());

                    is = this.users.get(i).getLastName()!=null ? "yes" : "no";
                    writer.println(is);
                    if(is.equals("yes"))
                        writer.println(this.users.get(i).getLastName());

                    is = this.users.get(i).getBirthDate()!=null ? "yes" : "no";
                    writer.println(is);
                    if(is.equals("yes"))
                        writer.println(this.users.get(i).getBirthDate().getTime());

                    writer.println(this.users.get(i).isMale());

                    is = this.users.get(i).getCountry()!=null ? "yes" : "no";
                    writer.println(is);
                    if(is.equals("yes"))
                        writer.println(this.users.get(i).getCountry());
                }
            }
            writer.flush();
            writer.close();
            //System.out.println("CP done");
        }

        public void load(InputStream inputStream) throws Exception {
            // Implement this method
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if(reader.readLine().equals("yes")) {
                int userscount=Integer.parseInt(reader.readLine());
                for(int i=0;i<userscount;i++) {
                    System.out.println("for began");
                    this.users.add(new User());

                    if(reader.readLine().equals("yes"))
                        this.users.get(this.users.size() - 1).setFirstName(reader.readLine());
                    //System.out.println("fn laoded");
                    if(reader.readLine().equals("yes"))
                        this.users.get(this.users.size() - 1).setLastName(reader.readLine());
                    //System.out.println("ln laoded");
                    if(reader.readLine().equals("yes"))
                        this.users.get(this.users.size() - 1).setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    //System.out.println("d laoded");
                    this.users.get(this.users.size() - 1).setMale(reader.readLine().equalsIgnoreCase("true"));
                    //System.out.println("m laoded");
                    if(reader.readLine().equals("yes"))
                        this.users.get(this.users.size() - 1).setCountry(User.Country.valueOf(reader.readLine()));
                    //System.out.println("c laoded");
                }
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CodeGym codeGym = (CodeGym) o;
            return users != null ? users.equals(codeGym.users) : codeGym.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
