package com.example.assignment9.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.assignment9.R
import com.google.firebase.auth.GoogleAuthProvider
import java.io.File
import java.text.SimpleDateFormat

class MainViewModel: ViewModel() {
        fun putJpgFile():String{
            val simpleDataFormat = SimpleDateFormat(R.string.filename.toString())
            val fileName = simpleDataFormat.format(System.currentTimeMillis())
            return "${fileName}.jpg"
        }

}