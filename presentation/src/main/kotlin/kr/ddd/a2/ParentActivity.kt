package kr.ddd.a2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.ddd.a2.databinding.ActivityParentBinding
import kr.ddd.a2.shared.SharedViewModel

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    private fun setBinding() {
        val binding: ActivityParentBinding =
            ActivityParentBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}
