package com.example.assignment10

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock.sleep
import android.provider.MediaStore
import android.view.View
import android.widget.GridView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignment10.databinding.ActivityMainBinding
import org.jetbrains.anko.*
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val REQUEST_READ_EXTERMAL_STORAGE = 1000
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding.progressBar.visibility= View.INVISIBLE
        binding.progressBar.visibility=View.VISIBLE
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                alert("외부저장소 권한을 허용하시겠습니까?","권한이 필요한 이유"){
                    yesButton {
                        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        REQUEST_READ_EXTERMAL_STORAGE)
                    }
                    noButton {  }
                }.show()
            } else{
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_READ_EXTERMAL_STORAGE)
            }
        } else{
            getAllPhotos()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_READ_EXTERMAL_STORAGE->{
                if((grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED)){
                    getAllPhotos()
                } else{
                    toast("권한 거부 됨")
                }
                return
            }
        }
    }

    private fun getAllPhotos() {
        var uriArrayList = ArrayList<String>()
            val cursor = contentResolver.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, null, null, MediaStore.Images.ImageColumns.DATE_TAKEN)
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    val uri = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA))
                    uriArrayList.add(uri)
                }
                cursor.close()
                thread {
                    sleep(1000L)
                    binding.progressBar.visibility=View.INVISIBLE
                    val intent = Intent(this,GalleryActivity::class.java)
                    intent.putExtra("urlList",uriArrayList)
                    startActivity(intent)
                    finish()
                }
        }
    }
}