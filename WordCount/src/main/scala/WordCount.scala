/**
 * Created by ndjidoardo.bar on 30/06/2015.
 */

import com.twitter.scalding._

class WordCountJob(args : Args) extends Job(args) {
  TextLine( args("input") )
    .flatMap('line -> 'word) { line : String => tokenize(line) }
    .filter('word) { word: String  => word.length > 1 && word != ""}
    .groupBy('word) { _.size }
    .groupAll{ _.sortBy(('size, 'word)).reverse }
    .write( Tsv( args("output") ) )

  // Split a piece of text into individual words.
  def tokenize(text : String) : Array[String] = {
    // Lowercase each word and remove punctuation.
    text.toLowerCase.replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+")
  }
}

