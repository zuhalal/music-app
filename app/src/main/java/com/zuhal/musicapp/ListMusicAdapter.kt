package com.zuhal.musicapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zuhal.musicapp.databinding.ItemRowMusicBinding

class ListMusicAdapter(private val listMusic: ArrayList<Music>):
    RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: Music, index: Int)
    }

    class ListViewHolder(var binding: ItemRowMusicBinding) : RecyclerView.ViewHolder(binding.root) {}

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val music = listMusic[position]

        Glide.with(holder.itemView.context)
            .load(music.images)
            .apply(RequestOptions().override(55,55))
            .into(holder.binding.imgItemPhoto)

        holder.binding.apply {
            tvSongTitle.text = music.title
            tvArtist.text = "Artist: ${music.artists}"
            tvAlbum.text = "Album: ${music.album}"
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listMusic[holder.adapterPosition],
                holder.adapterPosition
            )
        }
    }

    override fun getItemCount(): Int {
        return listMusic.size
    }
}