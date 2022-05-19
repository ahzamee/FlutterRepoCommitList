package com.hussain.fluttercommitlist.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.adapter.CommitListAdapter
import com.hussain.fluttercommitlist.model.commitListModel.CommitModelItem
import com.hussain.fluttercommitlist.util.Constant.base_url_commit
import com.hussain.fluttercommitlist.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var commitListAdapter: CommitListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initViewModel(){

        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getLiveDataObserver().observe(this, Observer {
            if (it != null){
                val commitList: List<CommitModelItem> = filterCommits(it)
                showData(commitList)
                Toast.makeText(this, "worked", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(base_url_commit)
    }

    private fun filterCommits(it: ArrayList<CommitModelItem>): List<CommitModelItem> {

        var dataList: List<CommitModelItem> = ArrayList<CommitModelItem>()
        var data: ArrayList<CommitModelItem> = ArrayList<CommitModelItem>()

        it.forEach {
            if(!it.commit.author.name.contains("x")){
                if(!it.commit.author.name.contains("g"))
                    data.add(it)
            }
        }
        dataList = data
        return dataList
    }

    private fun showData(it: List<CommitModelItem>) {
        commitListAdapter.setCommitList(it)
        commitListAdapter.notifyDataSetChanged()
    }

    private fun initRecyclerView() {
        var listener = object : CommitListAdapter.OnItemClickListener {
            override fun onItemClick(data: CommitModelItem) {
                Toast.makeText(this@MainActivity, data.commit.message, Toast.LENGTH_SHORT).show()
                var intent = Intent(this@MainActivity, AuthorInformation::class.java)
                intent.putExtra("CommitModelItem", data)
                startActivity(intent)
            }
        }
        commit_list_view.layoutManager = LinearLayoutManager(this)
        commitListAdapter = CommitListAdapter(this,listener)
        commit_list_view.adapter = commitListAdapter

        commit_list_view.addItemDecoration(
            DividerItemDecoration(
                baseContext,
                LinearLayoutManager(this).orientation
            )
        )
    }

}