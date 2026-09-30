package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.ChangeCircle
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.components.HexagramDetailSheet
import com.example.ui.screens.DivinationScreen
import com.example.ui.screens.GuideScreen
import com.example.ui.screens.HexagramExplorerScreen
import com.example.ui.screens.HexagramSearchScreen
import com.example.ui.screens.JournalScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.theme.ImperialGold
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.IChingViewModel

enum class IChingTab(val label: String, val icon: ImageVector, val tag: String) {
    CAST("Divination", Icons.Default.ChangeCircle, "tab_cast"),
    EXPLORER("64 Hexagrams", Icons.Default.GridView, "tab_explorer"),
    JOURNAL("Journal", Icons.Default.AutoStories, "tab_journal"),
    GUIDE("Wisdom", Icons.AutoMirrored.Filled.MenuBook, "tab_guide")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                IChingApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IChingApp(
    viewModel: IChingViewModel = viewModel()
) {
    val userProfile by viewModel.userProfile.collectAsState()
    val isEditingProfile by viewModel.isEditingProfile.collectAsState()
    var currentTab by rememberSaveable { mutableStateOf(IChingTab.CAST) }
    val inspectedHexagram by viewModel.inspectedHexagram.collectAsState()
    val isSearchActive by viewModel.isSearchActive.collectAsState()

    if (!userProfile.isCompleted || isEditingProfile) {
        ProfileScreen(
            viewModel = viewModel,
            isFirstLaunch = !userProfile.isCompleted,
            onNavigateToDivination = {
                viewModel.closeProfileEditor()
                currentTab = IChingTab.CAST
            },
            onBack = if (userProfile.isCompleted) {
                { viewModel.closeProfileEditor() }
            } else null
        )
    } else {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (!isSearchActive) {
                    TopAppBar(
                        title = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "易經",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(
                                    text = "I Ching",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = { viewModel.openSearch() },
                                modifier = Modifier.testTag("top_bar_search_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search hexagrams",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                }
            },
            bottomBar = {
                if (!isSearchActive) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        tonalElevation = 6.dp
                    ) {
                        IChingTab.entries.forEach { tab ->
                            val isSelected = currentTab == tab
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { currentTab = tab },
                                icon = {
                                    Icon(
                                        imageVector = tab.icon,
                                        contentDescription = tab.label
                                    )
                                },
                                label = {
                                    Text(
                                        text = tab.label,
                                        fontSize = 11.sp
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                modifier = Modifier.testTag(tab.tag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            if (isSearchActive) {
                HexagramSearchScreen(
                    viewModel = viewModel,
                    onClose = { viewModel.closeSearch() },
                    modifier = Modifier.padding(innerPadding)
                )
            } else {
                when (currentTab) {
                    IChingTab.CAST -> DivinationScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                    IChingTab.EXPLORER -> HexagramExplorerScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                    IChingTab.JOURNAL -> JournalScreen(
                        viewModel = viewModel,
                        onNavigateToCast = { currentTab = IChingTab.CAST },
                        modifier = Modifier.padding(innerPadding)
                    )
                    IChingTab.GUIDE -> GuideScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            // Global Detail Bottom Sheet for Hexagram inspection
            inspectedHexagram?.let { hex ->
                HexagramDetailSheet(
                    hexagram = hex,
                    onDismiss = { viewModel.inspectHexagram(null) }
                )
            }
        }
    }
}

/**
 * Retained for test compatibility with GreetingScreenshotTest
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun IChingAppPreview() {
    MyApplicationTheme {
        IChingApp()
    }
}
