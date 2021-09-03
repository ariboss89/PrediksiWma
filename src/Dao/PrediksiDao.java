/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Koneksi.Koneksi;
import Model.tb_prediksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ariboss89
 */
public class PrediksiDao extends tb_prediksi {
    
    Koneksi con;
    Statement st;
    String query;
    ResultSet res;
    
    public String IdRiwayat() {
        String idKriteria = "";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("select *from tb_riwayat ORDER BY id_riwayat DESC");
            if (res.first() == false) {
                idKriteria = ("R001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id_riwayat").substring(3, 4));
                int no = Integer.valueOf(res.getString("id_riwayat").substring(3, 4)) + 1;
                System.out.println(no);
                if (no < 10) {
                    idKriteria = ("R00" + no);
                }
                if (no >10 && no < 100 ) {
                    idKriteria = ("R0" + no);
                }
                if (no >100 && no < 999) {
                    idKriteria = ("R" + no);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }

        return idKriteria;
    };
    
    public void SaveIdRiwayat(String idRiwayat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_riwayat(id_riwayat)values('" + idRiwayat + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
    
    public void Save(String namaBarang, String tahun, String hasil, String galat, String mse, String akurasi, String id_riwayat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_prediksi(nama_barang, tahun, hasil, galat, mse, akurasi, id_riwayat)values('" + namaBarang + "','" + tahun + "','" + hasil + "','" + galat + "','" + mse + "', '"+akurasi+"', '"+id_riwayat+"')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {
        }
    }
    
    public String[][] ShowByNamaAndTahun(String nama, String tahun) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(id_pengadaan) AS Jumlah FROM tb_pengadaan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_pengadaan WHERE nama_barang = '"+nama+"' AND tahun = '"+tahun+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][6];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_pengadaan");
                data[r][1] = res.getString("nama_barang");
                data[r][2] = res.getString("kategori");
                data[r][3] = res.getString("bulan");
                data[r][4] = res.getString("tahun");
                data[r][5] = res.getString("jumlah");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][6];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c <6; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
