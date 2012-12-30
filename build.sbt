import ScalateKeys._

seq(scalateSettings:_*)

// Scalate Precompilation and Bindings
scalateTemplateConfig in Compile := Seq(
  TemplateConfig(
    file("app") / "views",
    List.empty,
    List.empty
  )
)