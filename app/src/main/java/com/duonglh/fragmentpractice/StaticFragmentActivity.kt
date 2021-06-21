package com.duonglh.fragmentpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class StaticFragmentActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_fragment)
    }

    val sendBundleToFragment = { bundle: Bundle ->
        val fragment = Fragment2()
        fragment.arguments = bundle
//        val fragmentTransAction = supportFragmentManager.beginTransaction()
//        fragmentTransAction.replace(R.id.static_fragment_2, fragment)
//        fragmentTransAction.commit()
    }

    val sendBundleToActivity = { bundle: Bundle ->
        val intent = Intent(this, MyActivity1::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


}