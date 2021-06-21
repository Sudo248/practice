package com.duonglh.fragmentpractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import com.duonglh.fragmentpractice.databinding.ActivityMy1Binding
import com.duonglh.fragmentpractice.databinding.InformationPersonBinding

class MyActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivityMy1Binding
    private lateinit var bundle: Bundle
    private lateinit var listPerson: MutableList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMy1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let {
            bundle = intent.getBundleExtra("bundle")!!
        }
        listPerson = mutableListOf(
            Person("Minh", 20),
            Person("Huy",19),
            Person("Dung", 20),
            Person("Hoa", 20),
            Person("Diep",20),
            Person("Trang",20),
            Person("Hang",20),
            Person("Truong",20),
            Person("Long",20)
        )
        listPerson.add(bundle.getSerializable("person")as Person)
        show()
    }

    fun show(){
        val listViewAdapter = ListViewAdapter(applicationContext)
        listViewAdapter.listData = listPerson
        binding.listItem.adapter = listViewAdapter

    }
    class ListViewAdapter(val context: Context) : BaseAdapter(){
        var listData = listOf<Person>()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun getCount(): Int = listData.size

        override fun getItem(position: Int): Any = listData[position]

        override fun getItemId(position: Int): Long = 0

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var binding: InformationPersonBinding
            if(convertView == null){
                binding = InformationPersonBinding.inflate(LayoutInflater.from(context), parent, false)
                binding.root.tag = binding
            }
            else binding = convertView.tag as InformationPersonBinding
            binding.nameText.text = listData[position].name
            binding.ageText.text = listData[position].age.toString()
            return binding.root
        }

    }
}