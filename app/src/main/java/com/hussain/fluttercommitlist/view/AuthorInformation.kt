package com.hussain.fluttercommitlist.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.model.commitListModel.CommitModelItem
import com.hussain.fluttercommitlist.viewModel.AuthorInfoViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_author_information.*
import java.net.URL


class AuthorInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_information)

        val people = intent.getSerializableExtra("CommitModelItem") as? CommitModelItem

        if (people == null) {
            Toast.makeText(this, "Unable to retrieve information", Toast.LENGTH_SHORT).show()
        }

        getAuthorInformation(people);
    }

    private fun getAuthorInformation(people: CommitModelItem?) {

        val viewModel: AuthorInfoViewModel = ViewModelProvider(this).get(AuthorInfoViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){

                Picasso.get().load(it.avatarUrl).into(author_avatar);

                author_name.text = it.name
                author_id.text = "@"+it.login
                bio.text = "Bio: "+it.bio
                pub_gist.text = "Public Repos: "+it.publicGists.toString()
                pub_repo.text = "Public Gists"+it.publicRepos.toString()
                pri_repo.text = "Private Repos: 0"
                Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(people?.author?.url!!)
    }
}