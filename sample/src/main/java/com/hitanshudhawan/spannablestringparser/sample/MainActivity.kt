package com.hitanshudhawan.spannablestringparser.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.LinkMovementMethod
import com.hitanshudhawan.spannablestringparser.spannify
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s1 = "Hello { `World` < text-color:#FF00FF /> }"
        val s2 = "Hello { `World` < text-color:#44FF00FF /> }"
        val s3 = "Hello { `World` < background-color:#FF00FF /> }"
        val s4 = "Hello { `World` < background-color:#44FF00FF /> }"
        val s5 = "Hello { `World` < line-background-color:#FF00FF /> }"
        val s6 = "Hello { `World` < line-background-color:#44FF00FF /> }"
        val s7 = "Hello { `World` < text-size:24dp /> }"
        val s8 = "Hello { `World` < text-size:2.4em /> }"
        val s9 = "Hello { `World` < text-size:24px /> }"
        val s10 = "Hello { `World` < text-decoration:underline /> }"
        val s11 = "Hello { `World` < text-decoration:strike-through /> }"
        val s12 = "Hello { `World` < subscript:true /> }"
        val s13 = "Hello { `World` < superscript:true /> }"
        val s14 = "Hello { `World` < text-style:normal /> }"
        val s15 = "Hello { `World` < text-style:bold /> }"
        val s16 = "Hello { `World` < text-style:italic /> }"
        val s17 = "Hello { `World` < font-family:monospace /> }"
        val s18 = "Hello { `World` < font-family:serif /> }"
        val s19 = "Hello { `World` < font-family:sans-serif /> }"
        val s20 = "{ `Hello World` < text-alignment:normal /> }"
        val s21 = "{ `Hello World` < text-alignment:opposite /> }"
        val s22 = "{ `Hello World` < text-alignment:center /> }"
        val lorem_ipsum = "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        val s23 = "{ `${lorem_ipsum}` < line-height:120px /> }"
        val s24 = "click { `here` < url:`https://www.google.com` /> } for more information"
        text_view.text = s24.spannify()
        text_view.movementMethod = LinkMovementMethod.getInstance()
    }

}
