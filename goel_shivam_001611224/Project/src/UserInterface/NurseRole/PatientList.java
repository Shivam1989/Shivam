/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NurseRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class PatientList extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private Enterprise enterprise;
   private UserAccount account;
    private Organization organization;
    private Patient patient;
    /**
     * Creates new form PatientList
     */
    public PatientList(JPanel userProcessContainer,Enterprise enterprise,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
         this.enterprise = enterprise;
         for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            if(org instanceof PatientOrganization)
                organization = (PatientOrganization)org;
        PopulateComboBox();
    }
public void PopulateComboBox()
 { PtnComboBox.removeAllItems();
     for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
         patient=(Patient) ((LabTestWorkRequest) request).getPatient();
         PtnComboBox.addItem(patient);
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

        PtnComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Nextbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PtnComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PtnComboBoxActionPerformed(evt);
            }
        });
        add(PtnComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 129, -1));

        jLabel1.setText("Patient Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, -1, -1));

        Nextbtn.setText("Sensor");
        Nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextbtnActionPerformed(evt);
            }
        });
        add(Nextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, 99, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/NurseRole/20131008064014-measurements.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void PtnComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PtnComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PtnComboBoxActionPerformed

    private void NextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextbtnActionPerformed
        // TODO add your handling code here:
        patient = (Patient) PtnComboBox.getSelectedItem();
        if(patient!=null){
        PatientSensorVitalSign patientSensorVitalSign = new PatientSensorVitalSign(userProcessContainer ,enterprise,patient,account);
        userProcessContainer.add("PatientSensorVitalSign", patientSensorVitalSign);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);}
        else{
            JOptionPane.showMessageDialog(this, "Patient list is Empty Please add a pateint","Information ",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_NextbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nextbtn;
    private javax.swing.JComboBox PtnComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}