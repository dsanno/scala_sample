object Identifier extends RegexParsers {
  val ident: Parser[String] = """[a-zA-Z_]\w*""".r
}
