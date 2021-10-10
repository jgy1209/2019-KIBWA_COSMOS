package org.techtown.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LF3 extends AppCompatActivity
{
    TextView name, menu1,menu2,menu3,tvtel,tvaddress,tvdate;
    ImageView imageView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lf3);
        setTitle("정보 상세보기");
        name = (TextView)findViewById(R.id.txtname);
        menu1 = (TextView)findViewById(R.id.etmenu1);
        tvtel = (TextView)findViewById(R.id.tvTel);
        tvaddress = (TextView)findViewById(R.id.tvURL);
        tvdate = (TextView)findViewById(R.id.tvRegdate);
        back = (Button)findViewById(R.id.btnback) ;
        imageView = (ImageView)findViewById(R.id.imgno);
        Intent intent = getIntent();
        LOST res = intent.getParcelableExtra("restinfo");

        name.setText(res.getName());
        menu1.setText(res.getmenu1());
        tvtel.setText(res.getTel());
        tvdate.setText(res.getDate());
        tvaddress.setText(res.getHomepage());
        if(res.getCategorynum() == 1) // 치킨
        {
            imageView.setImageResource(R.drawable.phone);
        }
        else if (res.getCategorynum() == 2) //피자
        {
            imageView.setImageResource(R.drawable.wallet);
        }
        else //햄버거
        {
            imageView.setImageResource(R.drawable.ellipsis);
        }
    }

    public void onClick(View v)
    {
        Intent intent = getIntent();
        LOST res = intent.getParcelableExtra("restinfo");
        switch (v.getId())
        {
            case R.id.btnback:
                finish();
                break;
        }
    }
}
