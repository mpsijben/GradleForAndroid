package com.menno.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Menno on 9-12-2015.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = getActivity().getIntent();
        String message = intent.getStringExtra(JokeActivity.EXTRA_MESSAGE);
        TextView textview = (TextView) view.findViewById(R.id.tb_joke);
        textview.setText(message);

        return view;
    }
}