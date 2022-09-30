package com.example.retrofitdemo.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.delai.DelaiItem
import com.example.retrofitdemo.model.passageCle.passagecleItem

import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.row_chaise.view.*

import kotlinx.android.synthetic.main.row_layout.view.*
class MyDelaiAdapter: RecyclerView.Adapter<MyDelaiAdapter.MyViewHolder>(){

    private var myList = emptyList<DelaiItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.iv_image.setImageResource(R.drawable.ic_claim)
        holder.itemView.tv_title.text ="User: "+myList[position].userdatas
        holder.itemView.tv_newtitle.text = "Date :"+myList[position].datenotif
        holder.itemView.tv_description.text = "Claim: "+myList[position].delai

    }

    fun setData(newList: List<DelaiItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}