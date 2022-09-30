package com.example.retrofitdemo.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.reservationmat.reservationmatItem
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.row_chaise.view.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_material.view.*

class MyReservationMaterialAdapter(): RecyclerView.Adapter<MyReservationMaterialAdapter.MyViewHolder>(){

    private var myList = emptyList<reservationmatItem>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_material, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



        if (myList[position].materieldata[position].type.equals("iphone")) {
            holder.itemView.imageMat.setImageResource(R.drawable.ic_iphonenondispo)
            holder.itemView.name_mat.text=myList[position].userdatas
            holder.itemView.date_mat.text=myList[position].materieldata[position].nomMateriel
            holder.itemView.heuredebut_mat.text=myList[position].createdAt
           // holder.itemView.heurefin_mat.text=myList[position].heureFin

        }




        if (myList[position].materieldata[position].type.equals("mac")){

                holder.itemView.imageMat.setImageResource(R.drawable.ic_macnondispo)
            holder.itemView.name_mat.text=myList[position].userdatas
            holder.itemView.date_mat.text=myList[position].materieldata[position].nomMateriel
            holder.itemView.heuredebut_mat.text=myList[position].createdAt
            //holder.itemView.heurefin_mat.text=myList[position].heureFin




        }

        if (myList[position].materieldata[position].type.equals("wearos")){

                holder.itemView.imageMat.setImageResource(R.drawable.ic_watchnondispo)
            holder.itemView.name_mat.text=myList[position].userdatas
            holder.itemView.date_mat.text=myList[position].materieldata[position].nomMateriel
            holder.itemView.heuredebut_mat.text=myList[position].createdAt
            //holder.itemView.heurefin_mat.text=myList[position].heureFin




        }


/*
       if (myList[position].disponibilite){

            holder.itemView.imageChaise.setImageResource(R.drawable.ic_seat_available)
           holder.itemView.num_chaise.text=myList[position].numChaise

           holder.itemView.setOnClickListener { v ->
               val intent = Intent(v.context, CheckoutActivity::class.java).apply {
                   putExtra("num", myList[position].numChaise)
                   putExtra("date", datee)


               }
               v.context.startActivity(intent)
           }
       // IMAGE DISPO

        }else{

           holder.itemView.imageChaise.setImageResource(R.drawable.ic_seat_unavailable)
           holder.itemView.num_chaise.text=myList[position].numChaise
           holder.itemView.setOnClickListener { v ->
            Toast(v.context).apply {
                val inflater = LayoutInflater.from(v.context)

                duration=Toast.LENGTH_SHORT
                setGravity(Gravity.CENTER,0,0)
                view=inflater.inflate(R.layout.custom_toast, null)
            }.show()
           }

       }

*/
    }

    fun setData(newList: List<reservationmatItem>){
        myList = newList
        notifyDataSetChanged()
    }
    fun navigate(){


    }
}