/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.DonorSensor.VitalSign;
import Business.Enterprise.Enterprise;
import Business.Patient.Patient;
import Business.PatientSensor.Test;
import Business.PatientSensor.TestDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author shivam
 */
public class ViewPatientReport extends javax.swing.JPanel {
private TestDirectory testdir;
   private Patient patient;
   private JPanel userProcessContainer;
    private Enterprise enterprise;
    
private DefaultCategoryDataset dataset;
/**
     * 
     * Creates new form ViewPatientReport
     */
    public ViewPatientReport(JPanel userProcessContainer,Enterprise enterprise,Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.patient=patient;
        testdir = patient.getTestDir();
        PatientNametext.setText(patient.getName());
        PopulateTable();
    }
    public void PopulateTable()
    {
        DefaultTableModel model = (DefaultTableModel)summaryTable.getModel();
  
  model.setRowCount(0);
  for(Test vs : testdir.getTestdir())
  {
  Object row[] = new Object[4];
  row[0]=vs;
  row[1]=vs.getBloodPressure();
  row[2]=vs.getBloodPlatlets();
  row[3]=vs.getHemoglobinLevel();
  model.addRow(row);
    
    }}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        PatientNametext = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ViewGraphBtn = new javax.swing.JButton();
        LineGraphButton = new javax.swing.JButton();
        PiechartBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Timestamp", "Blood Pressure", "Blood Platlets", "Hemaglobin"
            }
        ));
        jScrollPane1.setViewportView(summaryTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 155));
        add(PatientNametext, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 242, 97, -1));

        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 247, -1, -1));

        ViewGraphBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/Bar-chart.png"))); // NOI18N
        ViewGraphBtn.setText("View Graph");
        ViewGraphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewGraphBtnActionPerformed(evt);
            }
        });
        add(ViewGraphBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 130, 120));

        LineGraphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/Actions-office-chart-area-stacked-icon.png"))); // NOI18N
        LineGraphButton.setText("Line Graph");
        LineGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LineGraphButtonActionPerformed(evt);
            }
        });
        add(LineGraphButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 120, -1));

        PiechartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/DoctorRole/pie-chart-icon_122468107.jpg"))); // NOI18N
        PiechartBtn.setText("Pie Chart");
        PiechartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PiechartBtnActionPerformed(evt);
            }
        });
        add(PiechartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 120, 120));

        jButton1.setText("back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ViewGraphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewGraphBtnActionPerformed
        // TODO add your handling code here:
         Graph();
    }//GEN-LAST:event_ViewGraphBtnActionPerformed

    private void LineGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LineGraphButtonActionPerformed
        // TODO add your handling code here:
        //dataset = new DefaultCategoryDataset();
        XYSeriesCollection dataset = new XYSeriesCollection();
       if(!(patient.getTestDir().getTestdir().isEmpty())) {
        for(Test vs : patient.getTestDir().getTestdir())
        {
             XYSeries series1 = new XYSeries(vs.getBloodPressure());
           series1.add(10,Float.parseFloat(vs.getBloodPressure()));
           series1.add(20,Float.parseFloat(vs.getBloodPlatlets()));
           series1.add(30,Float.parseFloat(vs.getHemoglobinLevel()));
           series1.add(40, Float.parseFloat(vs.getBloodPlatlets()));
           dataset.addSeries(series1);
            
//            dataset.addValue(Integer.parseInt(vs.getBloodPressure()), "Blood Pressure", vs.getTimestamp());
//            dataset.addValue(Integer.parseInt(vs.getBloodPlatlets()), "Blood Platelets", vs.getTimestamp());
//            //dataset.addValue(Integer.parseInt(vs.getHemoglobinLevel()), "Hemoglobin Level", vs.getTimestamp());
//            //dataset.addValue(vs.getWeight(), "Weight", vs.getTimestamp());
//     
        }
         JFreeChart chartFactory = ChartFactory.createXYLineChart("GRAPHICAL REPRESENTATION OF SENSOR DATA", "X-Axis", "SIGN", (XYDataset) dataset);
       XYLineAndShapeRenderer renderer = null;
       
//      
       XYPlot plot = chartFactory.getXYPlot();
       renderer = new XYLineAndShapeRenderer();
       ChartFrame frame = new ChartFrame("Line Chart Of Sensor Data", chartFactory);
       frame.setVisible(true);
       frame.setSize(700, 320);
    }//GEN-LAST:event_LineGraphButtonActionPerformed
     else {
           JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
       }
       
   
    }
    private void PiechartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PiechartBtnActionPerformed
        // TODO add your handling code here:
              DefaultPieDataset dataset= new DefaultPieDataset();
              if(!(patient.getTestDir().getTestdir().isEmpty())) {
               for(Test vs : patient.getTestDir().getTestdir())
        {
            
            
            dataset.setValue( "Blood Pressure", Float.parseFloat(vs.getBloodPressure()));
            dataset.setValue("Blood Platelets",Float.parseFloat(vs.getBloodPlatlets()));
            dataset.setValue("Hemoglobin Level",Float.parseFloat(vs.getHemoglobinLevel()));
            //dataset.addValue(vs.getWeight(), "Weight", vs.getTimestamp());
     
        }
               JFreeChart chartFactory = ChartFactory.createPieChart("Pie Chart", dataset,true,true,true);
                 PiePlot p=(PiePlot)chartFactory.getPlot();  
                // p.setForegroundAlpha(TOP_ALIGNMENT);
                  ChartFrame frame = new ChartFrame("Pie Chart for VitalSign", chartFactory);
               frame.setVisible(true);
        frame.setSize(700, 320);     
       }                                               
     else {
           JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
       }       
    }//GEN-LAST:event_PiechartBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed
public void Graph()  {
        dataset = new DefaultCategoryDataset();
         if(!(patient.getTestDir().getTestdir().isEmpty())) {
          
        for(Test vs : patient.getTestDir().getTestdir())
        {
            
            
            dataset.addValue(Float.parseFloat(vs.getBloodPressure()), "Blood Pressure", vs.getTimestamp());
            dataset.addValue(Float.parseFloat(vs.getBloodPlatlets()), "Blood Platelets", vs.getTimestamp());
            dataset.addValue(Float.parseFloat(vs.getHemoglobinLevel()), "Hemoglobin Level", vs.getTimestamp());
            //dataset.addValue(vs.getWeight(), "Weight", vs.getTimestamp());
     
        }
        
        JFreeChart chartFactory = ChartFactory.createBarChart3D("VitalSign", "Time", "VitalSign", dataset, PlotOrientation.VERTICAL, true, true, false);
       
       
        BarRenderer renderer = null;
        CategoryPlot plot = chartFactory.getCategoryPlot();
        renderer = new BarRenderer();
        ChartFrame frame = new ChartFrame("Bar Chart for VitalSign", chartFactory);
        frame.setVisible(true);
        frame.setSize(700, 320);
       }                                               
     else {
           JOptionPane.showMessageDialog(this, "No Vital Signs To Display On Graph!!!");
       }      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LineGraphButton;
    private javax.swing.JTextField PatientNametext;
    private javax.swing.JButton PiechartBtn;
    private javax.swing.JButton ViewGraphBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable summaryTable;
    // End of variables declaration//GEN-END:variables
}
