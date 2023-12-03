package com.example.hochiminhcity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.hochiminhcity.R
import com.example.hochiminhcity.datasource.LocalCategoriesProvider
import com.example.hochiminhcity.model.Category
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme

@Composable
fun CityCategories(
    onCategoryClicked: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(LocalCategoriesProvider.categories) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .clickable(
                        onClick = {onCategoryClicked(it)}
                    )
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = it.image),
                        contentDescription = stringResource(id = it.name),
                        modifier = Modifier
                            .size(dimensionResource(id = R.dimen.image_size_medium)),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = stringResource(id = it.name),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .weight(1f)
                            .padding(dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HoChiMinhCityTheme {
        CityCategories(onCategoryClicked = { /*TODO*/ })
    }
}