 package com.saadahmedev.hpcapi.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saadahmedev.hpcapi.R
import com.saadahmedev.hpcapi.ui.dashboard.DashboardActivity
import com.saadahmedev.hpcapi.helper.delay
import com.saadahmedsoft.shortintent.Anim
import com.saadahmedsoft.shortintent.ShortIntent

 @SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delay(1500) {
            ShortIntent.getInstance(this)
                .addDestination(DashboardActivity::class.java)
                .addTransition(Anim.FADE)
                .finish(this)
        }
    }
}