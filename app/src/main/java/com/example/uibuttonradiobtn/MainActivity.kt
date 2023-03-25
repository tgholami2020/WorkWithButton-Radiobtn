package com.example.uibuttonradiobtn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uibuttonradiobtn.R.color.teal_200
import com.example.uibuttonradiobtn.ui.theme.UIButtonRadiobtnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIButtonRadiobtnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                  SearchBtn()
                }
            }
        }
    }
}
@Composable
fun SearchBtn(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        MyButton()
        RadioGroup()
    }
}


@Composable
fun MyButton(){

    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(colorResource(
            id = androidx.core.R.color.androidx_core_ripple_material_light)),
        border = BorderStroke(1.dp, colorResource(id = R.color.purple_500)),
        enabled = true,

    ) {
        Text(text = "MyButton",
            color = Color.Black
        )

    }
}
@Composable
fun RadioGroup(){
    val radioButtons= listOf(0,1,2)                //1
    val selectButton= remember{ mutableStateOf(radioButtons.first()) }           //2

    Column {
        radioButtons.forEach{index ->              //3
            val isSelected= index==selectButton.value
            val colors= RadioButtonDefaults.colors(                   //4
                selectedColor = colorResource(id = R.color.black),
                unselectedColor = colorResource(id = R.color.teal_200),
                disabledColor = Color.Blue
            )
            RadioButton(                 //5
                colors= colors,
                selected = isSelected,
                onClick = {selectButton.value=index}                 //6
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UIButtonRadiobtnTheme {
        MyButton()
    }
}