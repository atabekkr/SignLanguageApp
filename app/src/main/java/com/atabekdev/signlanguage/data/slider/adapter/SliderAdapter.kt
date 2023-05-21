package com.atabekdev.signlanguage.data.slider.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.atabekdev.signlanguage.R
import com.atabekdev.signlanguage.data.slider.SliderItemData

class SliderAdapter(
    val viewPager: ViewPager2, val imgList : ArrayList<SliderItemData>
) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(var v: View) : ViewHolder(v) {
        val img = v.findViewById<ImageView>(R.id.imageSlider)
        val word = v.findViewById<TextView>(R.id.tv_word)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.slider_item, parent, false)
        return SliderViewHolder(v)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val listImg = imgList[position]
        holder.img.setImageResource(listImg.img)
        holder.word.text = listImg.word
        if (position == imgList.size - 2) {
            viewPager.post(run)
        }

    }

    val run = Runnable {
        imgList.addAll(imgList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = imgList.size
}