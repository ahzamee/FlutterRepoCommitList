package com.hussain.fluttercommitlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.util.Constant.base_url_commit
import com.hussain.fluttercommitlist.viewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    private fun initViewModel(){

        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show()
                it[0].commit.message
                Log.d("aaaaaaaaa",it[0].commit.message)
            }else{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                Log.d("aaaaaaaaa","failed")
            }
        })

        viewModel.makeApiCall(base_url_commit)
    }
}