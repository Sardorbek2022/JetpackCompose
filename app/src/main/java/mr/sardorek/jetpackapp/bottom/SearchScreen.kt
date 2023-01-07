package mr.sardorek.jetpackapp.bottom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import mr.sardorek.jetpackapp.R
import mr.sardorek.jetpackapp.util.Graph


@Composable
fun SearchScreen(navHostController: NavHostController) {
    val list = mutableListOf<Int>()
    repeat(100) {
        list.add(it)
    }
    LazyColumn(
        modifier = Modifier.padding(bottom = 55.dp)
    ) {
        itemsIndexed(list) { index, item ->
            Item(int = index) {
                navHostController.navigate("${Graph.DETAILS}/$item")
            }
        }
    }
}


