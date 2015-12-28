/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Donor.Donor;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class Patientlist extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private Enterprise enterprise;
   // private UserAccount account;
    private Organization organization;
    private Patient patient;
    /**
     * 
     */
    public Patientlist(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        //this.account = account;
         this.enterprise = enterprise;
         for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            if(org instanceof PatientOrganization)
                organization = (PatientOrganization)org;
        PopulateComboBox();
    }
public void PopulateComboBox()
 { 
     PtnComboBox.removeAllItems();
     for(Person patient : organization.getPersonDirectory().getPersonList())  {
           
            
             Patient pt = (Patient) patient;
         PtnComboBox.addItem(pt);
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

        jLabel1 = new javax.swing.JLabel();
        PtnComboBox = new javax.swing.JComboBox();
        MedicineBtn = new javax.swing.JButton();
        ViewVitalSignbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Patient Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, -1, -1));

        PtnComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PtnComboBoxActionPerformed(evt);
            }
        });
        add(PtnComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 129, -1));

        MedicineBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/images.png"))); // NOI18N
        MedicineBtn.setText("View Medicine");
        MedicineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MedicineBtnActionPerformed(evt);
            }
        });
        add(MedicineBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 122, 112));

        ViewVitalSignbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/NurseRole/tee03_playing_games.jpg"))); // NOI18N
        ViewVitalSignbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewVitalSignbtnActionPerformed(evt);
            }
        });
        add(ViewVitalSignbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/u17412225.jpg"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 450));
    }// </editor-fold>//GEN-END:initComponents

    private void PtnComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PtnComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PtnComboBoxActionPerformed

    private void MedicineBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicineBtnActionPerformed
        // TODO add your handling code here:
        patient = (Patient) PtnComboBox.getSelectedItem();
        if(patient!=null){
        ViewOrderHistory viewOrderHistory = new ViewOrderHistory(userProcessContainer ,enterprise,patient);
        userProcessContainer.add("ViewOrderHistory", viewOrderHistory);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(this, "Please list is Empty Please add a pateint","Information ",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_MedicineBtnActionPerformed

    private void ViewVitalSignbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewVitalSignbtnActionPerformed
        // TODO add your handling code here:
        patient = (Patient) PtnComboBox.getSelectedItem();
        if(patient!=null){
        ViewPatientReport viewPatientReport = new ViewPatientReport(userProcessContainer ,enterprise,patient);
        userProcessContainer.add("ViewPatientReport", viewPatientReport);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(this, "Please list is Empty Please add a pateint","Information ",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ViewVitalSignbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MedicineBtn;
    private javax.swing.JComboBox PtnComboBox;
    private javax.swing.JButton ViewVitalSignbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
