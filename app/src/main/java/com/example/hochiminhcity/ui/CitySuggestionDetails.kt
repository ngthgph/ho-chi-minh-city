package com.example.hochiminhcity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

@Composable
fun CitySuggestionDetails(
    suggestion: Suggestion,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.elevation)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Column (
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_large))
                ){
            Image(
                painter = painterResource(id = suggestion.image),
                contentDescription = stringResource(id = suggestion.name),
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .heightIn(max = dimensionResource(id = R.dimen.image_large_height))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))
            Text(
                text = stringResource(id = suggestion.description),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            )
        }
    }
}

@Preview
@Composable
fun DetailsPreview() {
    HoChiMinhCityTheme {
        CitySuggestionDetails(LocalSuggestionsProvider.coffeeSuggestions[7])
    }
}