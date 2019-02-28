package com.example.ticket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticket.R;
import com.example.ticket.view.CityAdapter;
import com.example.ticket.view.CitySortModel;
import com.example.ticket.view.PinyinComparator;
import com.example.ticket.view.PinyinUtils;
import com.example.ticket.view.SideBar;
import com.example.ticket.view.SortAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 对EditTextWithDel设置addTextChangedListener监听，当输入框内容发生变化根据里面的值过滤ListView，
 * 里面的值为空显示原来的列表
 * 给ListView添加表头...
 *
 */

public class ChooseStationActivity extends AppCompatActivity {
    private ListView sortListView;
    private SideBar sideBar;
    private TextView dialog,mTvTitle;
    private SortAdapter adapter;
    private EditText mEtCityName;
    private List<CitySortModel> SourceDateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_station);
        initViews();
    }
    private void initViews(){
        mEtCityName = (EditText)findViewById(R.id.et_search);
        sideBar = (SideBar) findViewById(R.id.sidrbar);
        dialog = (TextView)findViewById(R.id.dialog);
        mTvTitle = (TextView)findViewById(R.id.tv_title);
        sortListView = (ListView)findViewById(R.id.country_lvcountry);
        initDatas();

        setAdapter();
        initEvents();

    }


    private void setAdapter(){
        SourceDateList = filledData(getResources().getStringArray(R.array.all_cities));
        Collections.sort(SourceDateList, new PinyinComparator());
        adapter = new SortAdapter(this, SourceDateList);
        sortListView.addHeaderView(initHeadView());
        sortListView.setAdapter(adapter);
    }

    private void initEvents(){
        //设置右侧触摸监听
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = adapter.getPositionForSection(s.charAt(0));
                if (position != -1){
                    sortListView.setSelection(position+1);
                }
            }
        });

        /**
		 *ListView的点击事件
		 */
        sortListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTvTitle.setText(((CitySortModel)adapter.getItem(position-1)).getName());
                Toast.makeText(getApplication(),((CitySortModel)adapter.
                        getItem(position-1)).getName(),Toast.LENGTH_SHORT).show();

                //数据用intent返回
                Intent intent = new Intent();
                //把返回数据存入Intent
                intent.putExtra("result",((CitySortModel)adapter.getItem(position-1)).getName());
                //设置返回数据
                ChooseStationActivity.this.setResult(RESULT_OK,intent);
                //关闭Activity
                ChooseStationActivity.this.finish();
            }
        });

        /**根据输入框输入值的改变来过滤搜索*/
        mEtCityName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initDatas(){
        sideBar.setTextView(dialog);
    }
	/**
	 *初始热门城市栏
	 */
    private View initHeadView(){
        View headView = getLayoutInflater().inflate(R.layout.headview, null);
        GridView mGvCity = (GridView) headView.findViewById(R.id.gv_hot_city);
        String[] datas = getResources().getStringArray(R.array.city);
        ArrayList<String> cityList = new ArrayList<>();
        for (int i = 0; i<datas.length; i++){
            cityList.add(datas[i]);
        }
        CityAdapter adapter = new CityAdapter(getApplicationContext(),
                R.layout.gridview_item,cityList);
        mGvCity.setAdapter(adapter);
        return headView;
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *@param filterStr
     */
    private void filterData(String filterStr){
        List<CitySortModel> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)){
            mSortList = SourceDateList;
        }
        else {
            mSortList.clear();;
            for (CitySortModel sortModel:SourceDateList){
                String name = sortModel.getName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 ||
                        PinyinUtils.getPinYin(name).toUpperCase().startsWith(filterStr.toString().
                                toUpperCase())){
                    mSortList.add(sortModel);
                }
            }
        }
        /**根据a-z进行排序*/
        Collections.sort(mSortList, new PinyinComparator());
        adapter.upddateListView(mSortList);
    }

    /**
	 *根据A-Z进行排序依次显示城市名称
	 *@param date数组
	 *@return mSortList
	 */
    private List<CitySortModel> filledData(String[] date){
        List<CitySortModel> mSortList = new ArrayList<>();
        ArrayList<String> indexString = new ArrayList<>();

        for (int i = 0; i<date.length; i++){
            CitySortModel sortModel = new CitySortModel();
            sortModel.setName(date[i]);
            String pinyin = PinyinUtils.getPinYin(date[i]);
            String sortString = pinyin.substring(0,1).toUpperCase();
            if (sortString.matches("[A-Z]")){
                sortModel.setSortLetters(sortString.toUpperCase());
                if (!indexString.contains(sortString)){
                    indexString.add(sortString);
                }
            }
            mSortList.add(sortModel);
        }
        Collections.sort(indexString);
        sideBar.setIndexText(indexString);
        return mSortList;
    }
}
