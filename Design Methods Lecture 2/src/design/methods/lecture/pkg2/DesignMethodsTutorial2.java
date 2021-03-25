package design.methods.lecture.pkg2;

import java.util.LinkedList;

public class DesignMethodsTutorial2 {
    public static void main(String[] args) {
        chatMediator m = new chatMediator();
       
        lecturer l1 = new lecturer(m,001);
        lecturer l2 = new lecturer(m,002);
        lecturer l3 = new lecturer(m,003);
        lecturer l4 = new lecturer(m,004);
       
        admin a1 = new admin(m,101);
        admin a2 = new admin(m,102);
       
        m.addUser(l1);
        m.addUser(l2);
        m.addUser(l3);
        m.addUser(l4);
        m.addUser(a1);
        m.addUser(a2);
        System.out.println("-- Start Broadcast Send Announcement Globally --");
        l3.send("Hello, Welcome to the world!");
        System.out.println("-- End Broadcast Send Announcement Globally --");
        System.out.println("-- Start Broadcast Send Announcement User Group --");
        l3.send("Hello, Welcome to the world!","admin");
        System.out.println("-- End Broadcast Send Announcement User Group --");
        System.out.println("-- Start Broadcast Send Announcement Target User ID --");
        l3.send("Hello, Welcome to the world!",101);
        System.out.println("-- End Broadcast Send Announcement Target User ID --");
    }
    
}

interface mediator{
        public void sendMsg(String msg, chatUser user);
        public void sendMsg(String msg, chatUser user, String recvType);
        public void sendMsg(String msg, chatUser user, int receiver);
    }
    abstract class chatUser{
        mediator m;
        int id;
       
        public chatUser(mediator m,int id){
            this.m = m;
            this.id = id;
        }
        abstract public void send(String msg);
        abstract public void send(String msg, String recvType);
        abstract public void send(String msg, int receiver);
        abstract public void recv(String msg, int id);
    }
 
class lecturer extends chatUser{
    public lecturer(mediator m,int id){
        super(m,id);
    }
 
    @Override
    public void send(String msg) {
        m.sendMsg(msg, this);
    }
 
    @Override
    public void recv(String msg, int id) {
        System.out.println(this.getClass().getSimpleName() + " " + super.id + " has received msg: " + msg + " from " + id);
    }
 
    @Override
    public void send(String msg, String recvType) {
        m.sendMsg(msg, this, recvType);
    }
 
    @Override
    public void send(String msg, int receiver) {
        m.sendMsg(msg, this, receiver);
    }
   
}
 
class admin extends chatUser{
    public admin(mediator m,int id){
        super(m,id);
    }
 
    @Override
    public void send(String msg) {
        m.sendMsg(msg, this);
    }
 
    @Override
    public void recv(String msg, int id) {
        System.out.println(this.getClass().getSimpleName() + " " + super.id + " has received msg: " + msg + " from user " + id);
    }
 
    @Override
    public void send(String msg, String recvType) {
        m.sendMsg(msg, this, recvType);
    }
 
    @Override
    public void send(String msg, int receiver) {
         m.sendMsg(msg, this, receiver);
    }
   
}
 
class chatMediator implements mediator{
 
    LinkedList<chatUser> users = new LinkedList<chatUser>();
   
    public void addUser(chatUser user){
        users.addLast(user);
    }
   
    @Override
    public void sendMsg(String msg, chatUser sender) {
        users.stream().filter((u) -> (u.id != sender.id)).forEachOrdered((u) -> {
            u.recv(msg,sender.id);
        });
    }
 
    @Override
    public void sendMsg(String msg, chatUser user, String recvType) {
        users.stream().filter((u) -> (u.id != user.id)).filter((u) -> (u.getClass().getSimpleName().equalsIgnoreCase(recvType))).forEachOrdered((u) -> {
            u.recv(msg,user.id);
        });
    }
 
    @Override
    public void sendMsg(String msg, chatUser user, int receiver) {
        for (chatUser u : users){
            if (u.id != user.id){
                if (u.id == receiver){
                    u.recv(msg, user.id);
                }
            }
        }
    }
}
