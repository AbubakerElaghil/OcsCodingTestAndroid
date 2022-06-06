package com.example.ocscodingtestapp.presentaion.components

import android.text.Html
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.Game
import com.example.ocscodingtestapp.util.DEFAULT_ATHLETE_IMAGE
import com.example.ocscodingtestapp.util.loadPicture
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.ocscodingtestapp.R


@Composable
fun AthleteView(athlete: Athlete, findNavController: NavController) {

    Column(
        modifier = Modifier
            .padding( bottom = 10.dp)
            .fillMaxWidth()
    )
    {

        TopAppBar(
            title = { Text(text = "${athlete.name} details") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            findNavController.navigateUp()
                        }
                )
            }

        )

        headerView(athlete)
         resultsView(athlete)
        bioView(athlete)


    }

}


@Composable
fun headerView(athlete: Athlete) {
    Row() {

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(6.dp)
                .height(150.dp)
                .wrapContentWidth(Alignment.Start),
            elevation = 8.dp
        )
        {
            val image =
                loadPicture(url = athlete.photoUrl!!, defaultImage = DEFAULT_ATHLETE_IMAGE).value
            image?.let { img ->
                Image(
                    painter = BitmapPainter(img.asImageBitmap()),
                    contentDescription = "empty_athlete",
                    modifier = Modifier
                        .height(160.dp)
                        .width(160.dp),
                    contentScale = ContentScale.Crop
                )

            }

        }

        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.Start)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Name: ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6

                )
                Text(text = "${athlete.name?.let { it } ?: ""} ${athlete.surname?.let { it } ?: ""}",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.subtitle1


                )

            }
            Spacer(
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "DOB: ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6

                )
                Text(
                    text = "${athlete.dateOfBirth?.let { it } ?: ""} ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.subtitle1


                )

            }
            Spacer(
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Weight: ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6

                )
                Text(
                    text = "${athlete.weight?.let { it } ?: ""} ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.subtitle1


                )

            }
            Spacer(
                modifier = Modifier.padding(top = 10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Height: ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6

                )
                Text(
                    text = "${athlete.height?.let { it } ?: ""} ",
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.subtitle1


                )

            }
        }


    }


}


@Composable
fun resultsView(athlete: Athlete) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Medals",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = MaterialTheme.typography.h6

        )

    }
    LazyColumn(modifier = Modifier.padding(10.dp)) {
        itemsIndexed(items = athlete.results) { index, result ->
            result.let {
                if(!athlete.results.isEmpty()){

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_circle),
                            contentDescription = "circle",
                            modifier = Modifier
                                .height(10.dp)
                                .width(10.dp)
                                .align(Alignment.CenterVertically)           ,
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "${result.city}",
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h6

                        )

                        Text(
                            text = "${result.gold}",
                            modifier = Modifier
                                .padding(start = 35.dp, end = 4.dp)
                                .align(Alignment.CenterVertically),

                            )

                        Image(
                            painter = painterResource(id = R.drawable.img_gold_medal),
                            contentDescription = "gold",
                            modifier = Modifier
                                .height(14.dp)
                                .width(14.dp)
                                .align(Alignment.CenterVertically)           ,
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "${result.silver}",
                            modifier = Modifier
                                .padding(start = 15.dp, end = 4.dp)
                                .align(Alignment.CenterVertically),

                            )

                        Image(
                            painter = painterResource(id = R.drawable.img_silver_medal),
                            contentDescription = "silver",
                            modifier = Modifier
                                .height(14.dp)
                                .width(14.dp)
                                .align(Alignment.CenterVertically)           ,
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "${result.bronze}",
                            modifier = Modifier
                                .padding(start = 15.dp, end = 4.dp)
                                .align(Alignment.CenterVertically),

                            )

                        Image(
                            painter = painterResource(id = R.drawable.img_bronze_medal),
                            contentDescription = "bronze",
                            modifier = Modifier
                                .height(14.dp)
                                .width(14.dp)
                                .align(Alignment.CenterVertically)           ,
                            contentScale = ContentScale.Crop
                        )





                    }
                }
            }
        }
    }

}

@Composable
fun bioView(athlete: Athlete) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Text(
            text = "Bio",
            modifier = Modifier
                .align(Alignment.CenterVertically),
            style = MaterialTheme.typography.h6

        )

    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            Text(text = "${athlete.bio?.let { it } ?: ""} ",
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.subtitle1


            )

        }
    }



}














