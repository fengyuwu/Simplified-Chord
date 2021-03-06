//Intensive testing passed 10/10 Every time it runs

//UI code disabled for performance
//Final Version
//UI/UN-need Exception handing codes can be comment out/delete to improve performance.

//ISIS algorithm code  mainly based on https://studylib.net/doc/7830646/isis-algorithm-for-total-ordering-of-messages
//ISIS algorithm code  mainly based on http://www.gecg.in/papers/ds5thedn.pdf
//ISIS algorithm code  mainly based on Lecture slides
//Exception handle code, some exception is just warning from write fail and read is more important,as i need to clean the content provider and queue.
//Also used to detect failed avd / process so that it will remove bad message.

//Socket message passing code  mainly based on old PA1,PA2A and https://docs.oracle.com/javase/tutorial/networking/sockets/index.html
//https://developer.android.com/reference/java/net/Socket.html
//https://developer.android.com/reference/java/net/ServerSocket.html
//Sockets mainly based on https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoClient.java
//Server Sockets mainly based on https://docs.oracle.com/javase/tutorial/networking/sockets/examples/EchoServer.java

//Socket message passing code mainly base on https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html
//https://docs.oracle.com/javase/7/docs/api/java/io/ObjectInputStream.html

//Debug using Toast, Toast code mainly based on https://developer.android.com/guide/topics/ui/notifiers/toasts.html
//URI,content provider code mainly base on PA1,PA2A.


package edu.buffalo.cse.cse486586.simpledht;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;


public class Handshake implements Serializable {
    //https://developer.android.com/reference/java/io/Serializable.html

    private String msgContent = "";
    //    private double seqNumPrecise = 0.0;
    private int Client_AVD_ID = 0;
    private int Ack = -999;
//    private Cursor pass_query ;

    private int seqNum = -999;
    private String theKEY = "";
    private String theVAL = "";
    private ArrayList<Handshake> theRING= new ArrayList<Handshake>();







    public  ArrayList<Handshake> getRING() {
        return theRING;
    }

    public void setRING( ArrayList<Handshake> temp) {
        this.theRING = temp;
    }


    public Handshake() {
        this.seqNum = seqNum;

    }




    public String getkey() {
        return theKEY;
    }

    public void setkey(String seq) {
        this.theKEY = seq;
    }

    public String getval() {
        return theVAL;
    }

    public void setval(String seq) {
        this.theVAL = seq;
    }


    public int getseq() {
        return seqNum;
    }

    public void setseq(int seq) {
        this.seqNum = seq;
    }



    public int getClient_AVD_ID() {
        return Client_AVD_ID;
    }


    public void setClient_AVD_ID(int msg) {
        this.Client_AVD_ID = msg;
    }


    public int getAck() {
        return Ack;
    }

    public void setAck(int msg) {
        this.Ack = msg;
    }


    public String getmsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msg) {
        this.msgContent = msg;
    }

    //https://developer.android.com/reference/java/util/Comparator.html
    public static Comparator<Handshake> tieBreaker = new Comparator<Handshake>() {

        public int compare(Handshake x, Handshake y) {

//            if (x.getseq() == y.getseq()) { //if two sequence number is the same, place message with the smaller suggesting process ID at the head.
//                return x.getClient_AVD_ID() - y.getClient_AVD_ID();
//            }



            return x.getseq() - y.getseq(); //if two sequence number is not the same, smaller seq # at the head.
        }
    };

    public static Comparator<Handshake> LEX = new Comparator<Handshake>() {

        public int compare(Handshake x, Handshake y) {

//            return Integer.valueOf(x.getkey()) - Integer.valueOf(y.getkey());
            return x.getkey().compareTo(y.getkey());
        }
    };


    public double tieBreaker (int avd_id) {

        double mini = 0.0;

        switch (avd_id) {
            case 0:
                mini = 0.1;


                break;

            case 1:
                mini = 0.2;


                break;

            case 2:
                mini = 0.3;


                break;

            case 3:
                mini = 0.4;


                break;

            case 4:
                mini = 0.5;


                break;
            default:

                mini = 0.0;
                break;

        }
        return mini;
    };

    public int compar_keys(String x, String y) {


        //Return value 0 if the x is equal to this y
        //Return value less than 0 if x is lexicographically less than the y
        //Return value greater than 0 if x is lexicographically greater than the y
        //Source:https://docs.oracle.com/javase/6/docs/api/java/lang/String.html#compareTo%28java.lang.String%29
        return x.compareTo(y);
    }

}










