package ru.normno.material3expressiveguides

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.normno.material3expressiveguides.buttons.MultiChoiceButtonsGroup
import ru.normno.material3expressiveguides.buttons.SingleChoiceButtonsGroup
import ru.normno.material3expressiveguides.ui.theme.Material3ExpressiveGuidesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3ExpressiveGuidesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        SingleChoiceButtonsGroup()
                        Spacer(
                            modifier = Modifier
                                .height(
                                    128.dp,
                                )
                        )
                        MultiChoiceButtonsGroup()
                    }
                }
            }
        }
    }
}
