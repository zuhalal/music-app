package com.zuhal.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_aboutme -> {
                val intent = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(intent)
            }
        }
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