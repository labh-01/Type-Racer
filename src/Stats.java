
import java.io.BufferedReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class Stats extends javax.swing.JFrame {

    /**
     * Creates new form Stats
     */
    String headpath=new Provide_path().getHeadpath();
    public Stats() {
        initComponents();
        
    }
 String requirement,mode,name;
   public Stats( String applicationTitle,String chartTitle ,String requirement, String mode,String name) {
      //super( applicationTitle );
       if(mode.equals("Guest"))
           this.name=mode;
       else
           this.name=name;
      this.requirement=requirement;
      this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      this.mode=mode;
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,"no of practice drills",requirement , createDataset(), PlotOrientation.VERTICAL,true,true,false);
        JPanel chartPanel = new ChartPanel(chart);
       chartPanel.setPreferredSize(new java.awt.Dimension( 550 , 300 ) );  
      this.pack();  
      this.setContentPane(chartPanel);
      RefineryUtilities.centerFrameOnScreen( this );        
   }
    private XYSeriesCollection createDataset( ) { 
       int i = 0;
       BufferedReader rdr = null;
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("");
        try {
            Path filePath = Paths.get(headpath+mode+"\\"+name+"_"+requirement+".txt");
               Scanner scanner = new Scanner(filePath);
               while (scanner.hasNext()) {
                      if (scanner.hasNextInt()) {
                          i = i+1;
                      int a = scanner.nextInt();
                      System.out.println(i+"  "+a);
                      series.add(i, a);
                      }
                      else {
                      scanner.next();
                       }
}
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally{
            dataset.addSeries(series);
            return dataset;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
