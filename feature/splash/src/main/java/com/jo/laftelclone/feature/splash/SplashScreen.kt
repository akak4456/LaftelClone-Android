package com.jo.laftelclone.feature.splash

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jo.laftelclone.core.designsystem.component.LocalClickHandlers
import com.jo.laftelclone.core.designsystem.theme.LaftelCloneTheme
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen() {
    val handlers = LocalClickHandlers.current
    LaunchedEffect(Unit) {
        /*
        현재는 3초간 splash 화면을 보여주고 main 화면으로 이동하는 것으로 구현함
        TODO 나중에 스플래시 화면에서 앱 시작에 필요한 초기화 설정 하기
         */
        delay(3000)
        handlers.onNavigateToMain()
    }
    SplashScreenInner()
}

@Composable
private fun SplashScreenInner() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center // 정가운데 정렬
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_laftel), // 이미지 리소스
            contentDescription = "중앙 이미지",
            contentScale = ContentScale.Fit, // 비율 유지하며 맞춤
            modifier = Modifier
                .width(150.dp)
                .testTag("logoImage")
        )
    }
}

@Preview
@Composable
internal fun SplashScreenPreview() {
    LaftelCloneTheme {
        SplashScreenInner()
    }
}