package com.example.asus.monisan.v.fragment;


import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;

import com.example.asus.monisan.R;
import com.example.asus.monisan.m.model.VideoModel;
import com.example.asus.monisan.p.VideoPresenter;
import com.example.base.BaseFragment;
import com.example.base.mvp.BaseModel;

public class Fragmentvideo extends BaseFragment implements View.OnClickListener  {

    ImageButton btnplay, btnstop, btnpause;
    SurfaceView surfaceView;
    MediaPlayer mediaPlayer;
    int position;

    @Override
    protected int bindLayoutId() {
        return R.layout.fragmentfirst;
    }
    @Override
    protected VideoPresenter initPresenter() {
        return new VideoPresenter();
    }

    @Override
    protected BaseModel initModel() {
        return new VideoModel();
    }

    @Override
    protected void initView(View view) {
        btnplay=(ImageButton)view.findViewById(R.id.btnplay);
        btnstop=(ImageButton)view.findViewById(R.id.btnstop);
        btnpause=(ImageButton)view.findViewById(R.id.btnpause);
        surfaceView=(SurfaceView) view.findViewById(R.id.surfaceView);

        btnstop.setOnClickListener(this);
        btnplay.setOnClickListener(this);
        btnpause.setOnClickListener(this);
    }


    @Override
    protected void initData() {
        mediaPlayer=new MediaPlayer();

        //设置SurfaceView自己不管理的缓冲区
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (position>0) {
                    try {
                        play();
                        mediaPlayer.seekTo(position);
                        position=0;
                    } catch (Exception e) {
                    }
                }
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
            }
        });

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.btnplay:
                play();
                break;

            case R.id.btnpause:
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.pause();
                }
                else
                {
                    mediaPlayer.start();
                }
                break;

            case R.id.btnstop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                break;
            default:
                break;
        }

    }
    @Override
    public void onPause() {
        if (mediaPlayer.isPlaying()) {
            position=mediaPlayer.getCurrentPosition();
            mediaPlayer.stop();
        }
        super.onPause();
    }

    private void play() {
        try {
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource("mnt/sdcard/Movies/oppo2.MP4");
            mediaPlayer.setDisplay(surfaceView.getHolder());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
        }
    }

}
