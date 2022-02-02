package ir.omidrezabagherian.quizappv2.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.omidrezabagherian.quizappv2.R
import ir.omidrezabagherian.quizappv2.data.Data
import ir.omidrezabagherian.quizappv2.data.StatusAnswer
import ir.omidrezabagherian.quizappv2.databinding.FragmentCheatBinding

class CheatFragment : Fragment(R.layout.fragment_cheat) {

    private lateinit var bindingCheat: FragmentCheatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindingCheat = FragmentCheatBinding.bind(view)

        if (Data.cheats[Data.round]) {
            bindingCheat.textviewShowAnswer.text = if (Data.answers[Data.round]) {
                getString(R.string.text_toast_correct)
            } else {
                getString(R.string.text_toast_incorrect)
            }
            bindingCheat.buttonShowAnswer.setOnClickListener {
                Toast.makeText(activity, R.string.text_no_cheat, Toast.LENGTH_SHORT).show()
            }
        } else {
            bindingCheat.buttonShowAnswer.setOnClickListener {
                if (Data.isCompletes[Data.round] == StatusAnswer.None) {
                    bindingCheat.textviewShowAnswer.text = if (Data.answers[Data.round]) {
                        getString(R.string.text_toast_correct)
                    } else {
                        getString(R.string.text_toast_incorrect)
                    }
                    Data.cheats[Data.round] = true
                    Data.isCompletes[Data.round] = StatusAnswer.Cheat
                } else {
                    Toast.makeText(activity, R.string.text_no_cheat, Toast.LENGTH_SHORT).show()
                }
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}