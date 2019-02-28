package com.example.ticket.Info;

/**
 * Created by 李佳敏 on 2018/12/28.
 */

public class ticket {
    private String TrainCode;//车次
    private String StartStation;//起始站
    private String ArriveStation;//终点站
    private String StartTime;//出发时间
    private String ArriveTime;//到达时间
    private String UseTime;//历时
    private int TicketNum;//余票
    private double TicketPrice;//票价
    private String date;//日期

    public ticket(String trainCode, String startStation, String arriveStation, String startTime,
                  String arriveTime, String useTime, int ticketNum, double ticketPrice, String date) {
        TrainCode = trainCode;
        StartStation = startStation;
        ArriveStation = arriveStation;
        StartTime = startTime;
        ArriveTime = arriveTime;
        UseTime = useTime;
        TicketNum = ticketNum;
        TicketPrice = ticketPrice;
        this.date = date;
    }

    public ticket() {
    }

    public String getTrainCode() {
        return TrainCode;
    }

    public void setTrainCode(String trainCode) {
        TrainCode = trainCode;
    }

    public String getStartStation() {
        return StartStation;
    }

    public void setStartStation(String startStation) {
        StartStation = startStation;
    }

    public String getArriveStation() {
        return ArriveStation;
    }

    public void setArriveStation(String arriveStation) {
        ArriveStation = arriveStation;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getArriveTime() {
        return ArriveTime;
    }

    public void setArriveTime(String arriveTime) {
        ArriveTime = arriveTime;
    }

    public String getUseTime() {
        return UseTime;
    }

    public void setUseTime(String useTime) {
        UseTime = useTime;
    }

    public int getTicketNum() {
        return TicketNum;
    }

    public void setTicketNum(int ticketNum) {
        TicketNum = ticketNum;
    }

    public double getTicketPrice() {
        return TicketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        TicketPrice = ticketPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
