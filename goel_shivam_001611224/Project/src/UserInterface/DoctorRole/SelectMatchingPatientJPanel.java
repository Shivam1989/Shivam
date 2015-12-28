   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.Donor.Donor;
import Business.DonorSensor.VitalSign;
import Business.DonorSensor.VitalSignDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import static Business.Enterprise.Enterprise.EnterpriseType.OrganBank;
import Business.Network.Network;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.Organization.PatientOrganization;
import Business.Patient.Patient;
import Business.PatientSensor.Test;
import Business.PatientSensor.TestDirectory;
import Business.Person.Person;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivam
 */
public class SelectMatchingPatientJPanel extends javax.swing.JPanel {
private JPanel userProcessContainer;
private Organization organization;
private DonorOrganization donorg;
 private Enterprise enterprise;
 private Patient patient;
private EcoSystem system;
private Donor d;
private ArrayList<Donor> matchingDonor;
double lat;
double longt;
double Latitude ;
double  Longitude;
private VitalSignDirectory vitalSignHistory;
private TestDirectory testdir;
private Test test;
private VitalSign vitalsign;
String type;
String PtnBloodGroup;

    /**
     * Creates new form SelectMachingPatient
     */
    public SelectMatchingPatientJPanel(JPanel userProcessContainer,Enterprise enterprise,EcoSystem system,Patient p) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
      // this.organization=organization;
        this.enterprise = enterprise;
        this.system=system;
        this.patient=p;
        testdir=patient.getTestDir();
        matchingDonor = new ArrayList<>();
        
      lat=enterprise.getLatitude();
      longt=enterprise.getLongitude();
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof PatientOrganization){
                organization = (PatientOrganization)org;
        }
        }
         if(!(testdir.getTestdir().isEmpty())) {
        for(Test test1 : testdir.getTestdir()){
           if(test1 != null)    {
        //ctest1=testdir.addTest();
        type = test1.getOrganType();
        PtnBloodGroup=test1.getBloodType();
        //System.out.println(type);
           }
            }
    }
        
        
        for (Network network : system.getNetworkList()) {
            
           for (Enterprise enterpris : network.getEnterpriseDirectory().getEnterpriseList())  {             
              if(enterpris.getEnterpriseType().equals(OrganBank))   {
                 // System.out.println("ENTERPRISE " + enterpris);
                  for (Organization organization : enterpris.getOrganizationDirectory().getOrganizationList()) {
                   if(organization instanceof DonorOrganization)    {
                     //  System.out.println("IN DONOR ORG CHECK ");
                        donorg = (DonorOrganization)organization;
                       System.out.println("NAME OF THE ORG " + organization.getName());
                        //break;
                   }
                  }
                         //break;
              }
           }
           //break;
        }
        
        
                  //System.out.println("DonorOrga " + donorg + "size " + donorg.getPersonDirectory().getPersonList().size());
                  
        for(Person person : donorg.getPersonDirectory().getPersonList())  {
           
            
             Donor dl = (Donor) person;
           //  System.out.println("Donor Details" + dl.getVitalSignDir().getVitalSignDir());
           VitalSignDirectory  vitalSignHis=dl.getVitalSignDir();
           if(!vitalSignHis.getVitalSignDir().isEmpty()) 
           {
               for(VitalSign vital : vitalSignHis.getVitalSignDir())
               {if(vital != null)    {
            // vitalsign=vitalSignHistory.addTest();
               if(type.equals(vital.getOrganType())) {
                  //  System.out.println(vital.getOrganType());
                    matchingDonor.add(dl);
                    
                    
                }
               }
           }
            //System.out.println("hello"+ dl.getName());
             //System.out.println("donor in matching"+ dl.getVitalSignDir().getVitalSignDir());
            //System.out.println(type);
            //System.out.println(vitalsig.getOrganType());
            
           }     
        }
        
        
        populateRequestTable();
        populateDonorTable();         
    }
    public void populateDonorTable(){
    
    DefaultTableModel model = (DefaultTableModel) DonorjTable.getModel();
        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
           for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
               
              if(enterprise.getEnterpriseType().equals(OrganBank)){
                  
                 for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if(organization instanceof DonorOrganization) {
                       
                        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
                           
                        Object[] row = new Object[5];
                       String result = ((LabTestWorkRequest) request).getTestResult();
                        if(result.equals("Complete")){
                        for (Donor d1 :matchingDonor){
                            
                              row[0] = d1;
                              row[1] =result == null ? "Waiting" : result;
                             VitalSignDirectory vitalSigndir=d1.getVitalSignDir();
                              if(!vitalSigndir.getVitalSignDir().isEmpty()) 
           {
               for(VitalSign vs : vitalSigndir.getVitalSignDir())
               {
                            // VitalSign vs=vitalSigndir.addTest();
                              row[2] =vs.getOrganType(); //d.getVitalSign().getOrganType();
                              Latitude=enterprise.getLatitude();
                             Longitude=enterprise.getLongitude();
       //row[1] = ;
                             
       Double distance= distance(Latitude,Longitude, lat, longt,"K");
                             
                              //row[3]=distance;
                              row[3]= network;
                           model.addRow(row);
       // }
                        }
                        }
                   }  
                 }
             }
                 }
           } 
        }
    }}}
    
   public void matchingAlgorithm()
   {
       int genA;
       int genB;
       int genC;
       int genDB;
       int genDQ;
       
               
   int selectedRow = DonorjTable.getSelectedRow();
   //int selectedRow1=PatientJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }
        Donor don = (Donor)DonorjTable.getValueAt(selectedRow, 0);
         VitalSignDirectory vitalSigndir=don.getVitalSignDir();
            if(!vitalSigndir.getVitalSignDir().isEmpty()) 
           {
               for(VitalSign vs : vitalSigndir.getVitalSignDir())
               {
           //VitalSign vs=vitalSigndir.addTest();
        String BloodGrp= vs.getBloodType();
       //Patient pt=(Patient)PatientJTable.getValueAt(selectedRow1, 0);
        String PtnbloodGp=PtnBloodGroup;
        if(BloodGrp.equals("O"))
        {genA=vs.getAntigenA();
         genB=vs.getAntigenB();
         genC=vs.getAntigenC();
         genDB=vs.getAntigenDB1();
         genDQ=vs.getAntigenDQ();
         int Sum = genA+genB+genC+genDB+genDQ;
         if(Sum > 5)
         {
             JOptionPane.showMessageDialog(null, "No of Matching Attributes " + Sum, "Info", JOptionPane.INFORMATION_MESSAGE);
         }
        }
        else if(BloodGrp.equals("A"))
        {
            if(PtnbloodGp.equals("AB") ||PtnbloodGp.equals("A") )
        {genA=vs.getAntigenA();
         genB=vs.getAntigenB();
         genC=vs.getAntigenC();
         genDB=vs.getAntigenDB1();
         genDQ=vs.getAntigenDQ();
         int Sum = genA+genB+genC+genDB+genDQ;
         if(Sum > 5)
         {
             JOptionPane.showMessageDialog(null, "No of Matching Attributes " + Sum, "Info", JOptionPane.INFORMATION_MESSAGE);
         }
        }
        }
         else if(BloodGrp.equals("B"))
        {
            if(PtnbloodGp.equals("AB") ||PtnbloodGp.equals("B") )
        {
            genA=vs.getAntigenA();
         genB=vs.getAntigenB();
         genC=vs.getAntigenC();
         genDB=vs.getAntigenDB1();
         genDQ=vs.getAntigenDQ();
         int Sum = genA+genB+genC+genDB+genDQ;
         if(Sum > 5)
         {
             JOptionPane.showMessageDialog(null, "No of Matching Attributes " + Sum, "Info", JOptionPane.INFORMATION_MESSAGE);
         }
        }
        }
         else if(BloodGrp.equals("AB"))
        {
            if(PtnbloodGp.equals("AB"))
        {
            genA=vs.getAntigenA();
         genB=vs.getAntigenB();
         genC=vs.getAntigenC();
         genDB=vs.getAntigenDB1();
          genDQ=vs.getAntigenDQ();
         int Sum = genA+genB+genC+genDB+genDQ;
         if(Sum > 5)
         {
             JOptionPane.showMessageDialog(null, "No of Matching Attributes " + Sum, "Info", JOptionPane.INFORMATION_MESSAGE);
             //JOptionPane.showMessageDialog(null, Sum , "Info", JOptionPane.INFORMATION_MESSAGE);
         }
        }
        }}
        }
         else
    { 
                 
       JOptionPane.showMessageDialog(null, "Not a Matching Donor", "Info", JOptionPane.INFORMATION_MESSAGE);
   }
        
   }
    public void populateRequestTable(){
       
        DefaultTableModel model = (DefaultTableModel) PatientJTable.getModel();
        
        model.setRowCount(0);
        //for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[2];
//            patient=(Patient) ((LabTestWorkRequest) request).getPatient();
//            row[0] = patient;
//            String result = ((LabTestWorkRequest) request).getTestResult();
//            if(result.equalsIgnoreCase("Completed"))
//            {
           //  patient=(Patient) ((LabTestWorkRequest) request).getPatient();
            row[0] = patient;
           // row[1] = result == null ? "Waiting" : result;
            row[1]=type;
            model.addRow(row);
        //}
       // }
        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        PatientJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        DonorjTable = new javax.swing.JTable();
        ViewDonorButton1 = new javax.swing.JButton();
        EmailBtn1 = new javax.swing.JButton();
        MessageBtn1 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        BloodPressureText = new javax.swing.JTextField();
        BloodPlatText = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        HemaglobinText = new javax.swing.JTextField();
        CalculatedistanceBtn = new javax.swing.JButton();
        BodyMassText = new javax.swing.JTextField();
        BloodTypeText = new javax.swing.JTextField();
        MatchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GoogleMapBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Patient Name", "Organ Type"
            }
        ));
        jScrollPane3.setViewportView(PatientJTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, 193, 116));

        DonorjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Donor Name", "Status", "Avaliable Organ", "Network"
            }
        ));
        jScrollPane4.setViewportView(DonorjTable);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 36, 352, 116));

        ViewDonorButton1.setText("View");
        ViewDonorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDonorButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(ViewDonorButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 158, -1, -1));

        EmailBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/download.jpeg"))); // NOI18N
        EmailBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(EmailBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 522, 103, 99));

        MessageBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/images (1).jpeg"))); // NOI18N
        MessageBtn1.setText("Send Message");
        MessageBtn1.setMaximumSize(new java.awt.Dimension(200, 200));
        MessageBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(MessageBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 522, 86, 103));

        jLabel36.setText("Blood Pressure");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 274, -1, -1));

        BloodPressureText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodPressureTextActionPerformed(evt);
            }
        });
        jPanel2.add(BloodPressureText, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 269, 88, -1));

        BloodPlatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodPlatTextActionPerformed(evt);
            }
        });
        jPanel2.add(BloodPlatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 306, 88, -1));

        jLabel38.setText("Blood Platlets");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 311, -1, -1));

        jLabel43.setText("Hemaglobin");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 343, -1, -1));

        HemaglobinText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HemaglobinTextActionPerformed(evt);
            }
        });
        jPanel2.add(HemaglobinText, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 338, 88, -1));

        CalculatedistanceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/distanceIcon.jpg"))); // NOI18N
        CalculatedistanceBtn.setText("Calculate Distance");
        CalculatedistanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatedistanceBtnActionPerformed(evt);
            }
        });
        jPanel2.add(CalculatedistanceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 522, 98, 103));

        BodyMassText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BodyMassTextActionPerformed(evt);
            }
        });
        jPanel2.add(BodyMassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 370, 88, -1));
        jPanel2.add(BloodTypeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 402, 88, -1));

        MatchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/match.jpeg"))); // NOI18N
        MatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatchButtonActionPerformed(evt);
            }
        });
        jPanel2.add(MatchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 522, 115, 103));

        jLabel2.setText("Body Mass");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 380, -1, -1));

        jLabel3.setText("Blood Type");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 407, -1, -1));

        GoogleMapBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/google_maps.png"))); // NOI18N
        GoogleMapBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoogleMapBtnActionPerformed(evt);
            }
        });
        jPanel2.add(GoogleMapBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 522, 93, 103));

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 643, -1, -1));

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void HemaglobinTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HemaglobinTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HemaglobinTextActionPerformed

    private void MessageBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MessageBtn1ActionPerformed
        // TODO add your handling code here:
        SendAlertMessage sendAlertMessage = new SendAlertMessage(userProcessContainer);
        userProcessContainer.add("SendAlertMessage", sendAlertMessage);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_MessageBtn1ActionPerformed

    private void EmailBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailBtn1ActionPerformed
        // TODO add your handling code here:
        SendEmail sendEmail = new SendEmail(userProcessContainer);
        userProcessContainer.add("SendEmail", sendEmail);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_EmailBtn1ActionPerformed

    private void ViewDonorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDonorButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = DonorjTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        Donor d = (Donor)DonorjTable.getValueAt(selectedRow, 0);
        VitalSignDirectory vitalSigndir=d.getVitalSignDir();
        if(!vitalSigndir.getVitalSignDir().isEmpty()) 
           {
               for(VitalSign vs : vitalSigndir.getVitalSignDir())
               {
           //VitalSign vs=vitalSigndir.addTest();

        BloodTypeText.setText(vs.getBloodType());
        BloodPlatText.setText(vs.getBloodPlatlets());
        BloodPressureText.setText(vs.getBloodPressure());
        HemaglobinText.setText(vs.getHemoglobinLevel());
        BodyMassText.setText(String.valueOf(vs.getBodySize()));
    }//GEN-LAST:event_ViewDonorButton1ActionPerformed
           }}
    private void BloodPlatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodPlatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BloodPlatTextActionPerformed

    private void BodyMassTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BodyMassTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BodyMassTextActionPerformed

    private void CalculatedistanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatedistanceBtnActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = DonorjTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        Donor d = (Donor)DonorjTable.getValueAt(selectedRow, 0);
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
           for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
               
              if(enterprise.getEnterpriseType().equals(OrganBank)){
                  
                 for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if(organization instanceof DonorOrganization) {
                       for (Donor d1 :matchingDonor){
                           if (d1.equals(d)){
                          double  Latitude=enterprise.getLatitude();
                           double    Longitude=enterprise.getLongitude();
                           }
                           
                           }
                       }
                   }
              }
           }
        }
        Double distance= distance(Latitude,Longitude, lat, longt,"K");
        JOptionPane.showMessageDialog(null, "Distance in km from Organization is " + distance , "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_CalculatedistanceBtnActionPerformed

    private void MatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatchButtonActionPerformed
        // TODO add your handling code here:
        
        matchingAlgorithm();
    }//GEN-LAST:event_MatchButtonActionPerformed

    private void BloodPressureTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodPressureTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BloodPressureTextActionPerformed

    private void GoogleMapBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoogleMapBtnActionPerformed
        // TODO add your handling code here:
      //  googlemap(longitude,latitude,longitude,latitude);
        int selectedRow = DonorjTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }
        Donor d = (Donor)DonorjTable.getValueAt(selectedRow, 0);
        for (Network network : system.getNetworkList()) {
                //Step 2-a: Check against each enterprise
           for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
               
              if(enterprise.getEnterpriseType().equals(OrganBank)){
                  
                 for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                   if(organization instanceof DonorOrganization) {
                       for (Donor d1 :matchingDonor){
                           if (d1.equals(d)){
                               
                           Latitude=enterprise.getLatitude();
                          Longitude=enterprise.getLongitude();
                          break;
                           }
                           
                           }
                       }
                   }
              }
           }
        }
        Browser browser = new Browser();
      BrowserView browserView = new BrowserView(browser);

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.add(browserView, BorderLayout.CENTER);
      frame.setSize(700, 500);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
     //longitude=patient.getLongitude();
      //latitude=patient.getLatitude();
     // distance(32.9697, -96.80322, 29.46786, -98.53506, "K");
      browser.loadURL("http://www.google.com/maps/place/"+Longitude+","+Latitude+"/@"+longt+","+lat+",16z");
      //browser.loadURL("http://www.google.com/maps/place/"+"32.9697"+","+ "-96.80322" +"/@"+"32.9697"+","+"-96.80322"+",16z");
        
    }//GEN-LAST:event_GoogleMapBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed
private static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
    }

   
    /*	This function converts decimal degrees to radians						 :*/
    
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    
    /*	This function converts radians to decimal degrees						 :*/
 
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BloodPlatText;
    private javax.swing.JTextField BloodPressureText;
    private javax.swing.JTextField BloodTypeText;
    private javax.swing.JTextField BodyMassText;
    private javax.swing.JButton CalculatedistanceBtn;
    private javax.swing.JTable DonorjTable;
    private javax.swing.JButton EmailBtn1;
    private javax.swing.JButton GoogleMapBtn;
    private javax.swing.JTextField HemaglobinText;
    private javax.swing.JButton MatchButton;
    private javax.swing.JButton MessageBtn1;
    private javax.swing.JTable PatientJTable;
    private javax.swing.JButton ViewDonorButton1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
