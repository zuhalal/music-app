package com.zuhal.musicapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MusicDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_INDEX = "extra_index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)
        val music = MusicData.listData[intent.getIntExtra(EXTRA_INDEX, 0)]
        Log.d("index: " , "${MusicData.listData[intent.getIntExtra(EXTRA_INDEX, 0)].artists}")

        val image: ImageView = findViewById(R.id.iv_album)
        Glide.with(this).load(music.images).into(image)

        val artist: TextView = findViewById(R.id.tv_artist)
        artist.text = music.artists

        val title: TextView = findViewById(R.id.tv_song_title)
        title.text = music.title

        val label: TextView = findViewById(R.id.tv_label)
        label.text = music.label

        val genres: TextView = findViewById(R.id.tv_genres)
        genres.text = music.genres

        val duration: TextView = findViewById(R.id.tv_duration)
        duration.text = "${music.duration} seconds"
    }
}