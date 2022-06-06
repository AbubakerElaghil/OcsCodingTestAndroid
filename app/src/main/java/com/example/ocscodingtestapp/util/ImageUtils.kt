package com.example.ocscodingtestapp.util

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.ocscodingtestapp.R
import com.example.ocscodingtestapp.di.NetworkModule


const val DEFAULT_ATHLETE_IMAGE = R.drawable.ic_default_athlete

fun getAthletePhotoUrl (photoid:Int):String {
    return "${NetworkModule.baseUrl}athletes/$photoid/photo"
}

@Composable
fun loadPicture(url:String,@DrawableRes defaultImage : Int): MutableState<Bitmap?>{


    val bitmapState : MutableState<Bitmap?> = remember{ mutableStateOf(null) }

    Glide.with(LocalContext.current)
        .asBitmap()
        .load(defaultImage)
        .into(object :CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value=resource;
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        } )
    Glide.with(LocalContext.current)
        .asBitmap()
        .load(url)
        .into(object :CustomTarget<Bitmap>(){
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                bitmapState.value=resource;
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                TODO("Not yet implemented")
            }

        } )



    return bitmapState;
}