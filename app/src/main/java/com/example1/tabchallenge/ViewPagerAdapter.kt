package com.example1.tabchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*



 class ViewPagerAdapter (val texts:List<String>):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> () {
 inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
    val view= LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewPagerViewHolder(view)
    }
    override fun getItemCount(): Int {
        return texts.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
       val text=texts[position]
        holder.itemView.text.setText(text)

    }



}