package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.menno.jokedisplayer.JokeActivity;


public class MainActivity extends ActionBarActivity implements IJokeResponse {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnReceiveJoke(String joke)
    {
        Intent intent = new Intent(this, JokeActivity.class);
         intent.putExtra(JokeActivity.EXTRA_MESSAGE, joke);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        GetJokeAsyncTask task = new GetJokeAsyncTask();
        task.delegate = this;
        task.execute();
    }



}
