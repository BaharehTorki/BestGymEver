package se.nackademin;

import se.nackademin.utils.Strings;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog(null, "Input name/personal number:");
        if (Strings.isNotNullAndEmpty(input))
            System.out.println("input " + input);
        System.out.println("empty");

    }

}
