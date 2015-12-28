/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.OrganBank;
import Business.Network.Network;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
//import static Business.Organization.Organization.Type.Donor;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author shivam
 */
public class DonorList extends javax.swing.JPanel {
private JPanel userProcessContainer;
    private Enterprise enterprise;
   // private UserAccount account;
   // private Organization organization;
    private Donor donor;
    private EcoSystem system;
    private DonorOrganization donorg;
    /**
     * Creates new form DonorList
     */
    public DonorList(JPanel userProcessContainer,Enterprise enterprise,EcoSystem system) {
        initComponents();
        this.system=system;
        this.userProcessContainer=userProcessContainer;
        this.enterprise=enterprise;
        for (Network network : system.getNetworkList()) {
            
           for (Enterprise enterpris : network.getEnterpriseDirectory().getEnterpriseList())  {             
              if(enterpris.getEnterpriseType().equals(OrganBank))   {
                 // System.out.println("ENTERPRISE " + enterpris);
                  for (Organization organization : enterpris.getOrganizationDirectory().getOrganizationList()) {
                   if(organization instanceof DonorOrganization)    {
                     //  System.out.println("IN DONOR ORG CHECK ");
                        donorg = (DonorOrganization)organization;
                      // System.out.println("NAME OF THE ORG " + organization.getName());
                        
                   }
                  }
                         
              }
           }
           
        }
       PopulateComboBox(); 
    }
public void PopulateComboBox()
 { DonorComboRox.removeAllItems();
    for(Person person : donorg.getPersonDirectory().getPersonList())  {
           
            
             Donor dl = (Donor) person;
         DonorComboRox.addItem(dl);
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

        ViewReport = new javax.swing.JButton();
        DonorComboRox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ViewReport.setText("Sensor");
        ViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewReportActionPerformed(evt);
            }
        });
        add(ViewReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 479, 96, -1));

        DonorComboRox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        DonorComboRox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonorComboRoxActionPerformed(evt);
            }
        });
        add(DonorComboRox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 416, -1, -1));

        jLabel1.setText("Donor Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 420, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/Give thanks Give Life Logo.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewReportActionPerformed
        // TODO add your handling code here:
        donor = (Donor) DonorComboRox.getSelectedItem();
        ViewDonorReport viewDonorReport = new ViewDonorReport(userProcessContainer ,enterprise,donor);
        userProcessContainer.add("ViewDonorReport", viewDonorReport);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_ViewReportActionPerformed

    private void DonorComboRoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonorComboRoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DonorComboRoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox DonorComboRox;
    private javax.swing.JButton ViewReport;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
