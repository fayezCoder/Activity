package com.example.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

/*قم بصميم واجهه تحتوي على 2 عنصر
قم بجعل الزر الاول يقوم بنقلك للواجهة التي قمنا بانشاءها مسبقا
قم بجعل الزر الثاني يقوم بفتح تطبيق جهات الاتصال

 */

class MainActivity : AppCompatActivity() {

    var editTextPhone:EditText?=null
    var buttonLogin:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectView()
        openActivity() // Explicit intent
         //implicit intent

    }
    private fun connectView(){
        editTextPhone = findViewById(R.id.etPhone)
        buttonLogin = findViewById(R.id.btnLogin)
    }
    private fun openActivity(){

        buttonLogin?.setOnClickListener {
            val phoneText = editTextPhone?.text.toString()
            val i = Intent(this,SecondActivity::class.java)
            //               TAG     Value
            i.putExtra("phone",phoneText)
            startActivity(i)
        }
    }


}

