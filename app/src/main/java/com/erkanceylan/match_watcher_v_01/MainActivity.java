package com.erkanceylan.match_watcher_v_01;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.erkanceylan.match_watcher_v_01.Adapters.LeagueListAdapter;
import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Querys.QueryCreator;
import com.erkanceylan.match_watcher_v_01.Querys.QueryStringBuilder;
import com.erkanceylan.match_watcher_v_01.Utilities.JsonToObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private ListView leagueListView;

    private TextView editText;

    //Json verisinden çekilip ayıklanacak ve ListView'de gösterilecek olan League nesne listesi.
    private ArrayList<League> leagueList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        QueryCreator query=new QueryCreator();
        try
        {
            query.run(QueryStringBuilder.getAllLeague(), new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e)
                        {
                            //TODO: Can't create handler inside thread that has not called Looper.prepare()
                            Toast.makeText(getApplicationContext(),"AGA OLAY VAR",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException
                        {
                            final String leagueJson=response.body().string();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run()
                                {
                                    ShowLeagues(leagueJson);
                                }
                            });
                        }
                    }
                    );
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Queryy","Çağırılıyor");
        }
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
        editText=(TextView)findViewById(R.id.mainText);
        leagueListView=(ListView)findViewById(R.id.leaguesListView);
    }

    public void ShowLeagues(String leagueJson)
    {
        if(leagueJson==null)return;

        leagueList = JsonToObject.GetLeaguesFromJson(leagueJson);
        LeagueListAdapter adapter=new LeagueListAdapter(this,R.layout.league_list_layout,R.id.textView, leagueList);
        leagueListView.setAdapter(adapter);

        leagueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                League league=leagueList.get(position);
                Toast.makeText(getApplicationContext(),league.getLeagueName(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(), LeagueTabbedActivity.class);
                Bundle packet=new Bundle();
                packet.putString("id",Integer.toString(league.getId()));
                packet.putInt("currentMatchday",league.getCurrentMatchDay());
                packet.putString("LeagueAbrevation",league.getLeagueAbrevation());
                packet.putString("LeagueName",league.getLeagueName());
                intent.putExtras(packet);
                Log.e("INTENT: ","Çalıştı");
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_bottom);
            }
        });
    }
}
