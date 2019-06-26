package com.github.scrobot.coctaildb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.scrobot.coctaildb.R
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity

class MainActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
