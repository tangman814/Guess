package com.samtang.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val secretNumber = SecretNumber()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.linear_main)
        Log.d("MainActivity", "secret : ${secretNumber.secret}")

    }

    //需傳入View物件
    fun check(view: View){
        val n = number.text.toString().toInt()
        println("number : $n")
        Log.d("MainActivity", "number : $n")

        val diff = secretNumber.validate(n)
        var message = "Yes , You got it"

        if (diff < 0) {
            message = "Bigger"
        } else if (diff > 0){
            message = "Smaller"
        }
        //Toast 代入參數的 context 用 this , 最後要有.show() 才會顯示在畫面上
        //Toast.makeText(this,message, Toast.LENGTH_LONG).show()
        //產生訊息視窗以下為一行式的寫法, 但不易讀
        //AlertDialog.Builder(this).setTitle("Message").setMessage(message).setPositiveButton("OK",null).show()
        //產生訊息視窗以下為易讀的寫法
        AlertDialog.Builder(this)   //產生訊息視窗
                .setTitle("Message")        //設定訊息視窗抬頭
                .setMessage(message)        //設定訊息視窗內文
                .setPositiveButton("OK",null)   //設定訊息視窗內按鈕
                .show()                     //顯示訊息視窗

        number.text.clear()
    }
}