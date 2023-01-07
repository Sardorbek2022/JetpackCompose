package mr.sardorek.jetpackapp.splash

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import mr.sardorek.jetpackapp.ui.theme.Purple40
import mr.sardorek.jetpackapp.util.Graph


@Composable
fun SplashScreen(navHostController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(targetValue = Color.Green)
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(1200L)
//        navHostController.popBackStack()
        navHostController.navigate(Graph.MAIN) {
            launchSingleTop = true
            popUpTo(Graph.SPLASH)
        }
    }
    Splash(color)
}

@Composable
fun Splash(color: Color) {
    Box(
        modifier = Modifier
            .background(color)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = mr.sardorek.jetpackapp.R.drawable.img),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(200.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = mr.sardorek.jetpackapp.R.string.app_name),
                fontSize = 25.sp,
                color = Purple40,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic
            )
        }
    }
}