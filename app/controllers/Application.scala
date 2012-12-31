package controllers

import play.api.mvc.{ Action, Controller }
import plugins.Scalate.engine

object Application extends Controller {
  
  def index = Action {
    Ok("Prueba de templates").as("text/html")
  }
  
  def jade = Action {
    Ok(engine.layout("/views/jade/index.jade")).as("text/html")
  }
  
  def scaml = Action {
    Ok(engine.layout("/views/scaml/index.scaml")).as("text/html")
  }
  
}