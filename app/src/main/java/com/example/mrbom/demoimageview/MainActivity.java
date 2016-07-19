package com.example.mrbom.demoimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button btnChange;

    private boolean isChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
        init();

        //load image online
        Picasso.with(this).load("http://sohanews2.vcmedia.vn/2013/midu-1379672386061.jpg")
                .into(imageView);

        //add listener
        addListener();
    }

    private void addListener(){
        btnChange.setOnClickListener(this);
    }

    private void init() {
        imageView = (ImageView) findViewById(R.id.picture);
        btnChange = (Button) findViewById(R.id.btn_change);

        //
        isChange = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change: {
                if (!isChange) {
                    imageView.setImageResource(R.mipmap.pic2);
                    isChange = true;
                } else {
                    imageView.setImageResource(R.mipmap.pic);
                    isChange = false;
                }
                break;
            }
            default:
                break;
        }
    }
}
