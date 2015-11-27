val name = "equations"

lazy val buildSettings = Seq(
  organization := "com.github.kasonchan",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

lazy val compilerOptions = Seq(
  "-encoding", "UTF-8",
  "-feature"
)

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5",
  "org.scalatest" %% "scalatest" % "2.2.5"
)

val akkaStreamV = "1.0"

val baseSettings = Seq(
  libraryDependencies ++= testDependencies.map(_ % "test"),
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  ),
  scalacOptions in(Compile, console) := compilerOptions
)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishArtifact := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  homepage := Some(url("https://github.com/kasonchan/equations")),
  autoAPIMappings := true,
  apiURL := Some(url("https://kasonchan.github.io/equations/docs")),
  scmInfo := Some(
    ScmInfo(
      url("https://github.com/kasonchan/equations"),
      "scm:git:git@github.com:kasonchan/equations.git"
    )
  ),
  pomExtra :=
    <developers>
      <developer>
        <id>kasonchan</id>
        <name>Kason Chan</name>
        <url>https://github.com/kasonchan</url>
      </developer>
    </developers>
)

lazy val noPublish = Seq(
  publish := {},
  publishLocal := {},
  publishArtifact := false
)

lazy val allSettings = baseSettings ++ buildSettings ++ publishSettings

lazy val docSettings = site.settings ++ ghpages.settings ++ unidocSettings ++ Seq(
  site.addMappingsToSiteDir(mappings in(ScalaUnidoc, packageDoc), "docs"),
  git.remoteRepo := s"git@github.com:kasonchan/equations.git"
)

lazy val equations = project.in(file("."))
  .settings(moduleName := name)
  .settings(allSettings: _*)
  .settings(docSettings: _*)
  .settings(noPublish: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
  .aggregate(massbalance, monooperation)
  .dependsOn(massbalance, monooperation)

lazy val massbalance = project
  .settings(moduleName := name + "-" + "massbalance")
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )

lazy val monooperation = project
  .settings(moduleName := name + "-" + "monooperation")
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
