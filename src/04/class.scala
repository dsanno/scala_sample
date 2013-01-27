class ChecksumAccumulator {
  var sum = 0
}

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator
acc.sum = 3
println(acc.sum)
println(csa.sum)
// acc is defined as val so error will occur at thie line
// acc = new ChecksumAccumulator
