package com.example.anusmaaraka.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anusmaaraka.R
import com.example.anusmaaraka.model.DateModel
import com.example.anusmaaraka.model.DateType
import com.example.anusmaaraka.ui.theme.*


@Preview
@Composable
fun TestCase(){
    var dateModel = DateModel("Putrada", DateType.EKADASHI,"21-01-24")
    CardView(dateModel)
}
@Composable
fun CardView(dateNode: DateModel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.2f)
                    .height(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(lightBlue),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.padding(8.dp),
                    painter = painterResource(R.drawable.pumpkin),
                    contentDescription = "pumpkin",
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.55f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = dateNode.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = black,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = dateNode.type.toString(),
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(0.25f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = dateNode.date,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = gold,
                )
                /*Text(
                    text = "Cocok untuk memrunkunkan berat badam",
                    fontSize = 12.sp,
                    color = Color.Gray,
                )*/
            }
        }
    }
}