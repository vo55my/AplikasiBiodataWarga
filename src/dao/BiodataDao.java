/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author HD-PC
 */

import biodata.Biodata;
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO biodata (id, nama, nomor_hp, jenis_kelamin, alamat) VALUES (?, ?, ?, ?, ?)")) {
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getNomorHP());
            statement.setString(4, biodata.getJenisKelamin());
            statement.setString(5, biodata.getAlamat());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE biodata SET nama = ?, nomor_hp = ?, jenis_kelamin = ?, alamat = ? WHERE id = ?")) {
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getNomorHP());
            statement.setString(3, biodata.getJenisKelamin());
            statement.setString(4, biodata.getAlamat());
            statement.setString(5, biodata.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM biodata WHERE id = ?")) {
            statement.setString(1, biodata.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Biodata> findAll() {
        List<Biodata> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM biodata")) {
                while (resultSet.next()) {
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNomorHP(resultSet.getString("nomor_hp"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));

                    list.add(biodata);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Biodata select(String column, String value) {
        Biodata biodata = new Biodata();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM biodata WHERE " + column + " = '" + value + "'");) {
                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNomorHP(resultSet.getString("nomor_hp"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    }
}
