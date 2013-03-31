import scala.util.parsing.combinator._

class Arith2 extends JavaTokenParsers {
  def expr: Parser[Double] = term~rep("+"~term | "-"~term) ^^ {
    case left~rest => {
      left + (rest).map({
        case "+"~term => term
        case "-"~term => -term
      }).sum
    }
  }
  def term: Parser[Double] = factor~rep("*"~factor | "/"~factor) ^^ {
    case left~rest => rest.foldLeft(left)((x, y) => {
      y match {
        case "*"~f => x * f
        case "/"~f => x / f
      }
    })
  }
  def factor: Parser[Double] = floatingPointNumber ^^ (_.toDouble)
}
