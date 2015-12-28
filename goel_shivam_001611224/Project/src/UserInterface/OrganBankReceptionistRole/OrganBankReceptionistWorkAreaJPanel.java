/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.OrganBankReceptionistRole;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class OrganBankReceptionistWorkAreaJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
   
    /**
     * Creates new form ReceptionistWorkAreaJPanel
     */
    public OrganBankReceptionistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,Organization organization, Enterprise enterprise) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
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
        AddDonorBtn = new javax.swing.JButton();
        RequestTestBtn = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/OrganBankReceptionistRole/500_F_71211595_81Cr1ntQ2PkpOgHpRgRqkMHk2qaEnojl.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 500, 260));

        AddDonorBtn.setText("Add Donor");
        AddDonorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDonorBtnActionPerformed(evt);
            }
        });
        add(AddDonorBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 368, 151, -1));

        RequestTestBtn.setText("Request Lab Test");
        RequestTestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestTestBtnActionPerformed(evt);
            }
        });
        add(RequestTestBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 445, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void AddDonorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDonorBtnActionPerformed
        // TODO add your handling code here:
        OrganRegistrationForm organRegistrationForm = new OrganRegistrationForm(userProcessContainer, enterprise);
        
        userProcessContainer.add("OrganRegistrationForm", organRegistrationForm);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_AddDonorBtnActionPerformed

    private void RequestTestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestTestBtnActionPerformed
        // TODO add your handling code here:
         OrganBankReceptionistQueueJPanel rqjp = new OrganBankReceptionistQueueJPanel(userProcessContainer,userAccount,organization,enterprise);
        userProcessContainer.add("ReceptionistQueueJPanel", rqjp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_RequestTestBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDonorBtn;
    private javax.swing.JButton RequestTestBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}