package com.erkanceylan.match_watcher_v_01;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.erkanceylan.match_watcher_v_01.Adapters.LeagueListAdapter;
import com.erkanceylan.match_watcher_v_01.Models.League;
import com.erkanceylan.match_watcher_v_01.Querys.Query;
import com.erkanceylan.match_watcher_v_01.Querys.QueryBuilder;
import com.erkanceylan.match_watcher_v_01.Utilities.JsonToObject;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

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
    private String leagueJson;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new LeagueCreator().execute();
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

    public void ShowLeagues()
    {
            leagueList = JsonToObject.GetLeaguesFromJson(leagueJson);
            LeagueListAdapter adapter=new LeagueListAdapter(this,R.layout.league_list_layout,R.id.textView, leagueList);
            leagueListView.setAdapter(adapter);
            leagueListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                League league=leagueList.get(position);
                Toast.makeText(getApplicationContext(),league.getLeagueName(), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(), LeagueTabbedActivity.class);
                intent.putExtra("LeagueAbrevation",league.getLeagueAbrevation());
                Log.e("INTENT: ","Çalıştı");
                startActivity(intent);
            }
        });
    }
    class LeagueCreator extends AsyncTask<String, Void, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            String xAuthToken="757f3cedfc534a7e8f728788cb8f6473";
            String xResponseControl="minified";
            String url="http://api.football-data.org";

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url+"/v1/competitions").addHeader("X-Auth-Token",xAuthToken)
                    .addHeader("X-Response-Control",xResponseControl)
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        @Override
        protected void onPostExecute(String json)
        {
            leagueJson=json;
            ShowLeagues();
        }
    }
}
