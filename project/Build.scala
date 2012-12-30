import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "ssrex"
  val appVersion      = "0.0.1-SNAPSHOT"

  val appDependencies = Seq(
      "org.fusesource.scalate" %% "scalate-core" % "1.6.1"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
