@file:JvmName("ArticleItemKt")

package com.wearetriple.exercise6.ui.page.main.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nl.aldera.newsapp721447.R
import nl.aldera.newsapp721447.data.model.Article


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleItem(
    item: Article,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(80.dp)
                        .padding(8.dp),
                    model = item.Image,
                    contentDescription = stringResource(R.string.article_image_description),
                    contentScale = ContentScale.Fit
                )

                Column(Modifier.padding(end = 8.dp)) {
                    Text(
                        text = item.Title,
                        style = MaterialTheme.typography.headlineSmall
                    )
//                    Text(
//                        text = stringResource(
//                            R.string.exercise6_price,
//                            DecimalFormat("##.00").format(item.price)
//                        ),
//                        style = MaterialTheme.typography.bodyMedium,
//                        fontStyle = FontStyle.Italic
//                    )
                }
            }

            Text(
                modifier = Modifier.padding(8.dp),
                text = item.Summary ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}