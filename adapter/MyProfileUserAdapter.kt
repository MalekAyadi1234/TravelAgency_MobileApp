package com.example.retrofitdemo.adapter
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.ChooseSeatActivity
import com.example.retrofitdemo.MainActivity2
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.SeanceItem
import com.example.retrofitdemo.model.userssItem
import kotlinx.android.synthetic.main.new_userss_item_layout.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.userss_item_layout.view.*
import kotlinx.android.synthetic.main.userss_item_layout.view.namemalek

class MyProfileUserAdapter: RecyclerView.Adapter<MyProfileUserAdapter.MyViewHolder>(){

    private var myList = emptyList<userssItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.userss_item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       /* holder.itemView.setOnClickListener { v ->
            val intent = Intent(v.context, MainActivity2::class.java).apply {
                putExtra("id", myList[position].id)
                putExtra("date", myList[position].dateSeance)
            }
            v.context.startActivity(intent)
        }*/

        holder.itemView.namemalek.setText(myList[position].name.toString())
        holder.itemView.emailmalek.setText(myList[position].email.toString())
        holder.itemView.phonemalek.setText(myList[position].phone.toString())

           //name=myList[position].name


        //holder.itemView.namemalek.setText(myList[position].name.toString())

    }

    fun setData(newList: List<userssItem>){
        myList = newList
        notifyDataSetChanged()

    }
    fun navigate(){


    }
}