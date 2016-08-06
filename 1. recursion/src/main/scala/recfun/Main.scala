package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("\nBalance: balance(List(4,3))")
    println(balance(List(4,3)))

    println("\ncountChange: countChange(6, List(3, 1, 2))")
    println(countChange(6, List(3, 1, 2)))
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {

    def loop(c: Int, r: Int): Int = {
      if(c < 0 || r < 0) 0
      else if(c == r) 1
      else {
        loop(c, r - 1) + loop(c - 1, r - 1)
      }
    }

    loop(c, r)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def loop(n: Int, chars: List[Char]): Boolean = {
      var m = n
      if(chars.isEmpty && n == 0) return true
      else {
        if(chars.head == '(') m = n + 1
        else if(chars.head == ')') m = n - 1

        if(m < 0) return false
      }

      loop(m, chars.tail)
    }

    loop(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money < 0 || coins.isEmpty)
      0
    else if(money == 0)
      1
    else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}
