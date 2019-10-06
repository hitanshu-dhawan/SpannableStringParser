package com.hitanshudhawan.spannablestringparser.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hitanshudhawan.spannablestringparser.spannify
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s = "Hello { `Hitanshu` < color : #0000ff ; font-style : italic ; font-weight : bold ; font-size : 1.5em /> }!"
        textView.text = s.spannify()
    }

}