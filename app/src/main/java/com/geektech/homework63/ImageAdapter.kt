package com.geektech.homework63

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(val list: ArrayList<Int>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    lateinit var clickListener: ClickListener

    fun setOnClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ImageViewHolder(
            layoutInflater.inflate(R.layout.item_images, parent, false),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        (holder).bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ImageViewHolder(itemView: View, listener: ClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var image: ImageView

        init {
            image = itemView.findViewById(R.id.iv_img)
            itemView.setOnClickListener {
                listener.onClick(list[absoluteAdapterPosition], image)
            }
        }

        fun bind(i: Int) {
            image.setImageResource(i)
        }
    }
}