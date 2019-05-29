package pl.sjmprofil.fofoquizmvvm.ui

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import pl.sjmprofil.fofoquizmvvm.R
import pl.sjmprofil.fofoquizmvvm.utils.ConnectivityReceiver
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private lateinit var snackBar : Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, vmFactory)[MainViewModel::class.java]
        //println(viewModel)

        viewModel.getJokes().observe(this, Observer {
            println(it.toString())
        })

        //registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

//        val questionsToDownload = viewModel.getQuestion()
//
//        println(viewModel)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }

    private fun showNetworkMessage(isConnected: Boolean) {
        if(!isConnected) {
            snackBar = Snackbar.make(findViewById(R.id.rootLayout), "No Internet connection", Snackbar.LENGTH_LONG)
            snackBar.duration = BaseTransientBottomBar.LENGTH_INDEFINITE
            snackBar.show()
        }else{
            snackBar.dismiss()
        }
    }
}
