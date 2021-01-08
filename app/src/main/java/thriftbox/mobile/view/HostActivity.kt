package thriftbox.mobile.view

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import thriftbox.mobile.R

class HostActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_host)
    }
}
