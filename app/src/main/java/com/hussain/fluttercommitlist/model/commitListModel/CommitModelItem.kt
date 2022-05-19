package com.hussain.fluttercommitlist.model.commitListModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CommitModelItem(
    @SerializedName("author")
    val author: Author,
    @SerializedName("commit")
    val commit: Commit
): Serializable