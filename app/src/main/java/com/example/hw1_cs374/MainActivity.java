package com.example.hw1_cs374;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView birdImg, catImg, dogImg;
    private TextView birdText, catText, dogText;
    private Button flip, rotate;
    //private ImageButton rotateForward, rotateBack, rotateUp, rotateDown;
    private boolean birdClick, catClick, dogClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birdImg = (ImageView) findViewById(R.id.birdImage);
        catImg = (ImageView) findViewById(R.id.catImage);
        dogImg = (ImageView) findViewById(R.id.dogImage);
        birdText = (TextView) findViewById(R.id.birdText);
        catText = (TextView) findViewById(R.id.catText);
        dogText = (TextView) findViewById(R.id.dogText);

        rotate = (Button) findViewById(R.id.rotate);
        flip = (Button) findViewById(R.id.flip);
/*
        rotateForward = (ImageButton) findViewById(R.id.translateForward);
        rotateBack = (ImageButton) findViewById(R.id.translateBack);
        rotateUp = (ImageButton) findViewById(R.id.translateUp);
        rotateDown = (ImageButton) findViewById(R.id.translateDown);
*/

        birdImg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                birdClick = true;
                catClick = false;
                dogClick = false;
                birdText.setVisibility(View.VISIBLE);
                catText.setVisibility(View.INVISIBLE);
                dogText.setVisibility(View.INVISIBLE);
            }

        });

        catImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catClick = true;
                birdClick = false;
                dogClick = false;
                birdText.setVisibility(View.INVISIBLE);
                catText.setVisibility(View.VISIBLE);
                dogText.setVisibility(View.INVISIBLE);
            }
        });

        dogImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dogClick = true;
                birdClick = false;
                catClick = false;
                birdText.setVisibility(View.INVISIBLE);
                catText.setVisibility(View.INVISIBLE);
                dogText.setVisibility(View.VISIBLE);
            }


        });

        flip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (birdClick == true) {
                    if (birdImg.getScaleY() == 1 && birdImg.getScaleX() == 1) {
                        birdImg.setScaleX(-1f);
                    } else if (birdImg.getScaleY() == 1 && birdImg.getScaleX() == -1) {
                        birdImg.setScaleX(1f);
                    }
                    if (birdImg.getScaleY() == -1 && birdImg.getScaleX() == 1) {
                        birdImg.setScaleY(-1f);
                    } else if (birdImg.getScaleY() == -1 && birdImg.getScaleX() == -1) {
                        birdImg.setScaleY(1f);
                    }
                } else if (catClick == true) {

                    if (catImg.getScaleY() == 1 && catImg.getScaleX() == 1) {
                        catImg.setScaleX(-1f);
                    } else if (catImg.getScaleY() == 1 && catImg.getScaleX() == -1) {
                        catImg.setScaleX(1f);
                    }
                    if (catImg.getScaleY() == -1 && catImg.getScaleX() == 1) {
                        catImg.setScaleY(-1f);
                    } else if (catImg.getScaleY() == -1 && catImg.getScaleX() == -1) {
                        catImg.setScaleY(1f);
                    }
                } else if (dogClick == true) {

                    if (dogImg.getScaleY() == 1 && dogImg.getScaleX() == 1) {
                        dogImg.setScaleX(-1f);
                    } else if (dogImg.getScaleY() == 1 && dogImg.getScaleX() == -1) {
                        dogImg.setScaleX(1f);
                    }
                    if (dogImg.getScaleY() == -1 && dogImg.getScaleX() == 1) {
                        dogImg.setScaleY(-1f);
                    } else if (dogImg.getScaleY() == -1 && dogImg.getScaleX() == -1) {
                        dogImg.setScaleY(1f);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }
            }
        });

        rotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (birdClick == true) {
                    birdImg.setRotation(birdImg.getRotation() + 90);
                } else if (catClick == true) {

                    catImg.setRotation(catImg.getRotation() + 90);
                } else if (dogClick == true) {
                    dogImg.setRotation(dogImg.getRotation() + 90);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}



