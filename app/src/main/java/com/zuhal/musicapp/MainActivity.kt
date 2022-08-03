package com.zuhal.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMusic: RecyclerView
    private var list: ArrayList<Music> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMusic = findViewById(R.id.rv_music)
        rvMusic.setHasFixedSize(true)

        list.addAll(MusicData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listMusicAdapter = ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapter
    }
}