package com.example.thebasics;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TutorialThree extends Activity implements OnClickListener {

	ImageView display;
	int toPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);
		
		toPhone = R.drawable.back_black;
		
		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1),
				image2 = (ImageView) findViewById(R.id.IVimage2),
				image3 = (ImageView) findViewById(R.id.IVimage3),
				image4 = (ImageView) findViewById(R.id.IVimage4),
				image5 = (ImageView) findViewById(R.id.IVimage5),
				image6 = (ImageView) findViewById(R.id.IVimage6);
		
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);
		
		image1.setOnClickListener(this);		
		image2.setOnClickListener(this);		
		image3.setOnClickListener(this);		
		image4.setOnClickListener(this);		
		image5.setOnClickListener(this);		
		image6.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.IVimage1:
			display.setImageResource(R.drawable.back_black);
			toPhone = R.drawable.back_black;
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.back_blue);
			toPhone = R.drawable.back_blue;
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.back_logo);
			toPhone = R.drawable.back_logo;
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.back_nikola);
			toPhone = R.drawable.back_nikola;
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.back_red);
			toPhone = R.drawable.back_red;
			break;
		case R.id.IVimage6:
			display.setImageResource(R.drawable.back_white);
			toPhone = R.drawable.back_white;
			break;
		case R.id.BsetWallpaper:
			InputStream yeaaaa = getResources().openRawResource(toPhone);
			Bitmap whatever = BitmapFactory.decodeStream(yeaaaa);
			
			WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
			
			try{
				//deprecated
				//getApplicationContext().setWallpaper(whatever);
				manager.setBitmap(whatever);
			}
			catch(IOException e) {
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), "Failed to set the wallpaper", Toast.LENGTH_LONG).show();
			}
			break;
		}
	}

}
