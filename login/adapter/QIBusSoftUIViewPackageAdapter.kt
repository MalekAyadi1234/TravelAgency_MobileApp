package com.example.retrofitdemo.login.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView



import java.util.ArrayList
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.login.QIBusSoftUIBaseActivity

class QIBusSoftUIViewPackageAdapter/*constructor*/
    (/*variable declaration*/
    private val mContext: Context,
    private val mPackageListSoftUI: ArrayList<QIBusSoftUINewPackageModel>
)/* initialize parameter*/ :
    RecyclerView.Adapter<QIBusSoftUIViewPackageAdapter.PackageViewHolder>() {
    private var mListener: onClickListener? = null

    /*set onClick listener*/
    fun setOnClickListener(mListener: onClickListener) {
        this.mListener = mListener
    }

    /*  inflate layout */
    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        return PackageViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.qibus_softui_item_viewpackage,
                null
            )
        )
    }

    /*bind viewholder*/
    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {

        val model = mPackageListSoftUI[position]

        holder.mTvDestination.text = model.destination
        holder.mTvDuration.text = model.duration
        holder.mTvNewPrice.text = model.newprice

        (mContext as QIBusSoftUIBaseActivity).setImage(model.image, holder.mIvPlace)
        holder.mRating.rating = java.lang.Float.parseFloat(model.rating)

        holder.itemView.setOnClickListener {
            if (mListener != null) {
                notifyDataSetChanged()
                mListener!!.onClick(model)

            }
        }
    }

    /*item count*/
    override fun getItemCount(): Int {
        return mPackageListSoftUI.size
    }

    /*onclick listener interface*/
    interface onClickListener {

        fun onClick(notificationModelSoftUI: QIBusSoftUINewPackageModel)
    }

    /*view holder*/
    inner class PackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val mTvDestination: TextView
        val mTvDuration: TextView
        val mTvNewPrice: TextView
        val mIvPlace: ImageView
        val mRating: RatingBar

        init {
            mTvDestination = itemView.findViewById(R.id.tvDestination)
            mTvDuration = itemView.findViewById(R.id.tvDuration)
            mTvNewPrice = itemView.findViewById(R.id.tvLatestPrice)
            mIvPlace = itemView.findViewById(R.id.ivPlace)
            mRating = itemView.findViewById(R.id.ratingbar)
        }
    }

}


