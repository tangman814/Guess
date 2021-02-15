package com.samtang.guess

import java.util.*

// 定對物件導向的物件(Class) SecretNumber
class SecretNumber {
    //val 定義secret為不可變的變數,型態為Int, 並直接取得亂數10以內的整數, 因為取出是0~9,所以要加 1
    //val secret:Int = Random().nextInt(10)+1
    //var 定對count為可改變的變數,型態為Int, 初始值為 0
    //var count:Int = 0

    //Kotlin 為自動判斷右方的型態,故可不用指定型態
    val secret = Random().nextInt(10)+1
    var count = 0

    fun validate(number:Int):Int {
        count++
        return number-secret
    }
}

fun main(){
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.validate(2)}, count: ${secretNumber.count}")
}