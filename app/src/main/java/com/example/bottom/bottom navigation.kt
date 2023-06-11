package com.example.bottom

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController

@Composable
fun MyBottomNavigation(navController: NavController){
    val destonationList = listOf<Destinations>( Login , Welcome)
    val selectedIndex = rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation() {
        destonationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = {Text(text = destinations.Title )},
                icon = { Icon(imageVector = destinations.icon, contentDescription = destinations.Title)},
                selected = index==selectedIndex.value ,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destonationList[index].Route){
                        popUpTo(Login.Route)
                        launchSingleTop = true
                    }
                })
        }
    }
}