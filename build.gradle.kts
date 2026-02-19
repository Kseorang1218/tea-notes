// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // TOML의 [plugins] 섹션에 정의된 이름을 정확히 참조해야 합니다.
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false  // 'jetbrains'를 제거했습니다.
    alias(libs.plugins.ksp) apply false            // Room/Hilt 컴파일용
    alias(libs.plugins.hilt) apply false           // 의존성 주입용
}