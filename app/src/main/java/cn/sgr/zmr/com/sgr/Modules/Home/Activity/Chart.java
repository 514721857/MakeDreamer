package cn.sgr.zmr.com.sgr.Modules.Home.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sgr.zmr.com.sgr.R;

public class Chart extends Activity {

    // 高温线下标
    private final int HIGH = 0;

    // 低温线下标
    private final int LOW = 1;

    @BindView(R.id.charts)
    LineChart mChart;

    @BindView(R.id.top_view_back)
    ImageView top_view_back;

    @BindView(R.id.iv_right)
    ImageView iv_right;


    @BindView(R.id.top_view_right_text)
    TextView top_view_right_text;

    @BindView(R.id.top_view_left_text)
    TextView top_view_left_text;

    @BindView(R.id.top_view_title)
    TextView top_view_title;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        ButterKnife.bind(this);
        intitView();
        initialChart(mChart);
        addLineDataSet(mChart);



    }

    private void intitView() {
        top_view_title.setText("体温历史记录");
        top_view_back.setVisibility(View.VISIBLE);
        top_view_left_text.setVisibility(View.GONE);
        iv_right.setImageResource(R.drawable.btn_share_friend);
        iv_right.setVisibility(View.VISIBLE);
        top_view_right_text.setVisibility(View.GONE);

    }
        @OnClick({R.id.top_view_back,R.id.iv_right})
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.top_view_back:
                  finish();
                    break;

                case R.id.iv_right:
                    Toast.makeText(Chart.this,"分享",Toast.LENGTH_LONG).show();
                    break;
            }
        }
    // 初始化图表
    private void initialChart(LineChart mChart) {
        mChart.setDescription(" ");
        mChart.setNoDataTextDescription("暂时尚无数据");
        mChart.setTouchEnabled(true);
        // 可拖曳
        mChart.setDragEnabled(true);
        // 可缩放
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setPinchZoom(true);
        // 设置图表的背景颜色
        mChart.setBackgroundColor(0xfff5f5f5);
        // 图表的注解(只有当数据集存在时候才生效)
        Legend l = mChart.getLegend();

        // 可以修改图表注解部分的位置
        // l.setPosition(LegendPosition.LEFT_OF_CHART);

        // 线性，也可是圆
        l.setForm(LegendForm.LINE);

        // 颜色
        l.setTextColor(ContextCompat.getColor(Chart.this,R.color.them_bg));
        // x坐标轴
        XAxis xl = mChart.getXAxis();
//        xl.setTextColor(0xff00897b);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setAxisMaxValue(24f);
        xl.setAxisMinValue(0f);


        // 几个x坐标轴之间才绘制？
//        xl.setSpaceBetweenLabels(5);
//        xl.set
        // 如果false，那么x坐标轴将不可见
        xl.setEnabled(true);

        // 将X坐标轴放置在底部，默认是在顶部。
        xl.setPosition(XAxisPosition.BOTTOM);

        // 图表左边的y坐标轴线
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTextColor(0xff37474f);

        // 最大值
        leftAxis.setAxisMaxValue(45f);

        // 最小值
        leftAxis.setAxisMinValue(35f);

        // 不一定要从0开始
        leftAxis.setStartAtZero(false);

        leftAxis.setDrawGridLines(true);

        YAxis rightAxis = mChart.getAxisRight();
        // 不显示图表的右边y坐标轴线
        rightAxis.setEnabled(false);
    }

    // 为LineChart增加LineDataSet
    private void addLineDataSet(LineChart mChart) {
        LineData data =getData(10,2);
        mChart.setData(data);
    }
    private LineData getData(int count, float range) {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range) + 37;
            yVals.add(new Entry(i, val));
        }
        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, "时间体温");
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);
        set1.setLineWidth(1.75f);
        set1.setCircleRadius(5f);
        set1.setCircleHoleRadius(2.5f);
        set1.setColor( ContextCompat.getColor(Chart.this,R.color.them_bg));
        set1.setCircleColor( ContextCompat.getColor(Chart.this,R.color.them_bg));//圆圈的颜色
        set1.setLabel("时间体温");
//        set1.setHighLightColor(Color.RED);
        set1.setDrawValues(false);
        // create a data object with the datasets
        LineData data = new LineData(set1);
        return data;
    }
}