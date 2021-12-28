package com.irfan.moviedbapp.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var movieId: Int,
    var title: String,
    var description: String,
    var originalLanguage: String,
    var releaseYear: String,
    var voteAverage: Double,
    var posterPath: String,
): Parcelable