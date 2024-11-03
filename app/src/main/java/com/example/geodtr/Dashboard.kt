package np.com.bimalkafle.geodtr

import CameraPage
//import MapPage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.geodtr.NavItem
import com.example.geodtr.pages.Account
import com.example.geodtr.pages.DTR
import com.example.geodtr.pages.MapPage

@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    val navItemList = listOf(
        NavItem("Map", Icons.Default.LocationOn),
        NavItem("DTR", Icons.Default.DateRange),
        NavItem("Account", Icons.Default.AccountCircle)
    )

    var selectedIndex by remember { mutableStateOf(0) }
    var timeInput by remember { mutableStateOf("") } // To hold the time from CameraPage

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.label) },
                        label = { Text(text = navItem.label) }
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(
            modifier = Modifier.padding(innerPadding),
            selectedIndex = selectedIndex,
            onNavigateToCamera = { onBack ->
                selectedIndex = 3 // Set to 3 to navigate to CameraPage
                onBack(timeInput) // Capture the time input when navigating back
            },
            onBack = { time ->
                timeInput = time // Store the time from CameraPage
                selectedIndex = 1 // Go back to DTR page
            }
        )
    }
}

@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    selectedIndex: Int,
    onNavigateToCamera: (onBack: (String) -> Unit) -> Unit,
    onBack: (String) -> Unit
) {
    when (selectedIndex) {
        0 -> MapPage(modifier = modifier) // Ensure MapPage accepts this modifier
        1 -> DTR(onNavigateToCamera = onNavigateToCamera) // Pass the callback
        2 -> Account()
        3 -> CameraPage(onBack = onBack) // Pass back navigation
    }
}