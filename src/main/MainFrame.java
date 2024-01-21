/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author HD-PC
 */

import javax.swing.*;
import dao.BiodataDao;
import biodata.BiodataFrame;

public class MainFrame extends JFrame {
    private final BiodataDao biodataDao;
    private final BiodataFrame biodataFrame;

    public MainFrame() {
        this.setTitle("Biodata");
        this.setSize(600, 600);
        
        this.biodataDao = new BiodataDao();
        this.biodataFrame = new BiodataFrame(biodataDao);

        this.biodataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
