package com.example.ticket.Info;

/**
 * Created by 张燕华 on 2018/12/25.
 */

public class TicketBuyInfo {
    private int id;//购票编号
    private String traincode;//车次编号
    private String startstation;//出发站
    private String arrivestation;//到达站
    private String starttime;//出发时间
    private String arrivetime;//到达时间
    private String username;//用户名
    private String idcard;//身份证号码
    private double ticketprice;//票价
    private String Date;//日期

    public TicketBuyInfo() {
    }

    public TicketBuyInfo(int id, String traincode, String startstation,
                         String arrivestation, String starttime,
                         String arrivetime, String username, String idcard,
                         double ticketprice, String date) {
        this.id = id;
        this.traincode = traincode;
        this.startstation = startstation;
        this.arrivestation = arrivestation;
        this.starttime = starttime;
        this.arrivetime = arrivetime;
        this.username = username;
        this.idcard = idcard;
        this.ticketprice = ticketprice;
        Date = date;
    }

    @Override
    public String toString() {
        return "TicketBuyInfo{" +
                "id=" + id +
                ", traincode='" + traincode + '\'' +
                ", startstation='" + startstation + '\'' +
                ", arrivestation='" + arrivestation + '\'' +
                ", starttime='" + starttime + '\'' +
                ", arrivetime='" + arrivetime + '\'' +
                ", username='" + username + '\'' +
                ", idcard='" + idcard + '\'' +
                ", ticketprice=" + ticketprice +
                ", Date='" + Date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTraincode() {
        return traincode;
    }

    public void setTraincode(String traincode) {
        this.traincode = traincode;
    }

    public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation;
    }

    public String getArrivestation() {
        return arrivestation;
    }

    public void setArrivestation(String arrivestation) {
        this.arrivestation = arrivestation;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public double getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(double ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
