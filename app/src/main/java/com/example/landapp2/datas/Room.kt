package com.example.landapp2.datas

import java.io.Serializable
import java.text.NumberFormat
import java.util.*

class Room(
    val price: Int,
    val address: String,
    val floor: Int,
    val description: String): Serializable {

    fun getFormattedFloor(): String {

        if(this.floor >= 1) {
            return "${this.floor}층"
        }
        else if(this.floor == 0) {
            return "반지하"
        }
        else {
            return "지하 ${-this.floor}층"
        }
    }

    fun getFormattedPrice() : String {

        if(this.price >= 10000){

//            정수와 정수의 나눗셈은 소수점은 버리고 몫만 남긴다
            val uk = this.price / 10000
            val rest = this.price % 10000

            return "${uk}억 ${NumberFormat.getNumberInstance(Locale.KOREA).format(rest)}"
        }
        else {

//            원래 1억 미만의 방들만 오는 분기
            return "${NumberFormat.getNumberInstance(Locale.KOREA).format(this.price)}"
        }
    }
}