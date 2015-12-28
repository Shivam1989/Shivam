/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.OrganBankLabAssisstantRole;

import Business.Donor.Donor;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class DonorList extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private Enterprise enterprise;
   // private UserAccount account;
    private Organization organization;
    private Donor donor;
    /**
     * Creates new form DonorList
     */
    public DonorList(JPanel userProcessContainer,Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        //this.account = account;
         this.enterprise = enterprise;
         for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
            if(org instanceof DonorOrganization)
                organization = (DonorOrganization)org;
        PopulateComboBox();
    }
    public void PopulateComboBox()
 { DonorComboBox.removeAllItems();
     for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
         donor=(Donor) ((LabTestWorkRequest) request).getDonor();
         DonorComboBox.addItem(donor);
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
        DonorComboBox = new javax.swing.JComboBox();
        Nextbtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Donor Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 547, -1, -1));

        DonorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonorComboBoxActionPerformed(evt);
            }
        });
        add(DonorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 543, 129, -1));

        Nextbtn.setText("Sensor");
        Nextbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextbtnActionPerformed(evt);
            }
        });
        add(Nextbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 582, 99, -1));

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 582, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/NurseRole/20131008064014-measurements.gif"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void DonorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonorComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DonorComboBoxActionPerformed

    private void NextbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextbtnActionPerformed
        // TODO add your handling code here:
        donor = (Donor) DonorComboBox.getSelectedItem();
        if(donor!=null){
        DonorSensorVitalSign donorSensorVitalSign = new DonorSensorVitalSign(userProcessContainer ,enterprise,donor);
        userProcessContainer.add("PatientSensorVitalSign", donorSensorVitalSign);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);}
        else{
            JOptionPane.showMessageDialog(this, "List is Empty Please add a pateint","Information ",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_NextbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DonorComboBox;
    private javax.swing.JButton Nextbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
