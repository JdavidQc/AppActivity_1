package com.example.yape;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    RadioButton  codi0,codi1,codi2,codi3,codi4,codi5;
    String codigo;
    RadioButton[] codi;
    ImageView delete;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codi = new RadioButton[6];
        codigo="";
        ArrayList<Integer> list = new ArrayList<>();
        btn0 =  findViewById(R.id.btn0);
        btn1 =  findViewById(R.id.btn1);
        btn2 =  findViewById(R.id.btn2);
        btn3 =  findViewById(R.id.btn3);
        btn4 =  findViewById(R.id.btn4);
        btn5 =  findViewById(R.id.btn5);
        btn6 =  findViewById(R.id.btn6);
        btn7 =  findViewById(R.id.btn7);
        btn8 =  findViewById(R.id.btn8);
        btn9 =  findViewById(R.id.btn9);

        codi0 = findViewById(R.id.codi_1);
        codi1 = findViewById(R.id.codi_2);
        codi2 = findViewById(R.id.codi_3);
        codi3 = findViewById(R.id.codi_4);
        codi4 = findViewById(R.id.codi_5);
        codi5 = findViewById(R.id.codi_6);

        delete =findViewById(R.id.delete);
        Button[] btn = {btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
        codi[0]=codi0;
        codi[1]=codi1;
        codi[2]=codi2;
        codi[3]=codi3;
        codi[4]=codi4;
        codi[5]=codi5;


        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        delete.setOnClickListener(this);



        this.Reset(list,btn);




    }

    @Override
    public void onClick(View view) {
        if(view.findViewById(R.id.btn0) == btn0){
            ClickButtonClave(btn0);
            //  Toast.makeText(MainActivity.this,btn0.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn1) == btn1){
            ClickButtonClave(btn1);
            // Toast.makeText(MainActivity.this,btn1.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn2) == btn2){
            ClickButtonClave(btn2);
            //   Toast.makeText(MainActivity.this,btn2.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn3) == btn3){
            ClickButtonClave(btn3);
            //  Toast.makeText(MainActivity.this,btn3.getText(),Toast.LENGTH_SHORT).show();

        } if(view.findViewById(R.id.btn4) == btn4){
            ClickButtonClave(btn4);
            //  Toast.makeText(MainActivity.this,btn4.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn5) == btn5){
            ClickButtonClave(btn5);
            //   Toast.makeText(MainActivity.this,btn5.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn6) == btn6){
            ClickButtonClave(btn6);
            //   Toast.makeText(MainActivity.this,btn6.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn7) == btn7){
            ClickButtonClave(btn7);
            //  Toast.makeText(MainActivity.this,btn7.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn8) == btn8){
            ClickButtonClave(btn8);
            // Toast.makeText(MainActivity.this,btn8.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.btn9) == btn9){

            ClickButtonClave(btn9);
            //  Toast.makeText(MainActivity.this,btn9.getText(),Toast.LENGTH_SHORT).show();

        }
        if(view.findViewById(R.id.delete) == delete){
            codigo= codigo.substring(0,codigo.length()-1);
            delete();
        }
    }

    private void ClickButtonClave(Button btn){
        if(check()){
            codigo +=btn.getText();
        }
        if(codigo.length() == 6){
            mensajeToast(this.codigo);
        }
    }

    private boolean check(){
        for (RadioButton r:codi) {
            if(!r.isChecked()){
                r.setEnabled(true);
                r.setChecked(true);
            return true;
            }

        }
        return false;
    }
    private void delete(){
        for (int i=codi.length-1;i>=0;i--){
            if(codi[i].isChecked()){
                codi[i].setEnabled(false);
                codi[i].setChecked(false);
                break;
            }
        }
    }
    private void mensajeToast(String msj){
        Toast.makeText(MainActivity.this,msj,Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    private void Reset(ArrayList<Integer> list, Button[] btn){
        Random rd = new Random();
        for (RadioButton r:codi) {
            r.setEnabled(false);
            r.setChecked(false);

        }
        int i=0;
        while (!(i == 10)){
            int num =rd.nextInt(10);
            if(!list.contains(num)){
                list.add(num);
                btn[i].setText(list.get(i)+"");
                i++;
            }
        }
    }
}