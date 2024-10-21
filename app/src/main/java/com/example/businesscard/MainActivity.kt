package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF2C313D)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ProfileImage()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Jack McFarland",
            style = MaterialTheme.typography.displaySmall,
            color = Color.White
        )
        Text(
            text = "Research Assistant",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.height(32.dp))
        ContactInfo()
    }
}

@Composable
fun ProfileImage() {
    // Display a placeholder image or your profile picture
    androidx.compose.foundation.Image(
        painter = painterResource(id = R.drawable.profile_picture),
        contentDescription = "Profile Image",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.White, shape = CircleShape),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ContactInfo() {
    Column {
        ContactInfoRow(icon = R.drawable.ic_phone, info = "(206)307-2376")
        ContactInfoRow(icon = R.drawable.ic_email, info = "jackmc@uw.edu")
        ContactInfoRow(icon = R.drawable.ic_location, info = "Seattle, Washington")
    }
}

@Composable
fun ContactInfoRow(icon: Int, info: String) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = info, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
