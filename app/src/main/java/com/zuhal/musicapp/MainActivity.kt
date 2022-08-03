package com.zuhal.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

    private fun showSelectedMusic(music: Music) {
        Toast.makeText(this, "Kamu memilih " + music.title, Toast.LENGTH_SHORT).show()
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listMusicAdapter = ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapter

        listMusicAdapter.setOnItemClickCallback(object: ListMusicAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Music, index: Int) {
                showSelectedMusic(data)
                val intent = Intent(this@MainActivity, MusicDetailActivity::class.java)
                intent.putExtra(MusicDetailActivity.EXTRA_INDEX, index)
                startActivity(intent)
            }
        })
    }
}