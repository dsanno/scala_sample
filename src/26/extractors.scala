object EMail {
  def apply(user: String, domain: String) = user + "@" + domain
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1))
    } else {
      None
    }
  }
}

println(EMail("john", "example.com"))
println(EMail.unapply("John Smith"))
println(EMail.unapply("john@example.com"))

def getUser(s: String) = s match {
  case EMail(user, domain) => user
  case _ => null
}

println(getUser("john@example.com"))
println(getUser("John Smith"))

object Twice {
  def apply(s: String): String = s + s
  def unapply(s: String): Option[String] = {
    val length = s.length / 2
    val half = s.substring(0, length)
    if (half == s.substring(length)) {
      Some(half)
    } else {
      None
    }
  }
}

println(Twice("Hello!"))
println(Twice.unapply("runrun"))
println(Twice.unapply("Hello!"))

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}

println(UpperCase.unapply("Hello!"))
println(UpperCase.unapply("HELLO!"))

def filterUpper(s: String) = s match {
  case (x @ UpperCase()) => x
  case _ => null
}

println(filterUpper("Hello!"))
println(filterUpper("HELLO!"))

def userTwiceUpper(s: String) = s match {
  case EMail(Twice(x @ UpperCase()), domain) =>
    "match: " + x + " in domain " + domain
  case _ => "no match"
}

println(userTwiceUpper("DIDI@hotmail.com"))
println(userTwiceUpper("DIDO@hotmail.com"))
println(userTwiceUpper("didi@hotmail.com"))

object Domain {
  def apply(parts: String*): String =
    parts.reverse.mkString(".")
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}

def isTomInDotCom(s: String): Boolean = s match {
  case EMail("tom", Domain("com", _*)) => true
  case _ => false
}

println(isTomInDotCom("tom@sum.com"))
println(isTomInDotCom("peter@sum.com"))
println(isTomInDotCom("tom@acm.org"))

object ExpandedEMail {
  def unapplySeq(email: String): Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2) {
      Some(parts(0), parts(1).split("\\.").reverse)
    } else {
      None
    }
  }
}

val s = "tom@support.epfl.ch"
val ExpandedEMail(name, topdom, subdoms @ _*) = s;
println(name)
println(topdom)
println(subdoms)
