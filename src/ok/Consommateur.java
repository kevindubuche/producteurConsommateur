
package ok;

import javax.swing.JSlider;

public class Consommateur extends Humain { 
    public Consommateur(JSlider jSliderTwo){
      super();
      this.jSliderTwo= jSliderTwo;
     }
    JSlider jSliderTwo = new JSlider(0,1000,0);
    
        public void run(){
        while(true){
            try{
            Thread.sleep(this.jSliderTwo.getMaximum()-this.jSliderTwo.getValue());
            System.out.println(">>>>>>>"+(this.jSliderTwo.getMaximum()-this.jSliderTwo.getValue()));
            getBucket().getElement();
            System.out.println("Consomme..."); 
            System.out.println("Size of bucket : "+getBucket().getActualSize());
            }
       catch(InterruptedException ex){
           Thread.currentThread().interrupt();
       } 
   
        }
    }    
}
