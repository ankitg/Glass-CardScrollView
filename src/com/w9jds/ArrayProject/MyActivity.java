package com.w9jds.ArrayProject;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;
import java.util.Arrays;

public class MyActivity extends Activity
{
    private ArrayList<View> mlcCards = new ArrayList<View>();
//    private ArrayList<String> mlsText = new ArrayList<String>(Arrays.asList("Hello", "World"));
    private SliderView mProgressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

//        for (int i = 0; i < mlsText.size(); i++)
//        {
//            Card newCard = new Card(this);
//            newCard.setImageLayout(Card.ImageLayout.FULL);
//            newCard.setText(mlsText.get(i));
//            mlcCards.add(newCard);
//        }
        
//        FrameLayout newCard = new FrameLayout(this);
//        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT);
//		newCard.setLayoutParams(params);
//        ImageView iv = new ImageView(this);
//        iv.setBackgroundResource(R.drawable.ic_launcher);
//        newCard.addView(iv);
//        mlcCards.add(newCard);
        
        View newCard = LayoutInflater.from(this).inflate(R.layout.testcard, null);
        mProgressBar = (SliderView) newCard.findViewById(R.id.activity_glass_progress_bar);

        mlcCards.add(newCard);

        CardScrollView csvCardsView = new CardScrollView(this);
        csaAdapter cvAdapter = new csaAdapter();
        csvCardsView.setAdapter(cvAdapter);
        csvCardsView.activate();
        setContentView(csvCardsView);
        mProgressBar.startIndeterminate();
    }

    private class csaAdapter extends CardScrollAdapter
    {
        @Override
        public int getCount()
        {
            return mlcCards.size();
        }

        @Override
        public Object getItem(int position)
        {
            return mlcCards.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            return mlcCards.get(position);//.getView();
        }

        @Override
        public int getPosition(Object o)
        {
            return 0;
        }
    }
}
