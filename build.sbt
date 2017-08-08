name := "scala-chinese-word-segmentation"

version := "0.1"

scalaVersion := "2.11.11"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-compiler" % "2.11.11",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.8.0",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.8.0" classifier "models",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.8.0" classifier "models-chinese"
)
        