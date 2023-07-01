package com.example.bb

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bb.ui.theme.BBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BBTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Bloodbank()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bloodbank() {

    var flag by remember {
        mutableStateOf(false)
    }

    var t1 by remember {
        mutableStateOf("")
    }
    var t2 by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(650, 161, 170))
    ) {
        Image(
            painterResource(id = R.drawable.img),
            contentDescription = "",
            modifier = Modifier.padding(20.dp)
        )

        Text(
            text = "Welcome!",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            textAlign = TextAlign.Justify
        )


        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(top = 25.dp, start = 25.dp, end = 25.dp)) {

            Text(
                text = "Enter User Id",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )


            TextField(
                value = t1, onValueChange = { t1 = it }, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Enter Password",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(5.dp)
            )

            TextField(
                value = t2, onValueChange = { t2 = it }, modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )



            Button(onClick = {flag = true}, colors = ButtonDefaults.buttonColors(Color.Yellow), modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(), shape = CutCornerShape(10)) {
                Text(text = "Sign In", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }

            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(start = 55.dp,top = 25.dp)) {
                MultiColorText("Don't have account?", Color.Black, " Click Here.", Color.White)

            }



        }

    }

    if(flag){
        Second(t1,t2)
    }


}



@Composable
fun Second(t1:String, t2:String){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(240, 161, 170))
    ) {
        Scaff()
    }

}
@Composable
fun Third(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(240, 161, 170))
    ) {
        Bloodbank()
    }

}


@Composable
fun MultiColorText(text1: String, color1: Color, text2: String, color2: Color) {
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = color1)) {
            append(text1)
        }
        withStyle(style = SpanStyle(color = color2,textDecoration = TextDecoration.Underline)) {
            append(text2)
        }
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaff() {
    var flag1 by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {mytop()},
        bottomBar = {mybot()},
        content = { pad -> MainContent(pad) },
        floatingActionButton = {
            FloatingActionButton(onClick = { flag1 = true }) {
                Icon(Icons.Filled.ExitToApp,"")
                if(flag1){

                    Third()
                }

            }
        }
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mytop() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
                Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 10.dp
                    )
            ) {
                Demo_DropDownMenu()
                Image(painterResource(id = R.drawable.img_2), contentDescription ="", modifier = Modifier.size(width = 50.dp, height = 50.dp))

            }
        },
        modifier = Modifier.drawBehind {
            drawLine(
                Color.Red,
                Offset(0f, size.height),
                Offset(size.width, size.height),
                5f
            )
        }
    )
}
@Composable
fun Demo_DropDownMenu() {

    var context = LocalContext.current
    var abc by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { abc = !abc }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "More"
            )

        }

        DropdownMenu(
            expanded = abc,
            onDismissRequest = { abc = false }
        ) {
            DropdownMenuItem(
                text = { Text("Home") },
                onClick = {
                    Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Profile") },
                onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("About") },
                onClick = { Toast.makeText(context, "About", Toast.LENGTH_SHORT).show()}
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mybot() {
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainContent(padding: PaddingValues) {
    var flag2 by remember {
        mutableStateOf(false)
    }

    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize().background(color = Color(650, 161, 170)),
        horizontalAlignment = Alignment.Start,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(padding)
                .consumedWindowInsets(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(onClick = {flag2=true}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(), shape = CutCornerShape(10)) {
                Text(text = "Schedule your Donation", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }

        if (flag2) {

            Scaff2()
        }

}

@Composable
fun CustomList(myList: MutableList<String>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(myList) { data ->
            CustomLazyItem(data = data)
        }

    }
}

@Composable
fun CustomButton(
    buttonText: String,
    textColor: Color = Color.White,
    backgroundColor: Color = Color(0, 149, 246),
    onClick: () -> Unit = {},
    isLogo: Boolean = false
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color.Red),
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            buttonText,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    mutableValue: MutableState<TextFieldValue>, label: String,
    placeholder: String
    = label,
    focusedColor: Color, conColor: Color = Color(250, 250, 250),
    isHideVal: Boolean = false, textColor: Color
) {
    TextField(
        modifier = modifier.border(
            BorderStroke(0.2.dp, focusedColor), RoundedCornerShape
                (4.dp)
        ),
        value = mutableValue.value,
        onValueChange = { mutableValue.value = it },
        label = { Text(text = label) },
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            focusedLabelColor = focusedColor,
            placeholderColor = focusedColor,
            textColor = textColor,
            unfocusedBorderColor = Color.Transparent,
            unfocusedLabelColor = focusedColor,
            unfocusedLeadingIconColor = focusedColor,
            focusedLeadingIconColor = focusedColor,
            containerColor = conColor,

            ),

        visualTransformation = if (isHideVal) PasswordVisualTransformation(
            mask =
            '\u2022'
        ) else VisualTransformation.None,

        )
}

@Composable
fun CustomLazyItem(data: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                BorderStroke(0.2.dp, Color.Black), shape =
                RoundedCornerShape(4.dp)
            ), verticalArrangement = Arrangement.Center
    ) {
        Text(text = data, textAlign = TextAlign.Center)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaff2() {
    var flag1 by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {mytop()},
        bottomBar = {mybot()},
        content = { pad -> MainContent2(pad) },
    )

}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainContent2(padding: PaddingValues){
    val primaryTextColor = remember {
        mutableStateOf(Color(115, 115, 115))
    }
    remember {
        mutableStateOf(Color(0, 55, 107))
    }
    val tertiaryTextColor = remember {
        mutableStateOf(Color.Black)
    }
    remember {
        mutableStateOf(Color(0, 149, 246))
    }
    remember {
        mutableStateOf(Color(0, 149, 246))
    }
    remember {
        mutableStateOf(Color(62, 174, 247, 255))
    }
    remember {
        mutableStateOf(Color(255, 255, 255))
    }
    remember {
        mutableStateOf(Color.White)
    }
    remember {
        mutableStateOf(Color.White)
    }
    val textFieldColor = remember {
        mutableStateOf(Color(250, 250, 250))
    }
    remember {
        mutableStateOf(Color(219, 219, 219))
    }
    val mobile = remember {
        mutableStateOf(TextFieldValue())
    }

    val fullName = remember {
        mutableStateOf(TextFieldValue())
    }

    val email = remember {
        mutableStateOf(TextFieldValue())
    }

    val address = remember {
        mutableStateOf(TextFieldValue())
    }
    val Bgroup = remember {
        mutableStateOf(TextFieldValue())
    }

    val myDataList = remember {
        mutableListOf<String>()
    }

    val showList = remember {
        mutableStateOf(false)
    }
    var gender by remember { mutableStateOf("Male") }
    val datePicker1=DatePickerDialog(
        LocalContext.current,null,2022,0,1
    )
    val datePicker2=DatePickerDialog(
        LocalContext.current,null,2022,0,1
    )

    val timePicker=TimePickerDialog(
        LocalContext.current,null,2022,0,true
    )

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()).background(color = Color(650, 161, 170))
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(padding)
                .consumedWindowInsets(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Schedule Your Donation",
                color = primaryTextColor.value,
                fontFamily =
                FontFamily.SansSerif,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))
            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                mutableValue =
                fullName,
                label = "Full Name",
                focusedColor = primaryTextColor.value,
                textColor = tertiaryTextColor.value,
                conColor = textFieldColor.value

            )
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                mutableValue =
                email,
                label = "Email",
                focusedColor = primaryTextColor.value,
                textColor = tertiaryTextColor.value,
                conColor = textFieldColor.value
            )
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                mutableValue =
                address,
                label = "Address",
                focusedColor = primaryTextColor.value,
                textColor = tertiaryTextColor.value,
                conColor = textFieldColor.value
            )
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                mutableValue =
                mobile,
                label = "Mobile Number",
                focusedColor = primaryTextColor.value,
                textColor = tertiaryTextColor.value,
                conColor = textFieldColor.value
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                RadioButton(selected = gender == "Male", onClick = { gender = "Male" })
                Text(
                    text = "Male",
                    modifier = Modifier
                        .clickable(onClick = { gender = "Male" })
                        .padding( top = 12.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                RadioButton(selected = gender == "Female", onClick = { gender = "Female" })
                Text(
                    text = "Female",
                    modifier = Modifier
                        .clickable(onClick = { gender = "Female" })
                        .padding(top = 12.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {datePicker1.show()}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier
                .padding(top = 10.dp, start = 75.dp, end = 75.dp)
                .fillMaxWidth(), shape = CutCornerShape(7)) {
                Text(text = "Date of Birth", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {datePicker2.show()}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier
                .padding(top = 10.dp, start = 65.dp, end = 65.dp)
                .fillMaxWidth(), shape = CutCornerShape(7)) {
                Text(text = "Date of Donation", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {timePicker.show()}, colors = ButtonDefaults.buttonColors(Color.Red), modifier = Modifier
                .padding(top = 10.dp, start = 65.dp, end = 65.dp)
                .fillMaxWidth(), shape = CutCornerShape(7)) {
                Text(text = "Time of Donation", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(10.dp))

            CustomTextField(
                modifier = Modifier.fillMaxWidth(),
                mutableValue =
                Bgroup,
                label = "Blood Group",
                focusedColor = primaryTextColor.value,
                textColor = tertiaryTextColor.value,
                conColor = textFieldColor.value
            )
            Spacer(modifier = Modifier.height(40.dp))


            CustomButton(
                buttonText = "Schedule!", onClick = {
                    myDataList.clear()
                    myDataList.addAll(
                        listOf(
                            fullName.value.text,
                            email.value.text,
                            address.value.text,
                            mobile.value.text,
                            gender,
                            Bgroup.value.text


                        )
                    )
                    showList.value = false
                    showList.value = true

                }
            )

            Spacer(modifier = Modifier.height(40.dp))

            if (showList.value) {
                CustomList(myList = myDataList)
            }
        }
    }

}
