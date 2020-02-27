package com.bbreda.tablayoutandviewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_card.*

class CardFragment : Fragment() {

    private var counter: Int? = null
    private val COLOR_MAP = intArrayOf(
        R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700, R.color.blue_100,
        R.color.blue_300, R.color.blue_500, R.color.blue_700, R.color.green_100, R.color.green_300,
        R.color.green_500, R.color.green_700
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            counter = arguments?.getInt(ARG_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(ContextCompat.getColor(this!!.context!!, COLOR_MAP[counter!!]))
        tv_counter.text = "Fragment position " + (counter!! +1)
    }

    companion object {
        private const val ARG_COUNT = "param1"
        fun newInstance(counter: Int?): CardFragment {
            val fragment = CardFragment()
            val args = Bundle()
            args.putInt(ARG_COUNT, counter!!)
            fragment.arguments = args
            return fragment
        }
    }
}