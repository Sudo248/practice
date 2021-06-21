package com.duonglh.fragmentpractice

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.duonglh.fragmentpractice.databinding.ActivityMy2Binding
import com.duonglh.fragmentpractice.databinding.InformationPersonBinding

class MyActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMy2Binding
    lateinit var bundle: Bundle
    private lateinit var listPerson: MutableList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMy2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        intent?.let{
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
            TODO("Not yet implemented")

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            TODO("Not yet implemented")
            holder.bin(listData[position])
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }
    }
}