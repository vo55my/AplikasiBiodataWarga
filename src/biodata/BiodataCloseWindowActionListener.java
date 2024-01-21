/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author HD-PC
 */

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import biodata.BiodataFrame;

public class BiodataCloseWindowActionListener implements WindowListener {
    private final BiodataFrame biodataFrame;
	public BiodataCloseWindowActionListener(BiodataFrame biodataFrame) {
            this.biodataFrame = biodataFrame;
	}

    public void windowClosing(WindowEvent e) {
        int confirmation = JOptionPane.showConfirmDialog(this.biodataFrame, "Apakah anda yakin ingin keluar aplikasi?", "Form Biodata", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            this.biodataFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}
}
