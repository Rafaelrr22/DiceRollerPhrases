package com.example.dicerollerphrases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerphrases.ui.theme.DiceRollerPhrasesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerPhrasesTheme {
                DiceWithButtonAndImage(
                        modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    var numeroDados by remember { mutableStateOf(1) }

    val motivationalPhrases = listOf(
            stringResource(R.string.phrase1),
            stringResource(R.string.phrase2),
            stringResource(R.string.phrase3),
            stringResource(R.string.phrase4),
            stringResource(R.string.phrase5),
            stringResource(R.string.phrase6)
    )

    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val imageResource2 = when (result2) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
    ) {
        Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString()
        )

        if (numeroDados == 2) {
            Image(
                    painter = painterResource(imageResource2),
                    contentDescription = result2.toString()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = motivationalPhrases[result - 1])

        Button(
                onClick = {
                    result = (1..6).random()
                    result2 = (1..6).random()
                }
        ) {
            Text(text = stringResource(R.string.roll))
        }

        Button(
                onClick = {
                    numeroDados = if (numeroDados == 1) 2 else 1
                }
        ) {
            Text(
                    text = if (numeroDados == 1) {
                        stringResource(R.string.dois)
                    } else {
                        stringResource(R.string.um)
                    }
            )
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}