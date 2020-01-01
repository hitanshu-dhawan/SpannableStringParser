package com.hitanshudhawan.spannablestringparser.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.LinkMovementMethod
import android.text.style.*
import com.hitanshudhawan.spannablestringparser.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spanner { property, value ->

            when (property) {
                "sub-script" -> if (value == "true") return@spanner SubscriptSpan()
                "super-script" -> if (value == "true") return@spanner SuperscriptSpan()
            }

            return@spanner null
        }

        val s1 = "Hello { `Hitanshu` < color : #0000ff ; font-style : italic ; font-weight : bold ; font-size : 1.5em ; text-decoration-line : underline | line-through /> }!"
        val s2 = "C{`8`<sub-script:true/>}H{`10`<sub-script:true/>}N{`4`<sub-script:true/>}O{`2`<sub-script:true/>}"
        val s3 = "a{`2`<super-script:true;font-size:0.5em/>} + b{`2`<super-script:true;font-size:0.5em/>} = c{`2`<super-script:true;font-size:0.5em/>}"
        val s4 = "Click { `here` < href : `http://www.hitanshudhawan.com` /> }."
        textView.text = s4.spannify()
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

}
