package org.techtown.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Chat extends AppCompatActivity {

    private EditText inputForm;
    private TextView result; //결과(대답)
    private TextView mytext;//입력결과
    private Button send; //보내기버튼
    private Button wifi;//와이파이
    private Button toilet; //화장실
    private Button menu; //추천
    ImageView imageView1;
    ImageView nextcosmos;
    ImageView white;

    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();

        imageView1=findViewById(R.id.imageView1);
        nextcosmos=findViewById(R.id.nextcosmos);
        white =findViewById(R.id.white);
        setTitle("CHAT");
    }

    private void init() {
        inputForm =findViewById(R.id.editText);
        result = findViewById(R.id.textView_result);
        send = findViewById(R.id.button_send);
        mytext = findViewById(R.id.textView_send);
        wifi = findViewById(R.id.pw);
        toilet = findViewById(R.id.to);
        menu = findViewById(R.id.con);

        buttonAction();
    }

    private void buttonAction() {

        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
                String resultData= "Wifi 비밀번호는 1234입니다.";
                result.setText(resultData);
                String sendData = "Wifi 비밀번호가 무엇인가요?";
                mytext.setText(sendData);

            }
        });

        toilet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
                String resultData= "화장실은 나가서 우측에 있습니다. 비밀번호는 1004입니다.";
                result.setText(resultData);
                String sendData = "화장실 위치와 비밀번호는 무엇인가요?";
                mytext.setText(sendData);

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
                String resultData= Select();
                result.setText(resultData);
                String sendData = "메뉴추천 해주세요!";
                mytext.setText(sendData);

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
                String currentData = inputForm.getText().toString();
                //inputFrom에서 데이터 가져와서 String형태로 currentData에 담아준다.
                String resultData = null;
                String sendData = null;
                if("화장실 비밀번호".equals(currentData)){
                    resultData = "1234";
                    sendData = currentData;
                } else {
                    resultData="죄송합니다. 질문을 이해하지 못했어요!";
                }
                result.setText(resultData);
                //result를 받아온다,
                mytext.setText(currentData);
            }
        });
    }
    private void changeImage(){
        if(i==0){
            white.setVisibility(View.VISIBLE);
            nextcosmos.setVisibility(View.INVISIBLE);
            i=1;
        } else if(i==1){
            nextcosmos.setVisibility(View.VISIBLE);
            white.setVisibility(View.INVISIBLE);
        }
    }
    private String Select(){
        String[] list={"아이스 아메리카노","카페라떼","청포도 에이드","스파클링 레몬"};
        Random random=new Random();
        String select = list[random.nextInt(list.length)];

        return select;
    }

    //홈버튼
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent homeIntent = new Intent(this, MenuActivity.class);
            startActivity(homeIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}