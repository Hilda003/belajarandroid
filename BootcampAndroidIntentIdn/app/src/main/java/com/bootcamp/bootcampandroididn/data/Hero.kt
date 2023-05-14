package com.bootcamp.bootcampandroididn.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
	var nama: String,
	var description: String,
	var photo: Int
):Parcelable
