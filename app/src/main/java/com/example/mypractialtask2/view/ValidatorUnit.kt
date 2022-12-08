package com.example.mypractialtask2.view

object ValidatorUnit {

    fun validateInput(amount:Int, desc:String):Boolean{
        return !(amount<=0 || desc.isNullOrEmpty())
    }
}