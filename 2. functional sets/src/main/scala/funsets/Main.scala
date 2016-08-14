package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  val x = singletonSet(1)
  val y = singletonSet(2)
  val z = singletonSet(3)
  val w = union(union(x, z), y)

  println("\nx: ")
  printSet(x)

  println("\ny: ")
  printSet(y)

  println("\nz: ")
  printSet(z)

  println("\nw: ")
  printSet(w)

  println("\nforall(x,w): " + forall(x,w))

  println("\nintersect(w, y): ")
  printSet(intersect(w, y))

  println("\ndiff(w, y): ")
  printSet(diff(w, y))
}
