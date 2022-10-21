package se.nackademin.service;

import se.nackademin.model.Member;

import java.io.*;

public class ObjectWriterService {

    public static void WriteNewMember(ObjectOutputStream oos, Member member) {
        try {
            oos.writeObject(member);
        } catch (IOException ex) {
            System.out.println("Error initializing stream");
        }
    }
}