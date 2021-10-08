package karpenko.learn.learnintests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameTopic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_topic_universal);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back_to_start);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(GameTopic.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }

            }
        });

        TextView textView1 = (TextView)findViewById(R.id.textViewNumbersLevels);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameTopic.this,JavaGameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView5 = (TextView)findViewById(R.id.textViewMeal);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameTopic.this,MealGameLevels.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameTopic.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

}