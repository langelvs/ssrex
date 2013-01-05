import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "ssrex"
  val appVersion      = "0.0.1-SNAPSHOT"

  val appDependencies = Seq(
      "io.netty" % "netty" % "3.6.1.Final",
      "org.fusesource.scalate" %% "scalate-core" % "1.6.1",
      "org.jsoup" % "jsoup" % "1.7.1"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
