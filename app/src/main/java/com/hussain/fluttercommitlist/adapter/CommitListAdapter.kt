package com.hussain.fluttercommitlist.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.hussain.fluttercommitlist.R
import com.hussain.fluttercommitlist.model.commitListModel.CommitModel
import com.hussain.fluttercommitlist.model.commitListModel.CommitModelItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.commit_list_item.view.*
import java.util.ArrayList

class CommitListAdapter(
    val activity: Activity,
    private val listener: OnItemClickListener): RecyclerView.Adapter<CommitListAdapter.CommitListViewHolder>() {

    private var commitModel: List<CommitModelItem> = ArrayList()

    interface OnItemClickListener {
        fun onItemClick(data: CommitModelItem)
    }

    fun setCommitList(commitModel: List<CommitModelItem>?) {
        this.commitModel = commitModel!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.commit_list_item, parent, false)

        return CommitListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommitListViewHolder, position: Int) {
        commitModel?.let { holder.bind(it[position], listener) }
    }

    override fun getItemCount(): Int {
        if(commitModel == null){
            return 0
        }
        if (commitModel?.size!! > 10){
            return 10
        }
        return commitModel?.size!!
    }

    inner class CommitListViewHolder (view: View): RecyclerView.ViewHolder(view){

        private val commitMessage: TextView = view.commit_message
        private val commitTime: TextView = view.commit_time
        private val authorName: TextView = view.author_name
        private val authorAvatar: ShapeableImageView = view.author_avatar

        fun bind(data: CommitModelItem, listener: OnItemClickListener){
            Picasso.get().load(data.author.avatarUrl).into(authorAvatar);
            commitMessage.text = data.commit.message
            commitTime.text = data.commit.author.date
            authorName.text = data.commit.author.name

            itemView.setOnClickListener{listener.onItemClick(data)}
        }
    }
}