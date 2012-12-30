package plugins

import play.api.Play.current

object Scalate {
  
  def engine = {
    current.plugin[ScalatePlugin].head.engine
  }

}