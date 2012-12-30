package plugins

import org.fusesource.scalate.TemplateEngine
import org.fusesource.scalate.util.{ ClassLoaders, FileResourceLoader, Resource }
import play.api.{ Application, GlobalSettings, Play, Plugin }

class ScalatePlugin(implicit app: Application) extends Plugin {

  override def onStart() {
    engine.resourceLoader = new FileResourceLoader(Some(Play.getFile("/app/views")))
    engine.classpath = Play.getFile("temp/classes").getAbsolutePath
    engine.workingDirectory = Play.getFile("temp")
    engine.combinedClassPath = true
    engine.classLoader = Play.classloader
  }

  override def onStop() {
  }

  lazy val engine = new TemplateEngine()

}