package com.erkanceylan.match_watcher_v_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init()
    {
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent gecis=new Intent(getApplicationContext(), LeagueTabbedActivity.class);
                button.setText("Çalıştı");
                Log.i("Çalıştı","Çalıştı");
                startActivity(gecis);
            }
        });
    }
}
