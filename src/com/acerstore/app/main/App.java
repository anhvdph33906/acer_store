
package com.acerstore.app.main;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                new MainFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}