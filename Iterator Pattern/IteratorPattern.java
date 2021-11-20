/*

Suppose we are building an application that requires us to maintain a list of notifications. Eventually, some part of your code will
require to iterate over all notifications.We can do everything as well as iterate the notification in main function but if we do this,
we are exposing underlying representation of aggregate object.This is a bad design and to prevent that we use iterator pattern.

See the code below.

*/
class Notification{
    String notification;
  
    public Notification(String notification){
        this.notification = notification;
    }
    public String getNotification(){
        return notification;
    }
}

interface Collection{
    public Iterator createIterator();
}

class NotificationCollection implements Collection{
    static final int MAX_ITEMS = 6;
    int pos = 0;
    Notification[] notificationList;
  
    public NotificationCollection(){
        notificationList = new Notification[MAX_ITEMS];
  
        addItem("Notification 1");
        addItem("Notification 2");
        addItem("Notification 3");
    }
  
    public void addItem(String str){
        Notification notification = new Notification(str);
        if (pos >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            notificationList[pos] = notification;
            pos = pos + 1;
        }
    }
    public Iterator createIterator(){
        return new NotificationIterator(notificationList);
    }
}
interface Iterator{

    boolean hasNext();
    Object next();
}
class NotificationIterator implements Iterator{
    Notification[] notificationList;
    int pos = 0;
  
    public  NotificationIterator (Notification[] notificationList){
        this.notificationList = notificationList;
    }
  
    public Object next(){
        Notification notification =  notificationList[pos];
        pos += 1;
        return notification;
    }
    public boolean hasNext(){

        if (pos >= notificationList.length || notificationList[pos] == null) return false;
        else return true;
    }
}
class NotificationBar{

    NotificationCollection notifications;
    public NotificationBar(NotificationCollection notifications){
        this.notifications = notifications;
    }
  
    public void printNotifications(){
        Iterator iterator = notifications.createIterator();
        System.out.println("-------NOTIFICATION BAR------------");
        while (iterator.hasNext()){
            Notification n = (Notification)iterator.next();
            System.out.println(n.getNotification());
        }
    }
}
public class IteratorPattern {
    public static void main(String args[]){
        NotificationCollection nc = new NotificationCollection();
        NotificationBar nb = new NotificationBar(nc);
        nb.printNotifications();
    }
}
