/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Koneksi.Koneksi;
import java.io.File;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ariboss89
 */
public class ReportDao {
    private Koneksi con;

    public void CetakHasil(String namabarang, String tahun, String aktual, String hasil, String galat, String mse, String akurasi) {
        
        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/Report/LaporanHasilPrediksi.jasper");
            parameter.put("namabarang", namabarang);
            parameter.put("tahun", tahun);
            parameter.put("aktual", aktual);
            parameter.put("hasil", hasil);
            parameter.put("galat", galat);
            parameter.put("mse", mse);
            parameter.put("tingkatakurasi", akurasi );
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void CetakRiwayat(String idRiwayat){
        con = new Koneksi();

        try {
            HashMap parameter = new HashMap();
            File file = new File("src/Report/LaporanRiwayat.jasper");
            parameter.put("parameter1", idRiwayat);
            JasperReport jp = (JasperReport) JRLoader.loadObject(file);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jp, parameter, con.connect());
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
