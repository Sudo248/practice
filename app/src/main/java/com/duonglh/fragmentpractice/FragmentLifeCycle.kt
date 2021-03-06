package com.duonglh.fragmentpractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
const val TAG = "Fragment: "

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLifeCycle.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLifeCycle : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e(TAG,"onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.e(TAG,"onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.e(TAG,"onCreateView()")
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG,"onViewCreated()")
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG,"onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG,"onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG,"onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG,"onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG,"onDetach()")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLifeCycle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLifeCycle().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}