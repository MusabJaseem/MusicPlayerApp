package musabporche.gmail.com.listapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPlayer();
            }
        });

        Intent in = getIntent();
        //Which activity to display, at which index
        int index = in.getIntExtra("musabporche.gmail.com.ITEM_INDEX", -1);

        //scale image
        /*if(index > -1){
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }*/
    }
    public void openActivityPlayer(){
        Intent intent = new Intent(this, Player.class);
        startActivity(intent);
    }
    //set image that we want
    /*private int getImg(int index){
        switch(index){
            case 0: return R.drawable.peachf;
            case 1: return R.drawable.tomatof;
            case 2: return R.drawable.squashf;
            default: return -1;
        }
    }*/

    //scale image
    /*private void scaleImg(ImageView img, int pic){

        Display screen = getWindowManager().getDefaultDisplay(); //size of screen we are dealing with
        BitmapFactory.Options options = new BitmapFactory.Options(); // gives access to a java library class that scales images

        options.inJustDecodeBounds = true; //turn on boundaries, determine the boundaries
        BitmapFactory.decodeResource(getResources(), pic, options); //get the images resources, dimensions, without actually drawing it. saves memory

        //get image width/height and compare with screen
        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth){
            int ratio = Math.round((float)imgWidth / (float)screenWidth);
            options.inSampleSize = ratio; //set scale factor of new bitMap we are going to draw
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);
    }*/
}
