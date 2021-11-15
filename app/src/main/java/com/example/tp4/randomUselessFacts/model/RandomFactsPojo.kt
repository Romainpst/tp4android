package com.example.tp4.randomUselessFacts.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for Ui */
data class RandomFactsUi(
    val quote: String
)


/** Object use for room */
@Entity(tableName = "random_useless_facts")
data class RandomFactsRoom(
    @ColumnInfo(name = "quote_text")
    val quote: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class RandomFactsRetrofit(
    @Expose
    @SerializedName("text")
    val quote: String
)