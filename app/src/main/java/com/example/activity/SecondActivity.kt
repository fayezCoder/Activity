package com.example.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



/*
قم بعمل واجهه تسجيل دخول باستخدام رقم الهاتف في Main Activity

قم بجعل زر تسجيل الدخول يقوم بنقلك للواجهه التي قمنا بانشائها مسبقامع نقل رقم
الجوال الخاص بالمستخدم في الواجهه الثانيه Second Activity في TextView

في الواجهه الثانيه second Activity
 قم بانشاء زر يقوم بفتح تطبيق الهاتف وضع الرقم الخاص بالمستخدم فيه

 */

class SecondActivity : AppCompatActivity() {

    private var textView : TextView?=null
    private var buttonOpenDial :Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        connectView()
        receiveVariable()
        openDial()
    }
    private fun connectView(){

        textView = findViewById(R.id.tvPhone)
        buttonOpenDial=findViewById(R.id.btnOpenDialer)

    }
    private fun receiveVariable(){
        val i = intent
        val phoneNumber = i.getStringExtra("phone")
        textView?.setText(phoneNumber)

    }
    private fun openDial(){

        buttonOpenDial?.setOnClickListener {

            val i =Intent(Intent.ACTION_DIAL)
            i.data = Uri.parse("tel:${textView?.text}")
            startActivity(i)
        }
    }
}