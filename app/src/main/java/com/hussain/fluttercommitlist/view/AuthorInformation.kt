package com.hussain.fluttercommitlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.model.commitListModel.CommitModelItem

class AuthorInformation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_information)

        val people = intent.getSerializableExtra("CommitModelItem") as? CommitModelItem

        if (people != null) {
            Toast.makeText(this, people.commit.message, Toast.LENGTH_SHORT).show()
        }
    }
}