package karpenko.learn.learnintests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class JavaGameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.javagamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(JavaGameLevels.this, GameTopic.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }

            }
        });

        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(JavaGameLevels.this,JavaLevel1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(JavaGameLevels.this,JavaLevel2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(JavaGameLevels.this,JavaLevel3.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(JavaGameLevels.this,JavaLevel4.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(JavaGameLevels.this, GameTopic.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }

}