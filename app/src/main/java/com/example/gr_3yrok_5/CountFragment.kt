package com.example.gr_3yrok_5
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gr_3yrok_5.databinding.FragmentContryBinding
import kotlin.properties.Delegates

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class CountFragment : Fragment() {


    private lateinit var binding: FragmentContryBinding
    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {

            if (count <= 10 && binding.btn.text == "+1") {
                count++
                binding.cont.text = count.toString()
            }
            if (count != 0) {
                if (count == 11) binding.btn.text = "-1"

                if (binding.btn.text == "-1") {
                    count--
                    binding.cont.text = count.toString()
                }
            }
            if (count == 0) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.container, SecondFragment())
                    .addToBackStack(null).commit()
            }
        }
    }
}
}