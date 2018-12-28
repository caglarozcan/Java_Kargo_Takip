package nesneodev;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nesneodev.DataAccess.Paket;
import nesneodev.DataAccess.PaketDataAccess;

public class YeniPaketEkle extends javax.swing.JFrame {

    public YeniPaketEkle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_seriNo = new javax.swing.JTextField();
        txt_en = new javax.swing.JTextField();
        txt_boy = new javax.swing.JTextField();
        txt_yukseklik = new javax.swing.JTextField();
        btn_paketEkle = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cb_icerik = new javax.swing.JComboBox<>();
        chk_ozelPaket = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yeni Paket Ekle");

        jLabel1.setText("Seri Numarası : ");

        jLabel3.setText("En : ");

        jLabel4.setText("Boy : ");

        jLabel5.setText("Yükseklik : ");

        btn_paketEkle.setText("Yeni Paket Ekle");
        btn_paketEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paketEkleActionPerformed(evt);
            }
        });

        jLabel6.setText("Paket İçeriği : ");

        cb_icerik.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal Paket", "Ticari Paket", "Sigortalı Paket" }));

        chk_ozelPaket.setText("Özel Gönderi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_seriNo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_en, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_boy)
                            .addComponent(txt_yukseklik, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cb_icerik, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(chk_ozelPaket, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_paketEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_seriNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_icerik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_ozelPaket))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_en, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_boy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_yukseklik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_paketEkle)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("lbl_seriNo");
        jLabel3.getAccessibleContext().setAccessibleName("lbl_en");
        jLabel4.getAccessibleContext().setAccessibleName("lbl_boy");
        jLabel5.getAccessibleContext().setAccessibleName("lbl_yukseklik");
        txt_seriNo.getAccessibleContext().setAccessibleName("txt_seriNo");
        txt_en.getAccessibleContext().setAccessibleName("txt_en");
        txt_boy.getAccessibleContext().setAccessibleName("txt_boy");
        txt_yukseklik.getAccessibleContext().setAccessibleName("txt_yukseklik");
        btn_paketEkle.getAccessibleContext().setAccessibleName("btn_paketEkle");

        setSize(new java.awt.Dimension(428, 315));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_paketEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paketEkleActionPerformed
        
        if(txtKontrol(txt_seriNo.getText()) && txtKontrol(txt_en.getText()) && txtKontrol(txt_boy.getText()) && txtKontrol(txt_yukseklik.getText())){
            if(txt_seriNo.getText().length() == 10){
                PaketDataAccess pda = new PaketDataAccess();
                char icerik = 'A', tip = 'B';

                if(cb_icerik.getSelectedItem().toString() == "Normal Paket")
                    icerik = 'N';
                else if(cb_icerik.getSelectedItem().toString() == "Ticari Paket")
                    icerik = 'T';
                else if(cb_icerik.getSelectedItem().toString() == "Sigortalı Paket")
                    icerik = 'S';
                
                double desi = DesiHesapla(Double.parseDouble(txt_en.getText()), Double.parseDouble(txt_boy.getText()), Double.parseDouble(txt_yukseklik.getText()));

                if(desi <= 0.5)
                    tip = 'P';
                else if(desi > 0.5 && desi <= 1.5)
                    tip = 'K';
                else if(desi > 1.5)
                    tip = 'B';

                if(chk_ozelPaket.isSelected())
                    tip = 'S';

                Paket paket = new Paket(txt_seriNo.getText(), tip, icerik, desi);
                
                try {
                    if(pda.PaketEkle(paket)){
                        JOptionPane.showMessageDialog(null, paket.SeriNo + " seri nolu yeni paket sisteme eklendi.", "Bilgi.", JOptionPane.INFORMATION_MESSAGE);
                        txt_seriNo.setText("");
                        txt_en.setText("");
                        txt_boy.setText("");
                        txt_yukseklik.setText("");
                        chk_ozelPaket.setSelected(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Paket eklenemedi.", "Hata!!", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(YeniPaketEkle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Geçersiz seri no girildi.", "Hata!!", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tüm alanlar doldurulmalı.", "Hata!!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_paketEkleActionPerformed

    //textbox alanları boş mu kontrolü.
    private boolean txtKontrol(String str){
        return str != null && !str.trim().isEmpty();
    }
    
    //Girilen paket bilgilerine göre desinin hesaplanması
    public double DesiHesapla(double en, double boy, double yukseklik){
        return (en*boy*yukseklik)/3000;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YeniPaketEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YeniPaketEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YeniPaketEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YeniPaketEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YeniPaketEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_paketEkle;
    private javax.swing.JComboBox<String> cb_icerik;
    private javax.swing.JCheckBox chk_ozelPaket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_boy;
    private javax.swing.JTextField txt_en;
    private javax.swing.JTextField txt_seriNo;
    private javax.swing.JTextField txt_yukseklik;
    // End of variables declaration//GEN-END:variables
}
