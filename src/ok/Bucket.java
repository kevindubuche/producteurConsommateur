package ok;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Administrateur
 */
public class Bucket {
    Queue<Boolean> queue= new LinkedList<>();
    long maxQueueSize = 500;//The bucket can't hold more than this value
    //let's do a contructor to initialise our Bucket by calling it

    public Bucket(long maxQueueSize){
        this.maxQueueSize=maxQueueSize;
    }
    
    //Method to check if the Bucket is empty
    public boolean isEmpty(){
        return this.queue.size()==0;
    }
    
    //Method to check if the Bucket is full
    public boolean isFull(){
        return this.queue.size()==this.maxQueueSize;
    }
    
    public synchronized long getActualSize(){
        return this.queue.size();
    }
     public  long getMaxBucket(){
        return this.maxQueueSize;
    }
    
    //Method to add an element from the array
    //We synchronize it so that on le met sur verrou a l'utilisation et cree donc une section critique pour l'autre thread
    public synchronized void addElement(){
        try{
            //if the bucked is empty we're gonna wait
            while(isFull()){
                System.out.println("Bucket Full. Please Wait...");
                wait();//the object that will call this method will wait until the Bucket get ready
                //then it will resume the process
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        queue.add(true);
        notifyAll();// wake all the threads up so that they can access to the object
    }
    
    //Method to get an element from the array
    //We synchronize it so that on le met sur verrou a l'utilisation et cree donc une section critique pour l'autre thread
    public synchronized void getElement(){
        try{
            //if the bucked is empty we're gonna wait
            while(isEmpty()){
                System.out.println("Bucket Empty. Please Wait...");
                wait();//the object that will call this method will wait until the Bucket get something
                //then it will resume the process
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        queue.remove();
        notifyAll();// wake all the threads up so that they can access to the object
    }
}
