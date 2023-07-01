package com.example.google

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(all = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                var fname by remember { mutableStateOf(TextFieldValue("")) }
                var lname by remember { mutableStateOf(TextFieldValue("")) }
                var username by remember { mutableStateOf(TextFieldValue("")) }
                var password by remember { mutableStateOf(TextFieldValue("")) }
                var Cpassword by remember { mutableStateOf(TextFieldValue("")) }

                Image(painterResource(id = R.drawable.img) , contentDescription = "img " +
                        "logo", modifier = Modifier
                    .align(Alignment.Start)
                    .size(width = 120.dp, height = 60.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Create your Google Account", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.ExtraBold, fontFamily = FontFamily.Monospace, modifier = Modifier
                    .align(Alignment.Start)
                    .fillMaxWidth())
                Spacer(modifier = Modifier.height(40.dp))
                OutlinedTextField(
                    value = fname,
                    placeholder = { Text(text = "First Name")},
                    onValueChange = {
                        fname = it
                    }, modifier = Modifier.align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = lname,
                    placeholder = { Text(text = "Last Name")},
                    onValueChange = {
                        lname = it
                    }, modifier = Modifier.align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedTextField(
                    value = username,
                    placeholder = { Text(text = "User Name")},
                    onValueChange = {
                        username = it
                    }, modifier = Modifier.align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "You can use letters, numbers & periods", fontSize = 10.sp)
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    value = password,
                    placeholder = { Text(text = "Password")},
                    onValueChange = {
                        password = it
                    }, modifier = Modifier.align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(15.dp))
                OutlinedTextField(
                    value = Cpassword,
                    placeholder = { Text(text = "Confirm")},
                    onValueChange = {
                        Cpassword = it
                    }, modifier = Modifier.align(alignment = Alignment.Start)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Use 8 or more characters with a mix of letters, numbers & symbols", fontSize = 10.sp)
                Spacer(modifier = Modifier.height(20.dp))
                checkbox()
                Column(

                    ) {
                    Row() {
                        Text(text = "Sign in instead                      ", color = Color.Blue,modifier= Modifier.padding(vertical = 11.dp), fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold)

                        Button(
                            onClick = {
                                Toast.makeText(applicationContext, "Welcome " +
                                        username.text, Toast.LENGTH_LONG).show()
                            },
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentSize(align = Alignment.Center)
                                .size(width = 100.dp, height = 40.dp),
                            shape = CutCornerShape(5)
                        ) {
                            Text(text = "Next", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                    }



                }



            }



        }
    }
}
@Composable
private fun checkbox() {

    val contextForToast = LocalContext.current.applicationContext

    var checked by remember {
        mutableStateOf(true)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked_ ->
                checked = checked_
            }
        )

        Text(
            text = "Show password", fontSize = 15.sp, fontWeight = FontWeight.ExtraBold
        )
    }
}