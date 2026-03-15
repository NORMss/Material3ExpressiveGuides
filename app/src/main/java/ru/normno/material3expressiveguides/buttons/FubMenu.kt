package ru.normno.material3expressiveguides.buttons

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButtonMenu
import androidx.compose.material3.FloatingActionButtonMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.normno.material3expressiveguides.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FunMenu(
    modifier: Modifier = Modifier,
) {
    var expended by remember {
        mutableStateOf(false)
    }
    FloatingActionButtonMenu(
        expanded = expended,
        button = {
            ToggleFloatingActionButton(
                checked = expended,
                onCheckedChange = {
                    expended = it
                },
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(
                        id = if (expended) R.drawable.baseline_add_24 else R.drawable.baseline_close_24,
                    ),
                    contentDescription = null,
                    tint = if (expended) {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    } else {
                        MaterialTheme.colorScheme.onPrimaryContainer
                    }
                )
            }
        }
    ) {
        items.forEach { fab ->
            FloatingActionButtonMenuItem(
                onClick = {
                    expended = false
                },
                text = {
                    Text(
                        text = fab.text,
                    )
                },
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(fab.iconRes),
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

val items = listOf(
    FamItem(
        text = "Alarm",
        iconRes = R.drawable.baseline_access_alarm_24,
    ),
    FamItem(
        text = "Task",
        iconRes = R.drawable.baseline_task_alt_24,
    ),
    FamItem(
        text = "Event",
        iconRes = R.drawable.baseline_calendar_month_24,
    ),
)

data class FamItem(
    val text: String,
    val iconRes: Int,
)
