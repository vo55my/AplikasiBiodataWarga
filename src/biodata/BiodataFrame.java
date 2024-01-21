/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author HD-PC
 */

import javax.swing.*;
import java.util.*;
import dao.BiodataDao;
import biodata.BiodataButtonHapusActionListener;
import biodata.BiodataButtonSimpanActionListener;
import biodata.BiodataButtonUbahActionListener;
import biodata.BiodataButtonSaveToFileActionListener;
import biodata.BiodataCloseWindowActionListener;
import biodata.BiodataButtonUpdateActionListener;

public class BiodataFrame extends JFrame {
    private List<Biodata> biodataList;
    private final JTextField textFieldNama;
    private final JTextField textFieldHP;
    private final JRadioButton jenisLaki, jenisPerempuan;
    private final JTextArea txtOutput;
    private final BiodataTableModel tableModel;
    private final JTable table;
    private final JButton buttonUpdate;
    private final BiodataDao biodataDao;

    public BiodataFrame(BiodataDao biodataDao) {
        this.biodataDao = biodataDao;
        this.biodataList = this.biodataDao.findAll();
        
        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelHP = new JLabel("Nomor HP: ");
        labelHP.setBounds(15, 100, 350, 10);

        textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 120, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        jenisLaki = new JRadioButton("Laki-Laki", true);
        jenisLaki.setBounds(15, 170, 350, 30);

        jenisPerempuan = new JRadioButton("Perempuan");
        jenisPerempuan.setBounds(15, 190, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jenisLaki);
        bg.add(jenisPerempuan);

        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 220, 350, 10);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 240, 350, 100);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 350, 80, 40);

        JButton buttonUbah = new JButton("Ubah");
        buttonUbah.setBounds(100, 350, 80, 40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(185, 350, 80, 40);

        buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(270, 350, 80, 40);
        
        JButton buttonFile = new JButton("Simpan ke File");
        buttonFile.setBounds(355, 350, 120, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 400, 550, 130);

        tableModel = new BiodataTableModel(biodataList);
        table.setModel(tableModel);

        BiodataButtonSimpanActionListener simpanListener = new BiodataButtonSimpanActionListener(this, biodataDao);
        button.addActionListener(simpanListener);

        BiodataButtonUbahActionListener ubahListener = new BiodataButtonUbahActionListener(this, biodataDao);
        buttonUbah.addActionListener(ubahListener);

        BiodataButtonHapusActionListener hapusListener = new BiodataButtonHapusActionListener(this, biodataDao);
        buttonHapus.addActionListener(hapusListener);

        BiodataButtonSaveToFileActionListener saveToFileListener = new BiodataButtonSaveToFileActionListener(this, biodataList);
        buttonFile.addActionListener(saveToFileListener);

        BiodataCloseWindowActionListener closeWindowListener = new BiodataCloseWindowActionListener(this);
        this.addWindowListener(closeWindowListener);

        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelHP);
        this.add(textFieldHP);
        this.add(labelRadio);
        this.add(jenisLaki);
        this.add(jenisPerempuan);
        this.add(labelAlamat);
        this.add(txtOutput);
        this.add(button);
        this.add(buttonUbah);
        this.add(buttonHapus);
        this.add(buttonFile);
        this.add(scrollableTable);
        this.add(buttonUpdate);

        this.setSize(600, 600);
        this.setLayout(null);
    }

    public String getNama() {
        return textFieldNama.getText();
    }

    public JTextField getNamaTextField() {
        return textFieldNama;
    }

    public String getNomorHP() {
        return textFieldHP.getText();
    }

    public JTextField getNomorHPTextField() {
        return textFieldHP;
    }

    public JRadioButton getJenisLaki() {
        return jenisLaki;
    }

    public JRadioButton getJenisPerempuan() {
        return jenisPerempuan;
    }

    public String getAlamat() {
        return txtOutput.getText();
    }

    public JTextArea getAlamatTextField() {
        return txtOutput;
    }

    public BiodataTableModel getTableModel() {
        return this.tableModel;
    }

    public JTable getTable() {
        return this.table;
    }

    public JButton getButtonSimpanUbah() {
        return this.buttonUpdate;
    }

    public void addBiodata(Biodata biodata) {
        tableModel.add(biodata);
        textFieldNama.setText("");
        textFieldHP.setText("");
        txtOutput.setText("");
    }

    public void updateBiodata(Biodata biodata) {
        tableModel.update(biodata);
        textFieldNama.setText("");
        textFieldHP.setText("");
        txtOutput.setText("");
    }

    public void deleteBiodata(Biodata biodata) {
        tableModel.delete(biodata);
    }

    public void showAlertAllEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama, telepon dan alamat belum terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
    }

    public void showAlertNameEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama belum terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
    }

    public void showAlertTelephoneEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nomor HP belum terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
    }

    public void showAlertAddressEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Alamat belum terisi", "Perhatian", JOptionPane.WARNING_MESSAGE);
    }

    public void showAlertSuccess(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showAlertFailed(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian", JOptionPane.ERROR_MESSAGE);
    }

    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(BiodataFrame.this, "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }
}
