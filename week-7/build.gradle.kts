plugins {
    id("java")
}

group = "edu.penzgtu.oop"
version = "v1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jfree:jfreechart:1.5.4")
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.jar {
    val mainClassName = "edu.penzgtu.oop.Main"
    manifest.attributes["Main-Class"] = mainClassName
    val dependencies = configurations
            .runtimeClasspath
            .get()
            .map(::zipTree)
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}