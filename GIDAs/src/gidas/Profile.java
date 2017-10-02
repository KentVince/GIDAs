/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gidas;

import MyJTable.Jtable_Renderer;
import static gidas.classDb.s;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ITCDD-PROGRAMMING
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
     String ddate = "";
     public static Statement s = null;
    public static ResultSet rs = null;
    
      classMunicipality Municipal = new classMunicipality();
      classBarangay Barangay = new classBarangay();
      classPurok Purok = new classPurok();
       
     String mun,bar,pur,codec;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Calendar cal = Calendar.getInstance();
   
 
    
    
    public Profile() {
        
        
        initComponents();
        Municipal.list_municipality(cbo_municipality);
        currentDate();
        auto_number();
        ot_id.setEnabled(false);
        
      
        
        
        
    }
    
    
     public void currentDate (){
        
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        lbl_date.setText((month+1)+"/"+day+"/"+year);
        
        //Time
      
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        
        lbl_time.setText(hour+":"+(minute)+":"+second);
        
       
    }
     
     
     
     
     
     
    
    
      void auto_number()
    {
        
         classDb.dbconnect();
        try
        {
            
            s = classDb.conn.createStatement();
       rs = s.executeQuery("SELECT MAX(right(code,5)) AS no FROM profiles");
            //rs.last(); // go to the last record to get total records
 
          
             while (rs.next()) {
                 
             if(rs.first()==false) {
                 
                 lbl_code.setText("001");
             }
             
              else
                 {
                       rs.last(); 
                         int auto_id = rs.getInt(1)+1;
                         String no = String.valueOf(auto_id);
                          
                         int nolong = no.length();
                         for(int a=0;a<3-nolong;a++)
                         {
                         no = "00"+no;
                         }
                              
                         lbl_code.setText(""+no);
                  }
       
             }
             
      
        }
        catch(Exception e)
        {
            
             JOptionPane.showMessageDialog(null,e);
        }
        
        
    }
     
     
     
     
    
    
    void SaveData() {
        classDb.dbconnect();

      //   jLabel1.setText(dateFormat.format(cal));
        codec = lbl_mun.getText() + lbl_bar.getText() + lbl_purok.getText() + lbl_code.getText();
        
       int check;
       
         if(cho_ginikanan.isSelected()==true) // if check box is checked
       {
            check=1;
            
            
       }
         
           if(cho_pagumangkon.isSelected()==true)
       {
           
             check=1;
       }

          if(cho_igsoon.isSelected()==true)
       {
            
           check=1;
       }
         
         
 else   {   
           check=0;
        }
        
        
        
        
      
      
        try {

            s = classDb.conn.createStatement();
            s.executeUpdate("Insert INTO profiles(code,last_name,first_name,middle_name,age,sex,civil_status,occupation,employment_status,spouse_name,spouse_age,spouse_occupation,children_male,children_female,address,ginikanan,igsoon,pag_umangkon,created_at,purok_id,users_id) "
                    + "values('" + codec + "','" + txt_family_head_lastname.getText() + "', '" + txt_family_head_firstname.getText() + "','" + txt_family_head_middlename.getText() + "','" + txt_age.getText() + "','" + cbo_sex.getSelectedItem() + "','" + cbo_status.getSelectedItem() + "','" + txt_occupation.getText() + "','"
                    + cbo_status_of_employment.getSelectedItem() + "','" + txt_spouse_name.getText() + "','" + txt_spouse_age.getText() + "','" + txt_spouse_occupation.getText() + "','" + txt_no_of_children_male.getText() + "','" + txt_no_of_children_female.getText() + "','" + check + "','" + check + "','" + check + "','" + lbl_date.getText() + "',"
                    + "'" + lbl_purok.getText() + "', "
                    + "'" + lbl_user.getText() + "')"); 
            JOptionPane.showMessageDialog(null, "Save Record, Done.....", "Saving Record Notification", JOptionPane.INFORMATION_MESSAGE);

            s.close();
            classDb.conn.close();

        } catch (SQLException ex) {
            //Logger.getLogger(DataEntry.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Error report", JOptionPane.OK_OPTION);

        }
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_family_head_middlename = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbo_sex = new javax.swing.JComboBox<>();
        txt_age = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbo_status = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_occupation = new javax.swing.JTextField();
        txt_spouse_name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_spouse_age = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_no_of_children_female = new javax.swing.JTextField();
        txt_no_of_children_male = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_spouse_occupation = new javax.swing.JTextField();
        cbo_status_of_employment = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        txt_family_head_firstname = new javax.swing.JTextField();
        txt_family_head_lastname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_purok = new javax.swing.JLabel();
        lbl_code = new javax.swing.JLabel();
        lbl_bar = new javax.swing.JLabel();
        lbl_mun = new javax.swing.JLabel();
        ot_id = new javax.swing.JTextField();
        cho_pagumangkon = new javax.swing.JCheckBox();
        cho_ginikanan = new javax.swing.JCheckBox();
        cho_igsoon = new javax.swing.JCheckBox();
        cbo_purok = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        cbo_municipality = new javax.swing.JComboBox<>();
        cbo_barangay = new javax.swing.JComboBox<>();
        lbl_user = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        lbl_date = new javax.swing.JMenu();
        lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Spouse Name (Pangalan sa asawa) :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));
        jPanel1.add(txt_family_head_middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("(middlename)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sex :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Status :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        cbo_sex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jPanel1.add(cbo_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 290, 30));
        jPanel1.add(txt_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 290, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Other dependents (Uban pang gibuhi) :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, -1));

        cbo_status.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "Singel" }));
        jPanel1.add(cbo_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 290, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Status of Employment :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Age (edad) :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));
        jPanel1.add(txt_occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 290, 30));
        jPanel1.add(txt_spouse_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("babaye");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Occupation (Trabaho) :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));
        jPanel1.add(txt_spouse_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 190, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Occupation (Trabaho) :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Age (edad) :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, -1, -1));
        jPanel1.add(txt_no_of_children_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 80, 30));
        jPanel1.add(txt_no_of_children_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 70, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("lalaki/");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("No. of Children (Pila kabuok ang anak) :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));
        jPanel1.add(txt_spouse_occupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 190, 30));

        cbo_status_of_employment.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_status_of_employment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Wage", "Self-employed" }));
        jPanel1.add(cbo_status_of_employment, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 290, 30));

        btn_save.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_save.setText("Next");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 90, 30));
        jPanel1.add(txt_family_head_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 110, 30));
        jPanel1.add(txt_family_head_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Name of Family Head :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel17.setText("(Purok)");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 520, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel18.setText("(firstname)");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel1.setText("Code # :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 30));

        lbl_purok.setText("Purok");
        jPanel1.add(lbl_purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 50, 30));

        lbl_code.setText("code");
        jPanel1.add(lbl_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 50, 30));

        lbl_bar.setText("Barangay");
        jPanel1.add(lbl_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        lbl_mun.setText("Municipality");
        jPanel1.add(lbl_mun, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 30, 30));
        jPanel1.add(ot_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 170, 30));

        cho_pagumangkon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cho_pagumangkon.setText("Pag-umangkon");
        cho_pagumangkon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cho_pagumangkonActionPerformed(evt);
            }
        });
        jPanel1.add(cho_pagumangkon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, -1, -1));

        cho_ginikanan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cho_ginikanan.setText("Ginikanan");
        cho_ginikanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cho_ginikananActionPerformed(evt);
            }
        });
        jPanel1.add(cho_ginikanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 600, -1, -1));

        cho_igsoon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cho_igsoon.setText("Igsoon");
        cho_igsoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cho_igsoonActionPerformed(evt);
            }
        });
        jPanel1.add(cho_igsoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 600, -1, -1));

        cbo_purok.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_purok.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_purokItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 130, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Address :");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        cbo_municipality.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_municipality.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_municipalityItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_municipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 130, 30));

        cbo_barangay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbo_barangay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_barangayItemStateChanged(evt);
            }
        });
        jPanel1.add(cbo_barangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 130, 30));

        lbl_user.setText("1");
        jPanel1.add(lbl_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel20.setText("(lastname)");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel21.setText("(Municipality)");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel22.setText("(Barangay)");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 690));

        lbl_date.setText("Date");
        jMenuBar1.add(lbl_date);

        lbl_time.setText("Time");
        jMenuBar1.add(lbl_time);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        
        
         SaveData();
        
        
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void cbo_municipalityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_municipalityItemStateChanged
        // TODO add your handling code here:
        
         classMunicipalityGetSet d_vo = (classMunicipalityGetSet)this.cbo_municipality.getSelectedItem();
        int id_de = d_vo.getidMunicipal();
        String n = d_vo.getdesMunicipal();
        lbl_mun.setText(id_de+" ");
        
    
        Barangay.list_barangay(cbo_barangay, id_de);
        
        
        
    }//GEN-LAST:event_cbo_municipalityItemStateChanged

    private void cbo_barangayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_barangayItemStateChanged
        // TODO add your handling code here:
        
         classBarangayGetSet p_vo = (classBarangayGetSet)this.cbo_barangay.getSelectedItem();
        int id_di = p_vo.getIdBarangay();
        String n = p_vo.getNameBarangay();
        lbl_bar.setText(" - "+id_di);
       
        Purok.list_purok(cbo_purok, id_di);
       
     
       
        
    }//GEN-LAST:event_cbo_barangayItemStateChanged

    private void cbo_purokItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_purokItemStateChanged
        // TODO add your handling code here:
        
         classPurokGetSet p_vo = (classPurokGetSet)this.cbo_purok.getSelectedItem();
        int id_di = p_vo.getIdPurok();
        String n = p_vo.getPurok();
        
      lbl_purok.setText(" - "+id_di+" - ");
     
       
        
    }//GEN-LAST:event_cbo_purokItemStateChanged

    private void cho_ginikananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cho_ginikananActionPerformed
        // TODO add your handling code here:
        
       
        
        
        
        
    }//GEN-LAST:event_cho_ginikananActionPerformed

    private void cho_igsoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cho_igsoonActionPerformed
        // TODO add your handling code here:
        
       

        
    }//GEN-LAST:event_cho_igsoonActionPerformed

    private void cho_pagumangkonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cho_pagumangkonActionPerformed
        // TODO add your handling code here:
        
       
         
         
        
    }//GEN-LAST:event_cho_pagumangkonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cbo_barangay;
    private javax.swing.JComboBox<String> cbo_municipality;
    private javax.swing.JComboBox<String> cbo_purok;
    private javax.swing.JComboBox<String> cbo_sex;
    private javax.swing.JComboBox<String> cbo_status;
    private javax.swing.JComboBox<String> cbo_status_of_employment;
    private javax.swing.JCheckBox cho_ginikanan;
    private javax.swing.JCheckBox cho_igsoon;
    private javax.swing.JCheckBox cho_pagumangkon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_bar;
    private javax.swing.JLabel lbl_code;
    private javax.swing.JMenu lbl_date;
    private javax.swing.JLabel lbl_mun;
    private javax.swing.JLabel lbl_purok;
    private javax.swing.JMenu lbl_time;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JTextField ot_id;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_family_head_firstname;
    private javax.swing.JTextField txt_family_head_lastname;
    private javax.swing.JTextField txt_family_head_middlename;
    private javax.swing.JTextField txt_no_of_children_female;
    private javax.swing.JTextField txt_no_of_children_male;
    private javax.swing.JTextField txt_occupation;
    private javax.swing.JTextField txt_spouse_age;
    private javax.swing.JTextField txt_spouse_name;
    private javax.swing.JTextField txt_spouse_occupation;
    // End of variables declaration//GEN-END:variables
}



