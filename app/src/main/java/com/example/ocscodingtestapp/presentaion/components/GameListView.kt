package com.example.ocscodingtestapp.presentaion.components

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigator
import com.example.ocscodingtestapp.di.NetworkModule
import com.example.ocscodingtestapp.domain.model.Athlete
import com.example.ocscodingtestapp.domain.model.Game
 import com.example.ocscodingtestapp.util.DEFAULT_ATHLETE_IMAGE
import com.example.ocscodingtestapp.util.loadPicture
import javax.inject.Inject
import javax.inject.Named
import com.example.ocscodingtestapp.R


@Composable
fun GameList(loading: Boolean, games: List<Game> ,navController: NavController) {

    Box() {

        LazyColumn(modifier = Modifier.padding(top=20.dp, bottom = 20.dp)) {

          var  sortedGames=   games.sortedByDescending { it.year }

            itemsIndexed(items = sortedGames) { index, game ->
                GameView(game = game,navController)
            }
        }
        CircularProgressBar(isLoading = loading)
    }
}


@Composable
fun GameView(game: Game,navController: NavController) {
    //some games have no athlete, so no need  to show it in the list with empty athlete.

    game.athletesList.let {
        if (!game.athletesList.isEmpty()) {
            Column(modifier = Modifier.padding(start = 20.dp)) {
                game.city?.let { city ->
                    Text(
                        text = "$city ${game.year}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )
                    Spacer(
                        modifier = Modifier.padding(top = 10.dp)
                    )

                    LazyRow() {
                        itemsIndexed(items = game.athletesList) { index, athlete ->
                            AthleteCard(athlete, onClick = {
                                val bundle = Bundle()
                                bundle.putString("athleteId", athlete.id)
                                navController.navigate(R.id.toAthleteDetail,bundle)
                            })
                        }
                    }

                }


            }

        }
    }

}


@Composable
fun AthleteCard(athlete: Athlete,onClick:()-> Unit ) {

        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(6.dp)
                .fillMaxWidth()
                .clickable (true, onClick = onClick),
            elevation = 8.dp
        ) {
            Column() {

                Box() {

                    val image = loadPicture(url = athlete.photoUrl!!, defaultImage = DEFAULT_ATHLETE_IMAGE).value
                    image?.let { img->
                        Image(
                            painter = BitmapPainter(img.asImageBitmap()),
                            contentDescription = "empty_athlete",
                            modifier = Modifier
                                .height(150.dp)
                                .width(180.dp),
                            contentScale = ContentScale.Crop
                        )

                    }

                athlete.name?.let { name->
                        Text(text = "$name ${athlete.surname?.let { it }?: "" }  ",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                                .wrapContentWidth(Alignment.CenterHorizontally)
                                .align(Alignment.BottomCenter),
                            style = MaterialTheme.typography.h6, color = Color.White

                        )


                }
                }
            }



    }

}
