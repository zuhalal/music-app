package com.zuhal.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MusicDetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_INDEX = "extra_index"
    }

    fun convertMinutes(second: Int): String {
        val minutes: Int = (second % 3600) / 60
        val seconds: Int = (second % 3600)% 60
        return "${minutes}:${seconds}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)

        // calling the action bar
        var actionBar = getSupportActionBar()

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "Music Details"
        }

        val music = MusicData.listData[intent.getIntExtra(EXTRA_INDEX, 0)]
//        Log.d("index: " , "${MusicData.listData[intent.getIntExtra(EXTRA_INDEX, 0)].artists}")

        val image: ImageView = findViewById(R.id.iv_album)
        Glide.with(this).load(music.images).into(image)

        val artist: TextView = findViewById(R.id.tv_artist)
        artist.text = music.artists

        val title: TextView = findViewById(R.id.tv_song_title)
        title.text = music.title

        val bigTitle: TextView = findViewById(R.id.tv_big_title)
        bigTitle.text = music.title

        val label: TextView = findViewById(R.id.tv_label)
        label.text = music.label

        val genres: TextView = findViewById(R.id.tv_genres)
        genres.text = music.genres

        val duration: TextView = findViewById(R.id.tv_duration)
        duration.text = convertMinutes(music.duration.toInt())

        val btn: Button = findViewById(R.id.btn_share)
        btn.setOnClickListener({
            val openURL = Intent(android.content.Intent.ACTION_SEND)
            openURL.putExtra(Intent.EXTRA_TEXT, music.song_url)
            openURL.setType("text/plain")

            val shareIntent = Intent.createChooser(openURL, null)
            startActivity(shareIntent)
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}