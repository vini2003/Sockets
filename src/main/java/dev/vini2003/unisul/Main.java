package dev.vini2003.unisul;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try {
            PrintWriter out;
            BufferedReader in;

            try (var sock = new Socket(JOptionPane.showInputDialog("Insert a URL"), 80)) {

                out = new PrintWriter(sock.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            }



            var line = "";

            out.println("GET / HTTP/1.0\n");

            while ((line = in.readLine()) != null) {
                System.out.println("echo: " + line);
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}