package ccp.assignment;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class CCPAssignment {
    public static void main(String[] args){
        ExecutorService ex = Executors.newCachedThreadPool();
        //create queues
        LinkedBlockingQueue<can>sterileRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<can>fillRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<can>sealRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<can>labelRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<can>packageRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<packages>boxRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<box>loadRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<box>areaRack = new LinkedBlockingQueue<>();
        LinkedBlockingQueue<can>rejectGrabber = new LinkedBlockingQueue<>();
        
        for(int i=1; i<50000; i++){
            can c = new can(i);
            Random rand2 = new Random();
            int delay = rand2.nextInt(10);
            int y = (delay + 10)*5;
            
        Future<can> canScanner = ex.submit(new canScanner(c, sterileRack, loadRack, rejectGrabber));    
            try{
//                canScanner cScan = new canScanner(c, sterileRack, loadRack, rejectGrabber);
//                new Thread(cScan).start();
                Thread.sleep(y);

                canSteriliser cSter = new canSteriliser(c, sterileRack, fillRack);
                new Thread(cSter).start();
                Thread.sleep(10);
                
                canFiller cFill = new canFiller(c, fillRack, sealRack, rejectGrabber);
                new Thread(cFill).start();
                Thread.sleep(10);
                
                canSealer cSeal = new canSealer(c, sealRack, labelRack, rejectGrabber);
                new Thread(cSeal).start();
                Thread.sleep(10);
                
                canLabeller cLabel = new canLabeller(c, labelRack, packageRack);
                new Thread(cLabel).start();
                Thread.sleep(10);
                
                canPackager cPack = new canPackager(c, packageRack, boxRack);
                new Thread(cPack).start();
                Thread.sleep(10);
                
                canLoader cLoad = new canLoader(c, boxRack, loadRack);
                new Thread(cLoad).start();
                Thread.sleep(10);
                
                canForks cForks = new canForks(c, loadRack, areaRack);
                new Thread(cForks).start();
                Thread.sleep(10);
                
            }catch (Exception e){}
        }
    }
}

class can{
    int id;
   
    public can(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
}

class packages{
    int pid;
    ArrayList<can>packageArray;
    
    public packages(int pid, ArrayList<can>packageArray){
        this.pid = pid;
        this.packageArray = packageArray;
    }
    
    public int getPackageID(){
        return pid;
    }
}

class box{
    int bid;
    ArrayList<packages>boxArray;
    
    public box(int bid, ArrayList<packages>boxArray){
        this.bid = bid;
        this.boxArray = boxArray; 
    }
}

class canScanner implements Callable<can>{
    can c;
    int id;
    box b;
    LinkedBlockingQueue<can>sterileRack;
    LinkedBlockingQueue<box>loadRack;
    LinkedBlockingQueue<can>rejectGrabber;
    
    public canScanner(can c, LinkedBlockingQueue<can>sterileRack, LinkedBlockingQueue<box>loadRack, LinkedBlockingQueue<can>rejectGrabber){
        this.c = c;
        this.id = this.c.id;
        this.sterileRack = sterileRack;
        this.loadRack = loadRack;
        this.rejectGrabber = rejectGrabber;
    }
    
    synchronized public void scan(){
        while(loadRack.size() == 12){
            try{
                wait();
            }catch (Exception e){}
        }
        
        System.out.println("New can number " + id + " is entering the factory from an external supply");
        Random rand = new Random();
        int defect = rand.nextInt(10);
        
        //check if can has a defect
        System.out.println("\tScanning can " + id);
        
        if(defect == 1){
            System.out.println("\tCan " + id + " defect detected and is thrown out of the production line");
            try{
                rejectGrabber.put(c);
            }catch (Exception e){}
        }else{
            try{
                System.out.println("Can " + id + " is waiting to be sterilised");
                sterileRack.put(c);
            }catch (Exception e){}
        }
    }

    @Override
    public can call() throws Exception {
        if(true){
            scan();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        return c;
    }
}

class canSteriliser implements Runnable{
    LinkedBlockingQueue<can>fillRack;
    LinkedBlockingQueue<can>sterileRack;
    can c;
    int id;
    
    public canSteriliser(can c, LinkedBlockingQueue<can>sterileRack, LinkedBlockingQueue<can>fillRack){
        this.c = c;
        this.sterileRack = sterileRack;
        this.fillRack = fillRack;
        this.id = this.c.id;
    }
    
    synchronized public void sterilise(){
        if(sterileRack.size() == 4){
            System.out.println("Sterilised rack is full.");
            
            while(sterileRack.size() != 0){
                try{
                    System.out.println("\tCan " + sterileRack.peek().id + " is sterilised");
                    fillRack.put(sterileRack.take());
                    notify();
                }catch (Exception e){}
            }
        }
    }    

    @Override
    public void run() {
        if(true){
            sterilise();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canFiller implements Runnable{
    LinkedBlockingQueue<can>fillRack;
    LinkedBlockingQueue<can>sealRack;
    LinkedBlockingQueue<can>rejectGrabber;
    can c;
    int id;

    public canFiller(can c, LinkedBlockingQueue<can>fillRack, LinkedBlockingQueue<can>sealRack, LinkedBlockingQueue<can>rejectGrabber){
        this.fillRack = fillRack;
        this.sealRack = sealRack;
        this.c = c;
        this.id = this.c.id;
        this.rejectGrabber = rejectGrabber;
    }
    
    synchronized public void fill(){
        while(fillRack.isEmpty()){
            try{
                wait();
            }catch (Exception e){}
        }
        
        Random rand = new Random();
        int defect = rand.nextInt(10);

        try{
            System.out.println("\tFilling can " + fillRack.peek().id);
            
            if(defect == 1){
                try{
                    System.out.println("\tCan " + fillRack.take().id + " has a fill defect detected "
                            + "and is thrown out of the production line");
                    rejectGrabber.put(fillRack.take());
                }catch(Exception e){}
            }else{
                try{
                    Thread.sleep(15);
                    System.out.println("Can " + fillRack.peek().id + " is filled to the correct level");
                    sealRack.put(fillRack.take());
                    notify();
                }catch(Exception e){}
            } 
        }catch(Exception e){}    
    }

    @Override
    public void run() {
        if(true){
            fill();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canSealer implements Runnable{
    LinkedBlockingQueue<can>sealRack;
    LinkedBlockingQueue<can>labelRack;
    LinkedBlockingQueue<can>rejectGrabber;
    can c;
    int id;

    public canSealer(can c, LinkedBlockingQueue<can>sealRack, LinkedBlockingQueue<can>labelRack, LinkedBlockingQueue<can>rejectGrabber){
        this.labelRack = labelRack;
        this.sealRack = sealRack;
        this.c = c;
        this.id = this.c.id;
        this.rejectGrabber = rejectGrabber;
    }
    
    synchronized public void seal(){
        while(sealRack.isEmpty()){
            try{
                wait();
            }catch (Exception e){}
        }
        
        Random rand = new Random();
        int defect = rand.nextInt(10);

        if(sealRack.size() == 12){
            System.out.println("Sealing rack is full.");
                
            while(sealRack.size() != 0){
                try{
                    System.out.println("\tCan " + sealRack.peek().id + " is sealed with a lid");
                    labelRack.put(sealRack.take());
                    notify();
                }catch (Exception e){}
            }
        }
        
        if(defect == 1){
            try{
                System.out.println("\tCan " + labelRack.take().id + " has been "
                        + "removed by sealing scanner");
                rejectGrabber.put(sealRack.take());
            } catch (Exception e){}
        }
    }

    @Override
    public void run() {
        if(true){
            seal();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canLabeller implements Runnable{
    LinkedBlockingQueue<can>packageRack;
    LinkedBlockingQueue<can>labelRack;
    can c;
    int id;

    public canLabeller(can c, LinkedBlockingQueue<can>labelRack, LinkedBlockingQueue<can>packageRack){
        this.labelRack = labelRack;
        this.packageRack = packageRack;
        this.c = c;
        this.id = this.c.id;
    }
    
    synchronized public void label(){
        while(labelRack.isEmpty()){
            try{
                wait();
            }catch (Exception e){}
        }
        
        Random rand = new Random();
        int defect = rand.nextInt(10);

        try{
            System.out.println("\tLabelling can " + labelRack.peek().id);
            
            if(defect == 1){
                try{
                    System.out.println("\tCan " + labelRack.take().id + " has a label defect "
                            + "detected and is thrown out of the production line");
                }catch(Exception e){}
            }else{
                try{
                    Thread.sleep(15);
                    System.out.println("Can " + labelRack.peek().id + " is labelled");
                    packageRack.put(labelRack.take());
                    
                }catch(Exception e){}
            } 
        }catch(Exception e){}
    }

    @Override
    public void run() {
        if(true){
            label();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canPackager implements Runnable{
    LinkedBlockingQueue<packages>boxRack;
    LinkedBlockingQueue<can>packageRack;
    ArrayList<can>packageArray = new ArrayList<>(6);
    can c;
    int id;
    static int pid = 1;

    public canPackager(can c, LinkedBlockingQueue<can>packageRack, LinkedBlockingQueue<packages>boxRack){
        this.packageRack = packageRack;
        this.boxRack = boxRack;
    }

    synchronized public void packaging(){
        packages p = new packages(pid,packageArray);
        
        while(packageRack.isEmpty()){
            try{
                wait();
            }catch (Exception e){}
        }

        if(packageRack.size() == 6){
            System.out.println("Package rack is full.");
  
            while(!packageRack.isEmpty()){
                try{
                    System.out.println("\tCan " + packageRack.peek().id + " is packaged and shrink wrapped");
                    p.packageArray.add(packageRack.take());
                    notify();
                }catch (Exception e){}
            }
            
            for (int i=0;i<6;i++) { 		      
                System.out.println("\t\tPackage " + pid + " has cans " + packageArray.get(i).getID());		
            }
            
            pid++;
            try{
                boxRack.put(p);
                packageArray.removeAll(packageArray);
            }catch(Exception e){}
        }
    }

    @Override
    public void run() {
        if(true){
            packaging();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canLoader implements Runnable{
    LinkedBlockingQueue<packages>boxRack;
    LinkedBlockingQueue<box>loadRack;
    ArrayList<packages>boxArray = new ArrayList<>(27);
    can c;
    int id;
    static int bid = 1;

    public canLoader(can c, LinkedBlockingQueue<packages>boxRack, LinkedBlockingQueue<box>loadRack){
        this.boxRack = boxRack;
        this.loadRack = loadRack;
    }

    synchronized public void boxing(){
        box b = new box(bid,boxArray);
        
        while(boxRack.size()<1){
            try{
                wait();
            }catch (Exception e){}
        }

        if(boxRack.size() == 27){
            System.out.println("Boxing rack is full.");
  
            while(boxRack.size() != 0){
                try{
                    b.boxArray.add(boxRack.take());
                    notify();
                }catch (Exception e){}
            }
            
            for (int i=0;i<27;i++) { 		      
                System.out.println("\tBox " + bid + " are heading "
                + "to the loading area and has package " + boxArray.get(i).getPackageID());		
            }
           
            bid++;
            try{
                loadRack.put(b);
                boxArray.removeAll(boxArray);
            }catch(Exception e){}
        }
    }

    @Override
    public void run() {
        if(true){
            boxing();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class canForks implements Runnable{
    LinkedBlockingQueue<box>loadRack;
    LinkedBlockingQueue<box>areaRack;
    int id;
    can c;
    loadingBay lb = new loadingBay(2); 

    public canForks(can c, LinkedBlockingQueue<box>loadRack, LinkedBlockingQueue<box>areaRack){
        this.loadRack = loadRack;
        this.areaRack = areaRack;
    }

    synchronized public void loading(){
        while(loadRack.size()<1){
            try{
                wait();
            }catch (Exception e){}
        }
        
        if(loadRack.size() == 12){
            System.out.println("Loading bay is full.");
            try{
            wait();
            }catch (Exception e){}
        }else{
            notifyAll();
        }
        
        while(loadRack.size()<12 && loadRack.size() > 0){
            notifyAll();
            try{
                System.out.println("Assigning forklift to collect the box from the loading area");
                Random rand = new Random();
                int choosen = rand.nextInt(3);
                Random rand2 = new Random();
                int defect = rand2.nextInt(2);
                int fid = loadRack.peek().bid;
                
                if(choosen == 0){
                    if(defect == 0){
                        System.out.println("Forklift one is having trouble, auto fixing and deploying other forklift...");
                        Thread.sleep(1000);
                    }
                    System.out.println("Forklift one is taking box " + fid + " to the loading bay");
                    areaRack.put(loadRack.take());
                     
                }else if(choosen == 1){
                    if(defect == 0){
                        System.out.println("Forklift two is having trouble, auto fixing and deploying other forklift...");
                        Thread.sleep(1000);
                    }                  
                    System.out.println("Forklift two is taking box " + fid + " to the loading bay");
                    areaRack.put(loadRack.take());
                    
                }else if(choosen == 2){
                    if(defect == 0){
                        System.out.println("Forklift three is having trouble, auto fixing and deploying other forklift...");
                        Thread.sleep(1000);
                    }
                    System.out.println("Forklift three is taking box " + fid + " to the loading bay");
                    areaRack.put(loadRack.take());
                    
                }else{
                    System.out.println("Error found.");
                }
            }catch (Exception e){}
        }
    
        System.out.println(areaRack);
        
        if(areaRack.size() > 0){
            for(int k = 1; k < 4; k++){
                new Thread(new Van(lb,k,areaRack)).start();
                try{
                    Thread.sleep(50);
                }catch(Exception e){}
            }
        }
    }

    @Override
    public void run() {
        if(true){
            loading();
        }
        try{
            Thread.sleep(10);
        }catch(Exception e){}
    }
}

class Van implements Runnable{
    loadingBay lb;
    int id;
    box b;
    LinkedBlockingQueue<box>areaRack;
    
    public Van(loadingBay lb, int id, LinkedBlockingQueue<box>areaRack){
        this.lb = lb;
        this.id = id;
        this.areaRack = areaRack;
    }

    public void run(){
        lb.enter(id);
        
        try{
            Thread.sleep(10);
        }catch(Exception e){}
        
        if(areaRack.size() == 20){
            System.out.println("Area rack is full.");
            
            for (int i=0;i<20;i++) { 		
                try{
                    System.out.println("\tVan " + id + " contains box " + areaRack.take().bid);
                }catch(Exception e){}		
            }

            lb.exit(id);
        }
        
        try{
            Thread.sleep(5000);
        }catch(Exception e){}
    } 
}
 
class loadingBay{
    Semaphore s;

    public loadingBay(int size){
        s = new Semaphore(size);
    }
    
    public void enter(int id){
        System.out.println("Van " + id + " is trying to enter the loading bay");
        try {
            s.acquire();
        } catch (Exception ex) {}
        System.out.println("Van " + id + " has entered the loading bay");
    }
    
    public void exit(int id){
        System.out.println("Van " + id + " has exited the loading bay");
        s.release();
    }
}