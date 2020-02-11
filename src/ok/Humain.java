package ok;


abstract class Humain implements Runnable { //abstract because both Producduc and consommateur have the same bucket and frame
    private static Bucket bucket = new Bucket(1000);
    public Humain(){
        (new Thread(this)).start();
    }
    public Bucket getBucket(){
       return this.bucket;
       
    }
}


