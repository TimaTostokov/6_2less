import com.example.my.a6_2less.ui.MainViewModel

compackage com.example.my.a6_2less.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.my.a6_2less.data.utils.Resource
import com.example.my.a6_2less.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    // 1 способ иницилизиации
//    private val viewModel by viewModels<MainViewModel>()

    // 2 способ иницилизиации
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getPlaylists()

        viewModel.playlistsState.observe(this) { state ->
            when (state) {
                is Resource.Error -> {
                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {
                    // show progress bar
                }

                is Resource.Success -> {
                    //adapter submitList(state.data)
                }
            }
        }
    }

}