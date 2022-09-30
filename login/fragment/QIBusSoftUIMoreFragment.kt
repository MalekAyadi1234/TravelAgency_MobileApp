package com.example.retrofitdemo.login.fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdemo.MainViewModel
import com.example.retrofitdemo.R
import com.example.retrofitdemo.login.MainActivityprofillle
import com.example.retrofitdemo.login.NewLoginActivity
import com.example.retrofitdemo.login.QIBusSoftUIBaseActivity
import com.example.retrofitdemo.login.newactivities.*
import com.example.retrofitdemo.repository.Repository
import com.example.retrofittest.MainViewModelFactory
import com.example.retrofittest.utils.QIBusSoftUIConstants

class QIBusSoftUIMoreFragment : Fragment(), View.OnClickListener {
    private var mTvProfileSettings: TextView? = null
    private var mTvWallet: TextView? = null
    private var mTvCards: TextView? = null
    private var mTvReferEarn: TextView? = null
    private var mTvHelp: TextView? = null
    private var mTvLogout: TextView? = null
    private var mTvSetting: TextView? = null
    private val mFlag = "1"
    private lateinit var viewModel: MainViewModel




    /* create view */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {






        val view = inflater.inflate(R.layout.qibus_softui_fragment_more, null)
        initLayouts(view)
        initializeListeners()
        return view
    }

    /* initialize listener */
    private fun initializeListeners() {

        mTvProfileSettings!!.setOnClickListener(this)
       mTvWallet!!.setOnClickListener(this)
//        mTvCards!!.setOnClickListener(this)
  //      mTvReferEarn!!.setOnClickListener(this)
        mTvHelp!!.setOnClickListener(this)
        mTvLogout!!.setOnClickListener(this)
      //  mTvSetting!!.setOnClickListener(this)
    }

    /* init layout */
    private fun initLayouts(view: View) {

        mTvProfileSettings = view.findViewById(R.id.tvProfileSettings)
        mTvWallet = view.findViewById(R.id.tvWallet)
     //   mTvCards = view.findViewById(R.id.tvCards)
     //   mTvReferEarn = view.findViewById(R.id.tvReferEarn)
        mTvHelp = view.findViewById(R.id.tvHelp)
        mTvLogout = view.findViewById(R.id.tvLogout)
       // mTvSetting = view.findViewById(R.id.tvSetting)
    }

    /* onClick listener */
    override fun onClick(v: View) {
        if (v === mTvProfileSettings)
            (activity as QIBusSoftUIBaseActivity).startActivity(QIBusSoftUISoftUIProfileSettingsActivity::class.java)

        else if (v === mTvWallet)
            (activity as QIBusSoftUIBaseActivity).startActivity(BotchatActivity::class.java)

      /*else if (v === mTvHelp){
            var sh = getActivity()?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            // var sh = getActivity()?.getSharedPreferences("shared", Context.MODE_PRIVATE)
            //  val id = sh?.getString("ID", null) val remember= sh?.getBoolean(IS_REMEMBRED, true)

            val phone = sh?.getString("STRING_KEY", null)

            val repository = Repository()
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            // viewModel.getCustomPosts(5,"id", "desc")
            viewModel.deleteuser(phone.toString())
            (activity as QIBusSoftUIBaseActivity).startActivity(QIBusSoftUISoftUIHelpActivity::class.java)

        }*/

        else if (v === mTvHelp) {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle(getString(R.string.QIBus_softui_text_confirmation))
                .setMessage("Are You Sure to Delete your account?")
            builder.setPositiveButton(
                getString(R.string.QIBus_softui_text_yes)
            ) { dialog, id ->
              /*  startActivity(
                    Intent(
                        activity,
                        NewLoginActivity::class.java
                    )
                )*/
                var sh = getActivity()?.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                // var sh = getActivity()?.getSharedPreferences("shared", Context.MODE_PRIVATE)
                //  val id = sh?.getString("ID", null) val remember= sh?.getBoolean(IS_REMEMBRED, true)

                val phone = sh?.getString("STRING_KEY", null)

                val repository = Repository()
                val viewModelFactory = MainViewModelFactory(repository)
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                // viewModel.getCustomPosts(5,"id", "desc")
                viewModel.deleteuser(phone.toString())
                (activity as QIBusSoftUIBaseActivity).startActivity(NewLoginActivity::class.java)
            }
            builder.setNegativeButton(
                getString(R.string.QIBus_softui_text_no)
            ) { dialog, id -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        }


        else if (v === mTvLogout) {
            val builder = AlertDialog.Builder(activity)
            builder.setTitle(getString(R.string.QIBus_softui_text_confirmation))
                .setMessage(getString(R.string.QIBus_softui_msg_logout))
            builder.setPositiveButton(
                getString(R.string.QIBus_softui_text_yes)
            ) { dialog, id ->
                startActivity(
                    Intent(
                        activity,
                        NewLoginActivity::class.java
                    )
                )
            }
            builder.setNegativeButton(
                getString(R.string.QIBus_softui_text_no)
            ) { dialog, id -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        }
    }

    companion object {

        /*variable declaration*/
        val mTitle = "More"
    }
}
