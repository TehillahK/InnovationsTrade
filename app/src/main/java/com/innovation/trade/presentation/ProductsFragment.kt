package com.innovation.trade.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.innovation.trade.R
import com.innovation.trade.objects.Product

class ProductsFragment() : Fragment(R.layout.product_list_fragment) {
    private var productList = listOf<Product>( Product(name = "Level up", description ="Lorem ipsum dolor sit amet " , price = "K100"),
        Product(name = "Level up", description ="Lorem ipsum dolor sit amet, consectetur adipiscing elit, . " , price = "K100"),
        Product(name = "Level up", description ="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco commodo consequat. " , price = "K100"))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {

                Column {
                    SearchField()
                    ProductsInput(products = productList)
                }

            }
        }
    }
    @Preview
    @Composable
    fun SearchField(){
        var queries = remember{mutableStateOf("product")}
        var text=""
        TextField(
            value = queries.value,
            onValueChange = { queries.value=it},
            label = { Text("Label") },
            modifier = Modifier.fillMaxWidth()
        )

    }



    @Composable
    fun ProductsInput(products: List<Product>)
    {
        LazyColumn() {
            items(products.size){
                products.forEach { product -> ProductTemplate(name = product.name,
                    description = product.description, price = product.price)
                }
            }
        }
    }
    @Composable
    fun ProductTemplate(name: String,description: String,price: String){
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            Image(painter = painterResource(R.drawable.ic_launcher_background) ,
                contentDescription = "",
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = name,
                style= MaterialTheme.typography.h6
            )
            Text(text = description,
                style= MaterialTheme.typography.body2

            )
            Text(
                text="Price: $price",
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
            Button(

                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()

            ) {
                Text(text = "Contact seller")
            }
        }
    }

}