package com.ntdat.hibernateproject;

import com.ntdat.hibernateproject.ui.Login;

import javax.swing.*;

public class Main {
    public static void main(String args[]) {
        JFrame loginFrame = new Login();
        loginFrame.setVisible(true);
        System.out.println("Come back to main");
    }
}
