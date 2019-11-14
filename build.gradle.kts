plugins {
  scala
  application
}

application {
    mainClassName = "GameOfLife"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.scala-lang:scala-library:2.12.0")
  testImplementation("org.scalatest:scalatest_2.12:3.2.0-SNAP10")
  testImplementation("junit:junit:4.12")  
}

sourceSets {
  main {
    withConvention(ScalaSourceSet::class) {
      scala {
        setSrcDirs(listOf("src"))
      }
    }
  }
  test {
    withConvention(ScalaSourceSet::class) {
      scala {
        setSrcDirs(listOf("test"))
      }
    }
  }
}


tasks.withType<ScalaCompile> {
  sourceCompatibility = "1.8"
}

defaultTasks("clean", "test")