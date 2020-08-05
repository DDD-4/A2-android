package kr.ddd.a2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.ddd.a2.databinding.ActivityParentBinding
import kr.ddd.a2.shared.SharedViewModel

@AndroidEntryPoint
class ParentActivity : AppCompatActivity() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setNavController()
    }

    private fun setBinding() {
        val binding: ActivityParentBinding =
            ActivityParentBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    private fun setNavController() {
        // TODO: Must be initialization
        val startArgs = Bundle()
        findNavController(R.id.fragment_nav_host)
            .setGraph(R.navigation.nav_graph, startArgs)
    }
}
