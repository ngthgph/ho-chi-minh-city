package com.example.hochiminhcity.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hochiminhcity.R
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme

@Composable
fun CityTopBar(
    onBack: () -> Unit,
    isShowingHomepage: Boolean,
    @StringRes topBarTitle: Int,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        if(!isShowingHomepage) {
            IconButton(
                onClick = onBack,
                modifier = Modifier.wrapContentSize()

            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.navigation_back))
            }
        } else {
            Spacer(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.padding_medium))
                    .padding(dimensionResource(id = R.dimen.padding_large))
            )
        }
        Row (
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
                ){
           Text(
               text = stringResource(topBarTitle),
               style = MaterialTheme.typography.titleLarge,
               color = MaterialTheme.colorScheme.primary
           )
        }
    }
}

@Preview
@Composable
fun DetailsTopBarPreview() {
    HoChiMinhCityTheme() {
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