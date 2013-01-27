class ChecksumAccumulator {
  private var sum = 0
}

val acc = new ChecksumAccumulator
// error will occur because sum is private.
acc.sum = 5;
