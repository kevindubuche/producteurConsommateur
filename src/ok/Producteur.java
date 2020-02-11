
package ok;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

public class Producteur extends Humain {
    public Producteur(JSlider jSliderOne,  JProgressBar progBar){
      super();
      this.jSliderOne= jSliderOne;
      this.progBar= progBar;
    }
      JSlider jSliderOne = new JSlider(0,1000,0);
      JProgressBar progBar ;
      
  
      public void run(){
        while(true){
            try{
            Thread.sleep((this.jSliderOne.getMaximum()-this.jSliderOne.getValue()));            
            getBucket().addElement();
            System.out.println("Producting..."); 
            System.out.println("Size of bucket : "+getBucket().getActualSize()); 
            progBar.setValue((int)(getBucket().getActualSize()*100/getBucket().getMaxBucket()));
            }
       catch(InterruptedException ex){
           Thread.currentThread().interrupt();
       } 
   
        }
    } 
}
