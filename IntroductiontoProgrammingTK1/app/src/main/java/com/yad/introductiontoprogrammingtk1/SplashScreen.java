package com.yad.introductiontoprogrammingtk1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashScreen extends AppCompatActivity {
    Thread splashTread;
    LinearLayout LL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        LL = (LinearLayout) findViewById(R.id.lin_lay);
        Spash();
    }

    private void Spash() {
        splashTread = new Thread() {
            @Override
            public void run() {
                try {

                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                    LL.startAnimation(animation);
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 700) {
                        sleep(1000);
                        waited += 100;
                    }

                    //checkState();
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    SplashScreen.this.finish();

                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();
    }
}
