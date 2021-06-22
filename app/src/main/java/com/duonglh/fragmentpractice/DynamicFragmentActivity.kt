package com.duonglh.fragmentpractice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duonglh.fragmentpractice.databinding.ActivityDynamicFragmentBinding

class DynamicFragmentActivity : AppCompatActivity(), Fragment1.ParentActivity<DynamicFragmentActivity> {
    lateinit var binding: ActivityDynamicFragmentBinding
    var isLandscape: Boolean = false

    var saveBundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.executePendingTransactions()
        val fragment1 = Fragment1()
        if(binding.dynamicFragmentPort != null){
            if(savedInstanceState != null){
                fragment1.arguments = savedInstanceState
                saveBundle = savedInstanceState
                supportFragmentManager.findFragmentById(R.id.dynamic_fragment_port)?.let {
                    supportFragmentManager.beginTransaction().remove(it).commit()
                }
            }
            supportFragmentManager.beginTransaction().add(R.id.dynamic_fragment_port,fragment1).commit()
        }
        else{
            isLandscape = true
            if(savedInstanceState != null){
                fragment1.arguments = savedInstanceState
                saveBundle = savedInstanceState
                supportFragmentManager.findFragmentById(R.id.dynamic_fragment_land_1)?.let{
                    supportFragmentManager.beginTransaction().remove(it).commit()
                }
                supportFragmentManager.findFragmentById(R.id.dynamic_fragment_land_2)?.let{
                    supportFragmentManager.beginTransaction().remove(it).commit()
                }
            }
            supportFragmentManager.beginTransaction().add(R.id.dynamic_fragment_land_1, fragment1).commit()
        }
    }

    override fun sendBundleToFragment(bundle: Bundle) {
        val fragment2 = Fragment2()
        fragment2.arguments = bundle
        if(isLandscape){
            supportFragmentManager.beginTransaction().replace(R.id.dynamic_fragment_land_2, fragment2).commit()
        }
        else{
            supportFragmentManager.beginTransaction().replace(R.id.dynamic_fragment_port, fragment2).commit()
        }
    }

    override fun sendBundleToActivity(bundle: Bundle) {
        val intent = Intent(this, MyActivity1::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}