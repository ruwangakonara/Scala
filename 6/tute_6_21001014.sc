


object Ceaser extends App{

  def encryption(text: String, shift: Int): String = if (text.length == 0) "" else (text.head + shift).toChar.toString + encryption(text.tail, shift)

  def decryption(text: String, shift: Int): String = if (text.length == 0) "" else (text.head - shift).toChar.toString + decryption(text.tail, shift)

  def transformer(text: String, shift: Int)(da_function: (String, Int) => String): String = da_function(text, shift)

  def main() = {
    println("Encrypt or Decrypt?")
    var choice = scala.io.StdIn.readChar().toLower
    choice match {
      case 'e'=> {
        println("Text:")
        var text = scala.io.StdIn.readLine()
        println("Shift:")
        var shift = scala.io.StdIn.readInt()

        println("Encrypted Text: " + transformer(text, shift)(encryption))
      }

      case 'd' => {
        println("Text:")
        var text = scala.io.StdIn.readLine()
        println("Shift:")
        var shift = scala.io.StdIn.readInt()

        println("Decrypted Text: " + transformer(text, shift)(decryption))
      }
      case _ => println("Invalid Input")
    }
  }

  main()

}