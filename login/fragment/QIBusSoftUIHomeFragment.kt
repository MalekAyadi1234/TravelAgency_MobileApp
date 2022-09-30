package com.example.retrofitdemo.login.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.*
import com.example.retrofitdemo.login.QIBusSoftUIBaseActivity
import com.example.retrofitdemo.login.adapter.QIBusSoftUINewOfferAdapter
import com.example.retrofitdemo.login.adapter.QIBusSoftUIRecentSearchAdapter
import com.example.retrofittest.utils.QIBusSoftUIConstants
import kotlinx.android.synthetic.main.activity_delai.*
import java.text.SimpleDateFormat
import java.util.*


class QIBusSoftUIHomeFragment() : Fragment(), View.OnClickListener,
    QIBusSoftUIRecentSearchAdapter.onClickListener {


    //**************************************************
    private var btnReserverMat: ImageView? = null
    private var btnPassageCle: ImageView? = null
    private var btnDelaii: ImageView? = null


    private var mValue = 0
    private var mSoftUINewOfferList: ArrayList<QIBusSoftUINewOfferModel>? = null
    private var mRecentSearchList: ArrayList<QIBusSoftUIBookingModel>? = null
    private var mRvNewOffer: RecyclerView? = null
    private var mRvRecentSearch: RecyclerView? = null
    private var mIvDescrease: ImageView? = null
    private var mIvIncrease: ImageView? = null
    private var mSearch: ImageView? = null
    private var mTvCount: TextView? = null
    private var mTvViewNewOffers: TextView? = null
    private var mDepartDateCalendar: Calendar? = null
    private var mSoftUIRecentSearchAdapter: QIBusSoftUIRecentSearchAdapter? = null
    private var mEdDepartDate: TextView? = null
    private val date = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        mDepartDateCalendar!!.set(Calendar.YEAR, year)
        mDepartDateCalendar!!.set(Calendar.MONTH, monthOfYear)
        mDepartDateCalendar!!.set(Calendar.DAY_OF_MONTH, dayOfMonth)

        updateLabel()
    }
    private var mIsAcSelected: Boolean = false
    private var mIsNonAcSelected: Boolean = false
    private var mIsSeaterSelected: Boolean = false
    private var mIsSleeperSelected: Boolean = false
    private var city: Array<String>? = null

    /* create view */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.qibus_softui_fragment_home, null)




        initView(view)
        setListener()
        getData()

        setOfferAdapter()

        if (mDepartDateCalendar == null) {
            mDepartDateCalendar = Calendar.getInstance()
        }
        updateLabel()






        return view
    }

    /* update label */
    private fun updateLabel() {
      /*  mEdDepartDate!!.text =
            QIBusSoftUIConstants.DateFormat.DAY_MONTH_YEAR_FORMATTER.format(mDepartDateCalendar!!.time)

*/

        val myFormat="dd-MM-yyyy"
        val sdf= SimpleDateFormat(myFormat,Locale.FRANCE)
        mEdDepartDate!!.setText(sdf.format(mDepartDateCalendar!!.time))
        Log.d("date",mEdDepartDate!!.text.toString())
    }

    /* set adapter */
    private fun setOfferAdapter() {
        mRvNewOffer!!.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        mRvNewOffer!!.adapter = QIBusSoftUINewOfferAdapter(requireActivity(), mSoftUINewOfferList!!)

        mSoftUIRecentSearchAdapter = QIBusSoftUIRecentSearchAdapter(requireActivity(), mRecentSearchList!!)
        mRvRecentSearch!!.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        mRvRecentSearch!!.adapter = mSoftUIRecentSearchAdapter
        mSoftUIRecentSearchAdapter!!.setOnClickListener(this)


    }

    /* set listener */
    private fun setListener() {
        mSearch!!.setOnClickListener(this)
        mTvViewNewOffers!!.setOnClickListener(this)
        //mTvAC!!.setOnClickListener(this)
        //mTvNonAc!!.setOnClickListener(this)
        //mTvSleeper!!.setOnClickListener(this)
        //mTvSeater!!.setOnClickListener(this)
        //mIvSwap!!.setOnClickListener(this)
        mIvDescrease!!.setOnClickListener(this)
        mIvIncrease!!.setOnClickListener(this)
        mEdDepartDate!!.setOnClickListener(this)

        btnReserverMat!!.setOnClickListener(this)
        btnPassageCle!!.setOnClickListener(this)
        btnDelaii!!.setOnClickListener(this)








    }

    /* init view */
    private fun initView(view: View) {



        btnReserverMat = view.findViewById(R.id.reserverMat)
        btnPassageCle = view.findViewById(R.id.passerCle)
        btnDelaii = view.findViewById(R.id.notifierRetard)

        mRvNewOffer = view.findViewById(R.id.rvNewOffers)
        mTvViewNewOffers = view.findViewById(R.id.tvViewallNewOffer)
      //  mIvSwap = view.findViewById(R.id.ivSwap)
        mSearch = view.findViewById(R.id.btnSearch)

        mEdDepartDate = view.findViewById(R.id.edOneWay)
       // mEdFromCity = view.findViewById(R.id.edFromCity)
            // mEdToCity = view.findViewById(R.id.edToCity)
        mIvDescrease = view.findViewById(R.id.ivDescrease)
        mIvIncrease = view.findViewById(R.id.ivIncrease)
        mTvCount = view.findViewById(R.id.tvCount)
        //mView = view.findViewById(R.id.view2)
        mRvRecentSearch = view.findViewById(R.id.rvRecentSearch)
        city = arrayOf(
            getString(R.string.QIBus_softui_lbl_mumbai),
            getString(R.string.QIBus_softui_lbl_surat),
            getString(R.string.QIBus_softui_lbl_delhi),
            getString(R.string.QIBus_softui_lbl_pune)
        )
        val adapter = ArrayAdapter(requireActivity(), R.layout.qibus_softui_spinner_items, city!!)


        mIvDescrease!!.visibility = View.INVISIBLE


    }

    /* et cricketdata */
    private fun getData() {

        mRecentSearchList = ArrayList()
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_DelhiToMubai),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_MumbaiToPune),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_AhmedabadToMumbai),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_JaipurToNewDelhi),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_MumbaiToSurat),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_DelhiToMubai),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )
        mRecentSearchList!!.add(
            QIBusSoftUIBookingModel(
                getString(R.string.QIBus_softui_lbl_MumbaiToSurat),
                getString(R.string.QIBus_softui_lbl_date)
            )
        )


        mSoftUINewOfferList = ArrayList()
        mSoftUINewOfferList!!.add(QIBusSoftUINewOfferModel(getString(R.string.QIBus_softui_lbl_offer1)))
        mSoftUINewOfferList!!.add(QIBusSoftUINewOfferModel(getString(R.string.QIBus_softui_lbl_offer2)))
        mSoftUINewOfferList!!.add(QIBusSoftUINewOfferModel(getString(R.string.QIBus_softui_lbl_offer1)))
        mSoftUINewOfferList!!.add(QIBusSoftUINewOfferModel(getString(R.string.QIBus_softui_lbl_offer2)))
        mSoftUINewOfferList!!.add(QIBusSoftUINewOfferModel(getString(R.string.QIBus_softui_lbl_offer2)))

    }
    /* onClick listener */
    override fun onClick(v: View) {

        when (v.id) {

            R.id.edOneWay -> {

                val datePickerDialogs = DatePickerDialog(
                    requireActivity(), date, mDepartDateCalendar!!
                        .get(Calendar.YEAR), mDepartDateCalendar!!.get(Calendar.MONTH),
                    mDepartDateCalendar!!.get(Calendar.DAY_OF_MONTH)
                )
                datePickerDialogs.datePicker.minDate = Date().time
                datePickerDialogs.show()
            }

            R.id.ivIncrease -> {
                mValue = mValue + 1

                if (mValue < 1) {
                    mValue = 1

                } else {

                    if (mValue == 1)
                        (activity as QIBusSoftUIBaseActivity).invisibleView(mIvDescrease!!)

                    mTvCount!!.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0)
                    mTvCount!!.text = mValue.toString()
                    mTvCount!!.setTextColor(resources.getColor(R.color.QIBus_softui_colorPrimary))

                }
            }




                    R.id.reserverMat -> {
                //    if (validate()) {

                Log.d("Activityy", "ReserverMat");
                val intent = Intent(activity, MainActivityMaterial::class.java)
                startActivity(intent)
            }

                    R.id.passerCle -> {
                //    if (validate()) {

                       // Log.d("Activityy", strr);
                val intent = Intent(activity, PassageActivity::class.java)

                startActivity(intent)
            }

            R.id.notifierRetard -> {
                //    if (validate()) {

                Log.d("Activityy", "Delaiiiiiii");
                val intent = Intent(activity, DelaiActivity::class.java)
                startActivity(intent)
            }

            R.id.btnSearch -> {
                //    if (validate()) {

//        Log.d("date",mEdDepartDate!!.text.toString())

                val intent = Intent(activity, MainActivity::class.java).apply {
                    putExtra(QIBusSoftUIConstants.intentdata.TRIP_KEY, "$mFrom To $mTo")
                    putExtra("dateseance", mEdDepartDate!!.text.toString())
                }
                //intent.putExtra(QIBusSoftUIConstants.intentdata.TRIP_KEY, "$mFrom To $mTo")
                startActivity(intent)
            }
            R.id.tvViewallNewOffer -> {
                val i = Intent(activity, MainActivity::class.java)
                i.putExtra(QIBusSoftUIConstants.intentdata.OFFER, mSoftUINewOfferList)
                startActivity(i)
            }

            R.id.layout1->{
                val url = "https://m.facebook.com/YouGoTravel.Tunisie/?locale2=it_IT"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                startActivity(i)

            }
        }//    }


    }

    /* validation */


    /* disable textview */
    private fun disable(textView: TextView) {
        textView.setTextColor(resources.getColor(R.color.QIBus_softui_textChild))
        for (drawable in textView.compoundDrawables) {
            if (drawable != null) {
                drawable.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.QIBus_softui_textChild
                    ), PorterDuff.Mode.SRC_IN
                )
            }
        }
    }
/*
    override fun openurl(v: View?) {
        // TODO Auto-generated method stub
        val url = "http://www.gobloggerslive.com"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
*/
    /* enable textview */
    private fun enable(textView: TextView) {
        textView.setTextColor(resources.getColor(R.color.design_default_color_primary))
        for (drawable in textView.compoundDrawables) {
            if (drawable != null) {
                drawable.colorFilter = PorterDuffColorFilter(
                    ContextCompat.getColor(
                        textView.context,
                        R.color.design_default_color_primary
                    ), PorterDuff.Mode.SRC_IN
                )
            }
        }
    }

    /* onClick listener */
    override fun onClick(softUIBookingModel: QIBusSoftUIBookingModel) {

        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra(QIBusSoftUIConstants.intentdata.SEARCH_BUS, softUIBookingModel.destination)
        startActivity(intent)
    }






    /* change destination */


    companion object {
        /*variable declaration*/
        val mTitle = "Home"
        var mFrom: String = ""
        var mTo: String = ""
    }
}
