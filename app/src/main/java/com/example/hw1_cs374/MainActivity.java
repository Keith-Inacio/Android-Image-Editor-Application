package com.example.hw1_cs374;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variables
    private ImageView birdImg, catImg, dogImg, directForward, directBack, directUp, directDown, directPad;
    private TextView birdText, catText, dogText;
    private Button flip, rotate;
    private boolean birdClick, catClick, dogClick;
    private Animation birdMove, catMove, dogMove;
    private int birdX, birdY, catX, catY, dogX, dogY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variable assignments (widgets, buttons, text)
        birdImg = (ImageView) findViewById(R.id.birdImage);
        catImg = (ImageView) findViewById(R.id.catImage);
        dogImg = (ImageView) findViewById(R.id.dogImage);
        birdText = (TextView) findViewById(R.id.birdText);
        catText = (TextView) findViewById(R.id.catText);
        dogText = (TextView) findViewById(R.id.dogText);

        rotate = (Button) findViewById(R.id.rotate);
        flip = (Button) findViewById(R.id.flip);

        directForward = (ImageView) findViewById(R.id.arrowForward);
        directBack = (ImageView) findViewById(R.id.arrowBack);
        directUp = (ImageView) findViewById(R.id.arrowUp);
        directDown = (ImageView) findViewById(R.id.arrowDown);
        directPad = (ImageView) findViewById(R.id.pad);

        //initalize variables for (x, y) coordinates for translation
        birdY = 0;
        birdX = 0;
        catY = 0;
        catX = 0;
        dogY = 0;
        dogX = 0;


        //check if bird image is selected to display bird fact text only
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


        //check if cat image is selected to display cat fact text only
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


        //check if dog image is selected to display dog fact text only
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


        //check which animal image is selected and flip selected image based on scaling (x and y axis values); Error Toast Message
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


        //check which animal image is selected and rotate selected image 90 degrees from current position; Error Toast Message
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


        //check which animal image is selected and move the image 10dp forward(to right); Error Toast Message
        directForward.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (birdClick == true) {
                    birdMove = new TranslateAnimation(birdX, birdX + dpToPx(10), birdY, birdY);
                    birdX = birdX + dpToPx(10);
                    birdMove.setDuration(1000);
                    birdMove.setFillAfter(true);
                    birdImg.startAnimation(birdMove);
                } else if (catClick == true) {
                    catMove = new TranslateAnimation(catX, catX + dpToPx(10), catY, catY);
                    catX = catX + dpToPx(10);
                    catMove.setDuration(1000);
                    catMove.setFillAfter(true);
                    catImg.startAnimation(catMove);
                } else if (dogClick == true) {
                    dogMove = new TranslateAnimation(dogX, dogX + dpToPx(10), dogY, dogY);
                    dogX = dogX + dpToPx(10);
                    dogMove.setDuration(1000);
                    dogMove.setFillAfter(true);
                    dogImg.startAnimation(dogMove);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //check which animal image is selected and move the image 10dp back(to left); Error Toast Message
        directBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (birdClick == true) {
                    birdMove = new TranslateAnimation(birdX, birdX - dpToPx(10), birdY, birdY);
                    birdX = birdX - dpToPx(10);
                    birdMove.setDuration(1000);
                    birdMove.setFillAfter(true);
                    birdImg.startAnimation(birdMove);
                } else if (catClick == true) {
                    catMove = new TranslateAnimation(catX, catX - dpToPx(10), catY, catY);
                    catX = catX - dpToPx(10);
                    catMove.setDuration(1000);
                    catMove.setFillAfter(true);
                    catImg.startAnimation(catMove);
                } else if (dogClick == true) {
                    dogMove = new TranslateAnimation(dogX, dogX - dpToPx(10), dogY, dogY);
                    dogX = dogX - dpToPx(10);
                    dogMove.setDuration(1000);
                    dogMove.setFillAfter(true);
                    dogImg.startAnimation(dogMove);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //check which animal image is selected and move the image 10dp upwards; Error Toast Message
        directUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (birdClick == true) {
                    birdMove = new TranslateAnimation(birdX, birdX, birdY, birdY - dpToPx(10));
                    birdY = birdY - dpToPx(10);
                    birdMove.setDuration(1000);
                    birdMove.setFillAfter(true);
                    birdImg.startAnimation(birdMove);
                } else if (catClick == true) {
                    catMove = new TranslateAnimation(catX, catX, catY, catY - dpToPx(10));
                    catY = catY - dpToPx(10);
                    catMove.setDuration(1000);
                    catMove.setFillAfter(true);
                    catImg.startAnimation(catMove);
                } else if (dogClick == true) {
                    dogMove = new TranslateAnimation(dogX, dogX, dogY, dogY - dpToPx(10));
                    dogY = dogY - dpToPx(10);
                    dogMove.setDuration(1000);
                    dogMove.setFillAfter(true);
                    dogImg.startAnimation(dogMove);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }

            }
        });

        //check which animal image is selected and move the image 10dp downwards; Error Toast Message
        directDown.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (birdClick == true) {
                    birdMove = new TranslateAnimation(birdX, birdX, birdY, birdY + dpToPx(10));
                    birdY = birdY + dpToPx(10);
                    birdMove.setDuration(100);
                    birdMove.setFillAfter(true);
                    birdImg.startAnimation(birdMove);
                } else if (catClick == true) {
                    catMove = new TranslateAnimation(catX, catX, catY, catY + dpToPx(10));
                    catY = catY + dpToPx(10);
                    catMove.setDuration(100);
                    catMove.setFillAfter(true);
                    catImg.startAnimation(catMove);
                } else if (dogClick == true) {
                    dogMove = new TranslateAnimation(dogX, dogX, dogY, dogY + dpToPx(10));
                    dogY = dogY + dpToPx(10);
                    dogMove.setDuration(100);
                    dogMove.setFillAfter(true);
                    dogImg.startAnimation(dogMove);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }


            }
        });

        //return selected animal image to original position upon directional pad click

        directPad.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (birdClick == true) {
                    birdMove = new TranslateAnimation(0, 0, 0, 0);
                    birdX = 0;
                    birdY = 0;
                    birdMove.setDuration(1000);
                    birdMove.setFillAfter(true);
                    birdImg.startAnimation(birdMove);
                } else if (catClick == true) {
                    catMove = new TranslateAnimation(0, 0, 0, 0);
                    catX = 0;
                    catY = 0;
                    catMove.setDuration(1000);
                    catMove.setFillAfter(true);
                    catImg.startAnimation(catMove);
                } else if (dogClick == true) {
                    dogMove = new TranslateAnimation(0, 0, 0, 0);
                    dogX = 0;
                    dogY = 0;
                    dogMove.setDuration(1000);
                    dogMove.setFillAfter(true);
                    dogImg.startAnimation(dogMove);
                } else {
                    Toast.makeText(getApplicationContext(), "ERROR: You must select an image before choosing a transformation!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    //convert dp to pixels for image translation

    public int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, this.getResources().getDisplayMetrics());
    }

}



