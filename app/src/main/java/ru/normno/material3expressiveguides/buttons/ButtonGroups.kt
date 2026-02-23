package ru.normno.material3expressiveguides.buttons

import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.normno.material3expressiveguides.R

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SingleChoiceButtonsGroup(modifier: Modifier = Modifier) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    ButtonGroup(
        overflowIndicator = {
            FilledTonalIconButton(
                onClick = {
                    it.show()
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.more_vert_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                    contentDescription = null,
                )
            }
        }
    ) {
        for (i in 0 until 5){
            val checked = i == selectedIndex
            this.toggleableItem(
                checked = checked,
                label = "Item $i",
                onCheckedChange = {
                    selectedIndex = i
                },
                icon = if (checked) {
                    {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                R.drawable.check_24dp_1f1f1f_fill0_wght400_grad0_opsz24,
                            ),
                            contentDescription = null,
                        )
                    }
                } else null,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultiChoiceButtonsGroup(modifier: Modifier = Modifier) {
    val selectedIndices = remember {
        mutableStateListOf<Int>()
    }
    ButtonGroup(
        overflowIndicator = {
            FilledTonalIconButton(
                onClick = {
                    it.show()
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.more_vert_24dp_1f1f1f_fill0_wght400_grad0_opsz24),
                    contentDescription = null,
                )
            }
        }
    ) {
        for (i in 0 until 5){
            val checked = i in selectedIndices
            this.toggleableItem(
                checked = checked,
                label = "Item $i",
                onCheckedChange = { newChecked ->
                    if (i in selectedIndices) {
                        selectedIndices.remove(i)
                    } else {
                        selectedIndices.add(i)
                    }
                },
                icon = if (checked) {
                    {
                        Icon(
                            imageVector = ImageVector.vectorResource(
                                R.drawable.check_24dp_1f1f1f_fill0_wght400_grad0_opsz24,
                            ),
                            contentDescription = null,
                        )
                    }
                } else null,
            )
        }
    }
}
