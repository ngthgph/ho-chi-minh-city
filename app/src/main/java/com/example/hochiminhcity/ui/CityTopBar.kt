package com.example.hochiminhcity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hochiminhcity.R
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme

@Composable
fun CityTopBar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    isShowingHomepage: Boolean,
    @StringRes topBarTitle: Int,
) {
    Surface(
        shadowElevation = dimensionResource(id = R.dimen.elevation),
        modifier = modifier
    ) {
        Row (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_medium))
                ){
            if (!isShowingHomepage) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.CenterVertically)

                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigation_back)
                    )
                }
            }
            Text(
                text = stringResource(topBarTitle),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )

        }
    }
}

@Preview
@Composable
fun DetailsTopBarPreview() {
    HoChiMinhCityTheme {
        CityTopBar(
            onBack = { /*TODO*/ },
            topBarTitle = R.string.app_name,
            isShowingHomepage = false)
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HoChiMinhCityTheme {
        CityTopBar(
            onBack = { /*TODO*/ },
            topBarTitle = R.string.app_name,
            isShowingHomepage = true)
    }
}