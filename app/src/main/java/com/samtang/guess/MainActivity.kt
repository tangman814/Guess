package com.samtang.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    //將SecretNubmer物件生成.
    val secretNumber = SecretNumber()
    //固定TAG字串,以利後方的Log.d(可以代入) --手動輸入ManinActivity
    //val TAG = "MainActivity"
    //固定TAG字串,以利後方的Log.d(可以代入) --自動代入Class名稱
    val TAG = MainActivity::class.java.simpleName
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.linear_main)
        Log.d(TAG, "secret : ${secretNumber.secret}")

    }

    //需傳入View物件
    fun check(view: View){
        val n = number.text.toString().toInt()
        println("number : $n")
        Log.d(TAG, "number : $n")

        val diff = secretNumber.validate(n)
        //var message = "Yes, You got it"
        //將顯示的字串抽取(Extract string Resource)成資源檔(string.xml)內容
        var message = getString(R.string.yes_you_get_it)

        if (diff < 0) {
            //message = "Bigger"
            message = getString(R.string.bigger)
        } else if (diff > 0){
            //message = "Small"
            message = getString(R.string.smaller)
        }
        //Toast 代入參數的 context 用 this , 最後要有.show() 才會顯示在畫面上
        //Toast.makeText(this,message, Toast.LENGTH_LONG).show()
        //產生訊息視窗以下為一行式的寫法, 但不易讀
        //AlertDialog.Builder(this).setTitle("Message").setMessage(message).setPositiveButton("OK",null).show()
        //產生訊息視窗以下為易讀的寫法
        AlertDialog.Builder(this)   //產生訊息視窗
                //.setTitle("Message")      //設定訊息視窗抬頭
                .setTitle(getString(R.string.dialog_title)) //將顯示的字串抽取(Extract string Resource)成資源檔(string.xml)內容
                .setMessage(message)        //設定訊息視窗內文
                //.setPositiveButton("OK",null)   //設定訊息視窗內按鈕
                .setPositiveButton(getString(R.string.ok),null) //將顯示的字串抽取(Extract string Resource)成資源檔(string.xml)內容
                .show()                     //顯示訊息視窗

        number.text.clear()
    }
}