package com.feel.jeon.koin_sample

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.feel.jeon.koin_sample.model.User
import com.feel.jeon.koin_sample.repository.UserRepository
import com.feel.jeon.koin_sample.ui.theme.Koin_sampleTheme
import com.feel.jeon.koin_sample.viewModel.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    // inject 는 이렇게 사용
    //    private val presenter: UserPresenter by inject()
    //    private val userRepository: UserRepository by inject()

    //    viewModel 주입
    private val mainViewModel: MainViewModel by viewModel()
    private var addCounter = 1
    private var findCounter = 1
    private var secondAddCounter = 1
    private var secondFindCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Koin_sampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TextButton(onClick = {
                            mainViewModel.addUser(arrayListOf(User("전승필$addCounter", 29)))
                            addCounter++
                            this@MainActivity.showToast("first add success")
                        }) {
                            Text(text = "first addUser")
                        }
                        TextButton(onClick = {
                            val greetingText = mainViewModel.sayHello("전승필$findCounter", 29)
                            this@MainActivity.showToast(greetingText)
                            if(greetingText != "NOT FOUND!") {
                                findCounter++
                            }
                        }) {
                            Text(text = "first sayHello")
                        }
                        TextButton(onClick = {
                            mainViewModel.secondAddUser(arrayListOf(User("오픈오브젝트$secondAddCounter", 29)))
                            secondAddCounter++
                            this@MainActivity.showToast("second add success")
                        }) {
                            Text(text = "second addUser")
                        }
                        TextButton(onClick = {
                            val greetingText = mainViewModel.secondSayHello("오픈오브젝트$secondFindCounter", 29)
                            this@MainActivity.showToast(greetingText)
                            if(greetingText != "NOT FOUND!") {
                                secondFindCounter++
                            }
                        }) {
                            Text(text = "second sayHello")
                        }
                    }
                }
            }
        }
    }
}

fun Context.showToast(msg: String) {
    Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()
}