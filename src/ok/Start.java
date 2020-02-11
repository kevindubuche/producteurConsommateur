package ok;

import java.awt.BorderLayout;

import javax.swing.BoundedRangeModel;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
/**
 *
 * @author Administrateur
 */
class BoundedChangeListener implements ChangeListener {
  public void stateChanged(ChangeEvent changeEvent) {
    Object source = changeEvent.getSource();
     if (source instanceof JSlider) {
      JSlider theJSlider = (JSlider) source;
      if (!theJSlider.getValueIsAdjusting()) {
          int value =(theJSlider.getMaximum()-theJSlider.getValue());
        System.out.println("Slider 1 changed: " + value);         
    } 
    }
  }
}
class BoundedChangeListenerTwo implements ChangeListener {
  public void stateChanged(ChangeEvent changeEvent) {
    Object source = changeEvent.getSource();
     if (source instanceof JSlider) {
      JSlider theJSlider = (JSlider) source;
      if (!theJSlider.getValueIsAdjusting()) {
          int value =(theJSlider.getMaximum()-theJSlider.getValue());
        System.out.println("Slider 2 changed: " + value);         
    } 
    }
  }
}

public class Start {
 
    public static void main (String arg[]){
    JFrame frame = new JFrame("Production /Consommation");
    JSlider jSliderOne = new JSlider(0,1000,500);
    JSlider jSliderTwo = new JSlider(0,1000,0);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    jSliderOne.addChangeListener(new BoundedChangeListener());
    jSliderTwo.addChangeListener(new BoundedChangeListenerTwo());
    
    frame.setLayout(new GridLayout(0,4));
        
         JLabel label11, label12;
    label11 = new JLabel(" PRODUCTEUR", JLabel.RIGHT); 
    label12 = new JLabel(" CONSOMMATEUR ",JLabel.RIGHT);
    frame.add(label11); 
   
        
    frame.add(jSliderOne, BorderLayout.NORTH); frame.add(label12); 
    frame.add(jSliderTwo, BorderLayout.SOUTH);
    frame.setSize(800, 500);
    frame.setVisible(true);
    
        JProgressBar progBar;  
        JLabel labConten = new JLabel("CONTAINER");
        progBar = new JProgressBar(SwingConstants.VERTICAL); 
        JPanel p = new JPanel(); 
        progBar.setValue(0); 
        progBar.setStringPainted(true);  
        p.add(progBar);
        p.add(labConten);
        frame.add(p);   
        
        
  
      new Producteur(jSliderOne,progBar);
      new Consommateur(jSliderTwo); 
                          
}  
}
