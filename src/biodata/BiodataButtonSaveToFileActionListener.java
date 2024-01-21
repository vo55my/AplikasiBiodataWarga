/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author HD-PC
 */

import java.util.List;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import biodata.BiodataFrame;
import biodata.Biodata;

public class BiodataButtonSaveToFileActionListener implements ActionListener {
    private final BiodataFrame biodataFrame;
    private final List<Biodata> biodataList;

    public BiodataButtonSaveToFileActionListener(BiodataFrame biodataFrame, List<Biodata> biodataList) {
        this.biodataFrame = biodataFrame;
        this.biodataList = biodataList;
    }

    public void actionPerformed(ActionEvent e) {
        int confirmation = JOptionPane.showConfirmDialog(this.biodataFrame, "Apakah anda yakin ingin menyimpan data ke file?", "Form Biodata", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Simpan Data ke File");
            fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
            int userSelection = fileChooser.showSaveDialog(this.biodataFrame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
                    for (Biodata biodata : biodataList) {
                        String line = String.join(",", biodata.getNama(), biodata.getNomorHP(), biodata.getJenisKelamin(), biodata.getAlamat());
                        writer.write(line + "\n");
                    }
                    writer.close();
                    JOptionPane.showMessageDialog(this.biodataFrame, "Data berhasil disimpan ke file", "Perhatian", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

