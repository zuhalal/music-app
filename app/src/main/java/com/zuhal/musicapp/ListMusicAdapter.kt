package com.zuhal.musicapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListMusicAdapter(private val listMusic: ArrayList<Music>):
    RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Music, index: Int)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvArtist: TextView = itemView.findViewById(R.id.tv_artist)
        var tvSongTitle: TextView = itemView.findViewById(R.id.tv_song_title)
        var tvAlbum: TextView = itemView.findViewById(R.id.tv_album)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_music, parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val music = listMusic[position]

        Glide.with(holder.itemView.context)
            .load(music.images)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvSongTitle.text = music.title
        holder.tvArtist.text = "Artist: ${music.artists}"
        holder.tvAlbum.text = "Album: ${music.album}"
        holder.itemView.setOnClickListener({onItemClickCallback.onItemClicked(listMusic[holder.adapterPosition], holder.adapterPosition)})
    }

    override fun getItemCount(): Int {
        return listMusic.size
    }
}