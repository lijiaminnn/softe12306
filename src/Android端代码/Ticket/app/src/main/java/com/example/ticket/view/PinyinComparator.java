package com.example.ticket.view;

import java.util.Comparator;

/**
 * Created by 张燕华 on 2018/12/25.
 * 用来对ListView中的数据根据A-Z进行排序，前两个if判断主要是将
 * 不是以汉字开头的数据之类的放在后面
 */

public class PinyinComparator implements Comparator<CitySortModel> {
    /**
	 *getSortLetters()获取显示数据拼音的首字母
	 *@param CitySortModel o1 参数1
	 *@param CitySortModel o2 参数2
	 *@return 返回值1 -1 当o1或o2的选择为“@”或“#”时
	 *@return 返回值2 返回的时o1和o2的相对比值
	 */

    public int compare(CitySortModel o1, CitySortModel o2){
        //用来对ListView里面的数据根据A-Z来排序
        if (o1.getSortLetters().equals("@") || o2.getSortLetters().equals("#")){
            return -1;
        }
        else if (o1.getSortLetters().equals("#") || o2.getSortLetters().equals("@")){
            return -1;
        }
        else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }
    }
}
