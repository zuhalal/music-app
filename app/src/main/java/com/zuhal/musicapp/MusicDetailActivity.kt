package com.zuhal.musicapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zuhal.musicapp.databinding.ActivityMusicDetailBinding
import com.zuhal.musicapp.utils.Utils

class MusicDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicDetailBinding

    companion object {
        const val EXTRA_INDEX = "extra_index"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // calling the action bar
        val actionBar = supportActionBar

        // showing the back button in action bar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = "Music Details"
        }

        val music = MusicData.listData[intent.getIntExtra(EXTRA_INDEX, 0)]

        val image: ImageView = binding.ivAlbum
        Glide.with(this).load(music.images).into(image)

        changeText(music)

        val btn: Button = binding.actionShare
        btn.setOnClickListener {
            val openURL = Intent(Intent.ACTION_SEND)
            openURL.apply {
                putExtra(Intent.EXTRA_TEXT, music.song_url)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(openURL, null)
            startActivity(shareIntent)
        }
    }

    private fun changeText(music: Music) {
        binding.apply {
            tvArtist.text = music.artists
            tvSongTitle.text = music.title
            tvBigTitle.text = music.title
            tvLabel.text = music.label
            tvGenres.text = music.genres
            tvDuration.text = Utils.convertMinutes(music.duration.toInt())
            tvReleaseDate.text = music.release_date
            tvPlayCount.text = music.play_count
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}