package somiah.jad.colorchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {

    private lateinit var text: TextView

    var name: String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = arguments?.getSerializable("name") as String

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        text = view.findViewById(R.id.text_name)
        text.setText(name)
        return view
    }

    companion object {
        fun newInstance(param1: String) =
            SecondFragment().apply {
                var argument= Bundle().apply {
                    putSerializable("name",param1)
                }

                return SecondFragment().apply {
                    arguments = argument
                }
            }


    }
}