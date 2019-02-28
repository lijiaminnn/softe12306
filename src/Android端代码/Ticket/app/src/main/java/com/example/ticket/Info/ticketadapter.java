package com.example.ticket.Info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ticket.R;

import java.util.List;

/**
 * Created by 李佳敏 on 2018/12/28.
 */

public class ticketadapter extends BaseAdapter{
    public Context con;
    public List<ticket> list;
    public LayoutInflater inflater;

    public ticketadapter(Context con, List<ticket> ticket) {
        this.con = con;
        this.list = ticket;
        inflater = LayoutInflater.from(con);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.query_items,null);
        TextView TrainCode = (TextView)view.findViewById(R.id.TrainCode);
        TextView StartStation = (TextView)view.findViewById(R.id.FirstStation);
        TextView ArriveStation = (TextView)view.findViewById(R.id.LastStation);
        TextView StartTime = (TextView)view.findViewById(R.id.StartTime);
        TextView ArriveTime = (TextView)view.findViewById(R.id.ArriveTime);
        TextView UseTime = (TextView)view.findViewById(R.id.UseTime);
        TextView TicketNum = (TextView)view.findViewById(R.id.leftTicket);
        TextView TicketPrice = (TextView)view.findViewById(R.id.tvPrice);
        TextView datetime = (TextView)view.findViewById(R.id.tv_date);

        TrainCode.setText(list.get(position).getTrainCode());
        StartStation.setText(list.get(position).getStartStation());
        ArriveStation.setText(list.get(position).getArriveStation());
        StartTime.setText(list.get(position).getStartTime());
        ArriveTime.setText(list.get(position).getArriveTime());
        UseTime.setText(list.get(position).getUseTime());
        TicketNum.setText("余票:"+list.get(position).getTicketNum());
        TicketPrice.setText("票价:"+list.get(position).getTicketPrice());
        datetime.setText("日期:"+list.get(position).getDate());

        return view;
    }
}
