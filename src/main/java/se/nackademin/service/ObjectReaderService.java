package se.nackademin.service;

import se.nackademin.model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectReaderService {

    public static List<Member> convertSerFileToList(String filePath) {
        List<Member> members = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (fis.available() != 0) {
                Object o = ois.readObject();
                if (o instanceof Member) {
                    Member m = (Member) o;
                    members.add(m);
                }
            }
            ois.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {
            System.out.println("file finished");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            System.out.println("File not found");
        }
        return members;
    }



}
