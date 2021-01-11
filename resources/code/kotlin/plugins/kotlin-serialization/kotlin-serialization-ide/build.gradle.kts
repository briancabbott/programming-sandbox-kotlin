
description = "Kotlinx Serialization IDEA Plugin"

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

dependencies {
    compileOnly(project(":js:js.translator"))

    compile(project(":kotlinx-serialization-compiler-plugin"))
    compile(project(":idea"))
    compile(project(":idea:idea-gradle"))
    compile(project(":idea:idea-maven"))
    compile(project(":plugins:annotation-based-compiler-plugins-ide-support"))
    compileOnly(intellijDep())
    compileOnly(intellijPluginDep("java"))
    excludeInAndroidStudio(rootProject) { compileOnly(intellijPluginDep("maven")) }
    compileOnly(intellijPluginDep("gradle"))

    testCompileOnly(intellijDep())
    testRuntimeOnly(intellijDep())
}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

runtimeJar()

projectTest(parallel = true) {

}