import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}

import scala.collection.JavaConversions._
import scala.io.Source
import scala.tools.nsc

object WordSegmentation {

  def main(args: Array[String]): Unit = {
    val lines = Source.fromFile(args(0)).mkString
    val pipeline = new StanfordCoreNLP("CoreNLP-chinese.properties")
    val annotation = new Annotation(lines)

    pipeline.annotate(annotation)

    val sentences = annotation.get(classOf[CoreAnnotations.SentencesAnnotation])
    val words = sentences.map(sentence => sentence.get(classOf[CoreAnnotations.TokensAnnotation]).map(token => (
          token.getString(classOf[CoreAnnotations.PartOfSpeechAnnotation]),
          token.getString(classOf[CoreAnnotations.TextAnnotation]))))

    val filename = args(0).replace(".", "_s.")
    nsc.io.File(filename).writeAll(words.map(_.filter(_._1 != "PU").map(_._2).mkString(" ")).mkString("\r\n"))
  }
}
