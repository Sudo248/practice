package com.duonglh.fragmentpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.duonglh.fragmentpractice.databinding.Fragment1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: Fragment1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = Fragment1Binding.bind(view)
        val bundle = Bundle()
        // khối này bị lỗi ạ
        val parentActivity = when(activity){
            is StaticFragmentActivity -> activity as StaticFragmentActivity
            else -> activity as DynamicFragmentActivity
        }
//        val parentActivity = activity as StaticFragmentActivity  // dòng này thì chạy được ạ
        binding.sendFragmentButton.setOnClickListener {
            bundle.putSerializable("person", Person(binding.yourNameEditT.text.toString(),
                                                    binding.ageEditT.text.toString().toShort()))
            parentActivity.sendBundleToFragment(bundle)
        }
        binding.sendActivityButton.setOnClickListener {
            bundle.putSerializable("person", Person(binding.yourNameEditT.text.toString(),
                                                    binding.ageEditT.text.toString().toShort()))
            parentActivity.sendBundleToActivity(bundle)
        }
    }

//    fun sendBundleToFragment(bundle: Bundle){
//        when(activity){
//            is StaticFragmentActivity -> (activity as StaticFragmentActivity).sendBundleToFragment(bundle)
//            else -> (activity as DynamicFragmentActivity).sendBundleToFragment(bundle)
//        }
//    }
//    fun sendBundleToActivity(bundle: Bundle){
//        when(activity){
//            is StaticFragmentActivity -> (activity as StaticFragmentActivity).sendBundleToActivity(bundle)
//            else -> (activity as DynamicFragmentActivity).sendBundleToActivity(bundle)
//        }
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}