package com.hitanshudhawan.spannablestringparser.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hitanshudhawan.spannablestringparser.spannify
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_text.addTextChangedListener {
            text_view.text = it.spannify()
        }
    }

}
