package com.example.ticket.Info;

/**
 * Created by 张燕华 on 2018/12/25.
 */

public class TicketInfo {
    private String TrainCode;//车次编码
    private String StartStation;//始发站
    private String ArriveStation;//到达站
    private String StartTime;//出发时间
    private String ArriveTime;//到达时间
    private String UseTime;//历时
    private int TicketNum;//余票
    private double TicketPrice;//票价
    private String date;//日期

    public TicketInfo() {
    }

    public TicketInfo(String trainCode, String startStation,
                      String arriveStation, String startTime, String arriveTime,
                      String useTime, int ticketNum, double ticketPrice,
                      String date) {
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

    @Override
    public String toString() {
        return "TicketInfo{" +
                "TrainCode='" + TrainCode + '\'' +
                ", StartStation='" + StartStation + '\'' +
                ", ArriveStation='" + ArriveStation + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", ArriveTime='" + ArriveTime + '\'' +
                ", UseTime='" + UseTime + '\'' +
                ", TicketNum=" + TicketNum +
                ", TicketPrice=" + TicketPrice +
                ", date='" + date + '\'' +
                '}';
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
