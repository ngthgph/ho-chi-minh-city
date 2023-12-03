package com.example.hochiminhcity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hochiminhcity.R
import com.example.hochiminhcity.datasource.LocalSuggestionsProvider
import com.example.hochiminhcity.model.Suggestion
import com.example.hochiminhcity.ui.theme.HoChiMinhCityTheme
import com.example.hochiminhcity.ui.utils.CityContentType

@Composable
fun CitySuggestionDetails(
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
    contentType: CityContentType = CityContentType.LIST_ONLY,
    windowSize: WindowWidthSizeClass = WindowWidthSizeClass.Medium,
    suggestion: Suggestion,
) {
    BackHandler {
        onBack()
    }

    Card(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .fillMaxHeight(),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_large))
                ){
            if(contentType == CityContentType.LIST_AND_DETAIL) {
                Text(
                    text = stringResource(id = suggestion.name),
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(bottom = dimensionResource(id = R.dimen.padding_large))
                        .align(Alignment.CenterHorizontally)
                )
            }
            Image(
                painter = painterResource(id = suggestion.image),
                contentDescription = stringResource(id = suggestion.name),
                modifier =
                if (
                    windowSize == WindowWidthSizeClass.Compact
                ) {
                    Modifier
                        .clip(MaterialTheme.shapes.small)
                        .heightIn(max = dimensionResource(id = R.dimen.image_large_height))
                        .align(Alignment.CenterHorizontally)
                } else {
                    Modifier
                        .clip(MaterialTheme.shapes.small)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .weight(1f)
                },
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))
            Text(
                text = stringResource(id = suggestion.description),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                modifier =
                if (
                    windowSize == WindowWidthSizeClass.Compact
                ) {
                    Modifier
                        .verticalScroll(rememberScrollState())
                } else {
                    Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(1f)
                },
            )
        }
    }
}

@Preview
@Composable
fun DetailsPreview() {
    HoChiMinhCityTheme {
        CitySuggestionDetails(onBack = {}, suggestion = LocalSuggestionsProvider.coffeeSuggestions[7])
    }
}