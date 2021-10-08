package karpenko.learn.learnintests;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MealLevel1 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft;// Змінна для лівої картинки
    public int numRight;// Змінна для правої картинки
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_universal);

        TextView text_levels = findViewById(R.id.java_text_levels);
        text_levels.setText(R.string.level1);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left); // Заокруглення кутів лівої картинки
        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right); // Заокруглення кутів правої картинки
        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);

        final TextView text_right = findViewById(R.id.text_right);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// Відображення на весь екран

        ImageView background = (ImageView)findViewById(R.id.java_background);
        background.setImageResource(R.drawable.meallevel1);

        dialog = new Dialog(this);// Створюємо нове діалогове вікно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Приховуємо заголовок
        dialog.setContentView(R.layout.previewdialog); // Шлях до макету діалогового вікна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозорий фон діалогового вікна
        dialog.setCancelable(false); // Вікно не можна закрити кнопкою 'Назад'

        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.mealpreviewimg1);

        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.mealpreviewbackground1);

        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.meallevelone);


        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MealLevel1.this,MealGameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialog.dismiss();
            }
        });

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show(); // Показ діалогового вікна

        //-------------------------------

        dialogEnd = new Dialog(this);// Створюємо нове діалогове вікно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // Приховуємо заголовок
        dialogEnd.setContentView(R.layout.dialogend); // Шлях до макету діалогового вікна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозорий фон діалогового вікна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false); // Вікно не можна закрити кнопкою 'Назад'

        LinearLayout dialogfonEnd = (LinearLayout)dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.mealpreviewbackground1);

        TextView textDescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textDescriptionEnd.setText(R.string.mealleveloneEnd);

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MealLevel1.this,MealGameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });

        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(MealLevel1.this, MealGameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //
                }
                dialogEnd.dismiss();
            }
        });
        //____________________________________________

        Button btnback = (Button)findViewById(R.id.java_lvl1_btn_back);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MealLevel1.this, MealGameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        final int[] progress = {
                R.id.point1,R.id.point2,R.id.point3,R.id.point4,
                R.id.point5,R.id.point6,R.id.point7,R.id.point8,
                R.id.point9,R.id.point10,R.id.point11,R.id.point12,
                R.id.point13,R.id.point14,R.id.point15,R.id.point16,
                R.id.point17,R.id.point18,R.id.point19,R.id.point20
        };

        final Animation a = AnimationUtils.loadAnimation(MealLevel1.this,R.anim.alpha);// Підключення анімації


        numLeft = random.nextInt(20);// Генеруємо випадкове число від 0 до 9
        img_left.setImageResource(array.mealimages1[numLeft]); // Дістаємо з масиву відповідну картинку
        text_left.setText(array.mealtext1[numLeft]);

        numRight = random.nextInt(20);// Генеруємо випадкове число від 0 до 9

        while (array.strong[numLeft]==array.strong[numRight] ){
            numRight = random.nextInt(20);
        }

        img_right.setImageResource(array.mealimages1[numRight]); // Дістаємо з масиву відповідну картинку
        text_right.setText(array.mealtext1[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    img_right.setEnabled(false);
                    if(array.strong[numLeft]>array.strong[numRight]){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    if(array.strong[numLeft]>array.strong[numRight]){
                        if(count<20){
                            count = count+1;
                        }
                        for(int i=0;i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else {
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                            count=count-1;
                            }
                        }
                        for(int i=0;i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if(count==20){
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(20);// Генеруємо випадкове число від 0 до 9
                        img_left.setImageResource(array.mealimages1[numLeft]); // Дістаємо з масиву відповідну картинку
                        text_left.setText(array.mealtext1[numLeft]);

                        numRight = random.nextInt(20);// Генеруємо випадкове число від 0 до 9

                        while (array.strong[numLeft]==array.strong[numRight] ){
                            numRight = random.nextInt(20);
                        }

                        img_right.setImageResource(array.mealimages1[numRight]); // Дістаємо з масиву відповідну картинку
                        text_right.setText(array.mealtext1[numRight]);

                        img_right.setEnabled(true);
                    }
                }
                return true;
            }
        });

        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    img_left.setEnabled(false);
                    if(array.strong[numLeft]<array.strong[numRight]){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    if(array.strong[numLeft]<array.strong[numRight]){
                        if(count<20){
                            count = count+1;
                        }
                        for(int i=0;i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else {
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-1;
                            }
                        }
                        for(int i=0;i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for(int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }
                    if(count==20){
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(20);// Генеруємо випадкове число від 0 до 9
                        img_left.setImageResource(array.mealimages1[numLeft]); // Дістаємо з масиву відповідну картинку
                        text_left.setText(array.mealtext1[numLeft]);

                        numRight = random.nextInt(20);// Генеруємо випадкове число від 0 до 9

                        while (array.strong[numLeft]==array.strong[numRight] ){
                            numRight = random.nextInt(20);
                        }

                        img_right.setImageResource(array.mealimages1[numRight]); // Дістаємо з масиву відповідну картинку
                        text_right.setText(array.mealtext1[numRight]);

                        img_left.setEnabled(true);
                    }
                }
                return true;
            }
        });

    }
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(MealLevel1.this, JavaGameLevels.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

}