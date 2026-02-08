package ru.normno.material3expressiveguides.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.normno.material3expressiveguides.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SplitButtons() {
    SplitButtonLayout(
        leadingButton = {
            SplitButtonDefaults.LeadingButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_mode_edit_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(SplitButtonDefaults.LeadingIconSize),
                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp),
                )
                Text(
                    text = "Edit",
                )
            }
        },
        trailingButton = {
            var checked by remember {
                mutableStateOf(false)
            }
            val rotation by animateFloatAsState(
                targetValue = if (checked) {
                    180f
                } else {
                    0f
                },
                animationSpec = MaterialTheme.motionScheme.fastEffectsSpec(),
            )
            SplitButtonDefaults.TrailingButton(
                checked = checked,
                onCheckedChange = {
                    checked = it
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.stat_minus),
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer {
                            rotationZ = rotation
                        },
                )
            }
            DropdownMenu(
                expanded = checked,
                onDismissRequest = {
                    checked = false
                }
            ) {
                for (i in 1..10) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Item $i")
                        },
                        onClick = {
                            checked = false
                        }
                    )
                }
            }
        }
    )
}