package com.hussain.fluttercommitlist.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.model.commitListModel.CommitModelItem
import com.hussain.fluttercommitlist.viewModel.AuthorInfoViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_author_information.*


class AuthorInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_author_information)

        val commitModelItem = intent.getSerializableExtra("CommitModelItem") as? CommitModelItem

        if (commitModelItem == null) {
            Toast.makeText(this, "Unable to retrieve information", Toast.LENGTH_SHORT).show()
        }

        getAuthorInformation(commitModelItem);
    }

    private fun getAuthorInformation(commitModelItem: CommitModelItem?) {

        val viewModel: AuthorInfoViewModel = ViewModelProvider(this).get(AuthorInfoViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){

                Picasso.get().load(it.avatarUrl).into(author_avatar);

                author_name.text = it.name
                author_id.text = "@"+it.login
                bio.text = "Bio: "+it.bio
                pub_gist.text = "Public Repos: "+it.publicGists.toString()
                pub_repo.text = "Public Gists: "+it.publicRepos.toString()
                pri_repo.text = "Private Repos: 0"
            }else{
            }
        })
        viewModel.makeApiCall(commitModelItem?.author?.url!!)
    }
}