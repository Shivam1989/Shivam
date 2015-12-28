/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.NurseRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class NurseWorkAreaJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    /**
     * Creates new form NurseWorkAreaJPanel
     */
    public NurseWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization,Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.organization = organization;
        this.enterprise=enterprise;
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
        ProcessRequest = new javax.swing.JButton();
        SensorVitalSign = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/NurseRole/Nurses-480x280.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, -1, -1));

        ProcessRequest.setText("Process Request");
        ProcessRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessRequestActionPerformed(evt);
            }
        });
        add(ProcessRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 375, 179, -1));

        SensorVitalSign.setText("Add Current VitalSign");
        SensorVitalSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SensorVitalSignActionPerformed(evt);
            }
        });
        add(SensorVitalSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 465, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ProcessRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessRequestActionPerformed
        // TODO add your handling code here:
        NurseWorkQueueJPanel nurseWorkQueueJPanel = new NurseWorkQueueJPanel(userProcessContainer,userAccount, organization,enterprise);
        userProcessContainer.add("NurseWorkQueueJPanel", nurseWorkQueueJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ProcessRequestActionPerformed

    private void SensorVitalSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SensorVitalSignActionPerformed
        // TODO add your handling code here:
        PatientList patientList = new PatientList(userProcessContainer ,enterprise,userAccount);
        userProcessContainer.add("PatientList", patientList);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_SensorVitalSignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ProcessRequest;
    private javax.swing.JButton SensorVitalSign;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}