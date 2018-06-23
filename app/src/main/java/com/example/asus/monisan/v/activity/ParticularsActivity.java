package com.example.asus.monisan.v.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.bean.AddBean;
import com.example.asus.monisan.m.bean.ParticularsBean;
import com.example.asus.monisan.m.model.ParticularsModel;
import com.example.asus.monisan.m.netUtil.BannerImageLoader;
import com.example.asus.monisan.p.ParticularsPresenter;
import com.example.asus.monisan.v.interfaces.ParticularsInterface;
import com.example.base.BaseActivity;
import com.example.base.mvp.BaseModel;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.youth.banner.Banner;

import java.util.Arrays;

public class ParticularsActivity extends BaseActivity<ParticularsPresenter> implements ParticularsInterface {


    Banner particularsImg;
    TextView particularsTex;
    TextView particularsPrice;
    Button particularsTiaozhuan;
    Button particularsTianjia;
    Button particularsBuy;
    private ImageLoader imageLoader;


    @Override
    protected BaseModel initModel() {
        return new ParticularsModel();
    }

    @Override
    protected ParticularsPresenter initPresenter() {
        return new ParticularsPresenter();
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_particulars;
    }

    @Override
    protected void initView() {
        particularsPrice = findViewById(R.id.particulars_price);
        particularsImg= findViewById(R.id.particulars_img);
        particularsTex=findViewById(R.id.particulars_tex);
        particularsTianjia=findViewById(R.id.particulars_tianjia);
        particularsTiaozhuan=findViewById(R.id.particulars_tiaozhuan);
        particularsBuy=findViewById(R.id.particulars_buy);

    }

    @Override
    protected void initData() {

        final int pid = getIntent().getIntExtra("Pid", 2);
        presenter.PParticulars(pid + "");


        particularsTianjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PAdd(pid+"");
            }
        });
        particularsTiaozhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ParticularsActivity.this, CarListActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onParticularsSuccess(ParticularsBean particularsBean) {
        String price = particularsBean.getData().getPrice();
        String title = particularsBean.getData().getTitle();
        String images = particularsBean.getData().getImages();

        String[] image = images.split("\\|");

        imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(ParticularsActivity.this));
        particularsImg.setImageLoader(new BannerImageLoader());
        //设置图片集合
        particularsImg.setImages(Arrays.asList(image));
        //banner设置方法全部调用完毕时最后调用
        particularsImg.setDelayTime(2000);
        particularsImg.isAutoPlay(true);
        particularsImg.start();

        particularsTex.setText(title);
        particularsPrice.setText(price + "");
    }

    @Override
    public void onaddSuccess(AddBean addBean) {
        Toast.makeText(ParticularsActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
    }
}
