package com.duonglh.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.duonglh.fragmentpractice.databinding.ActivityMy2Binding
import com.duonglh.fragmentpractice.databinding.InformationPersonBinding

class MyActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMy2Binding
    private var bundle: Bundle? = null
    private lateinit var listPerson: MutableList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMy2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let{
            bundle = intent.extras
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
        bundle?.let{
            listPerson.add(bundle?.getSerializable("person")as Person)
        }

        show()
    }

    fun show(){
        val recyclerAdapter = RecyclerAdapter()
        recyclerAdapter.listData = listPerson
        val choice = 2
        binding.recyclerView.layoutManager = when(choice){
            1 ->  LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            2 ->  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            3 -> GridLayoutManager(this, 3)
            else -> GridLayoutManager(this, 5,GridLayoutManager.VERTICAL,false)
        }

        binding.recyclerView.adapter = recyclerAdapter
    }

    class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

        var listData = listOf<Person>()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        class ViewHolder(private val binding: InformationPersonBinding) : RecyclerView.ViewHolder(binding.root){
            fun bin(person: Person){
                binding.nameText.text = person.name
                binding.ageText.text = person.age.toString()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = InformationPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bin(listData[position])
        }

        override fun getItemCount(): Int = listData.size
    }
}