package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b_.*

class b_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_)
        var num:String = ""
        var num1:String =""
        var num2:String =""
        var total:String = ""
        var operator: String =""
        var operatorFinal: String =""
        var count = operator.length
       one.setOnClickListener {
            num=textView2.text.toString()
           count = operator.length
           if(num=="0"||count==1) {
               textView2.setText("1")
               operator = ""
           }
           else
                textView2.setText(num+"1")
       }
        two.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("2")
                operatorFinal=operator
                operator = ""
            }
            else
                textView2.setText(num+"2")
        }
        three.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("3")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"3")
        }
        four.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("4")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"4")
        }
        five.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("5")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"5")
        }
        six.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("6")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"6")
        }
        seven.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("7")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"7")
        }
        eight.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("8")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"8")
        }
        nine.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num=="0"||count==1) {
                textView2.setText("9")
                operatorFinal=operator
                operator = ""
            }
            else
            textView2.setText(num+"9")
        }
        zero.setOnClickListener {
            num=textView2.text.toString()
            count = operator.length
            if(num!="0"||count==1) {
                textView2.setText(num + "0")
                operatorFinal=operator
                operator = ""
            }
        }
        cancel.setOnClickListener {
            if(textView2.length()>0)
                textView2.setText(textView2.text.subSequence(0,textView2.length()-1))
            else{
                num=""
                total=""
                operator=""
                operatorFinal=""
                num1=""
                num2=""
            }
        }
        plus.setOnClickListener {
            num1=textView2.text.toString()
            textView2.setText("+")
            operator=textView2.text.toString()

        }
        minus.setOnClickListener {
            num1=textView2.text.toString()
            textView2.setText("-")
            operator=textView2.text.toString()
        }
        multiply.setOnClickListener {
            num1=textView2.text.toString()
            textView2.setText("*")
            operator=textView2.text.toString()
        }
        division.setOnClickListener {
            num1=textView2.text.toString()
            textView2.setText("/")
            operator=textView2.text.toString()
        }

        equal.setOnClickListener {
            num2=textView2.text.toString()
            if(operatorFinal=="+"){
                total=(num1.toInt()+num2.toInt()).toString()
                textView2.setText(total)
            }
            else if(operatorFinal=="-"){
                total=(num1.toInt()-num2.toInt()).toString()
                textView2.setText(total)
            }
            else if(operatorFinal=="/"){
                total=(num1.toInt()/num2.toInt()).toString()
                textView2.setText(total)
            }
            else{
                total=(num1.toInt()*num2.toInt()).toString()
                textView2.setText(total)
            }
        }
    }
}

