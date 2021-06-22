package com.duonglh.fragmentpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class StaticFragmentActivity : AppCompatActivity(), Fragment1.ParentActivity<StaticFragmentActivity> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_fragment)
    }

    override fun sendBundleToFragment(bundle: Bundle) {
        val fragment2 = Fragment2()
        fragment2.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_static_2, fragment2)
            .commit()
    }

    override fun sendBundleToActivity(bundle: Bundle) {
        val intent = Intent(this, MyActivity2::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}