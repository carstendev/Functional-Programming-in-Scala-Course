// Copyright (C) 2011-2012 the original author or authors.
// See the LICENCE.txt file distributed with this work for additional
// information regarding copyright ownership.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package recfun

import java.util.Deque
import java.util.ArrayDeque

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(column: Int, row: Int): Int = {

    if (row == 0) {
      0
    } else if (column == row) {
      1
    } else {
      pascal(column - 1, row - 1) + pascal(column, row - 1)
    }

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balance(chars: List[Char], deque: ArrayDeque[Char]): Boolean = {
      if (chars.isEmpty) { // Keine Chars mehr zu prüfen
        return deque.size() == 0
      } else if (chars.head == '(') {
        deque.push(chars.head)
      } else if (chars.head == ')') {
        if (deque.isEmpty()) {
          return false
        }
        deque.pop()
        if (chars.isEmpty) {
          return deque.size() == 0
        }
      }
      return balance(chars.tail, deque)
    }

    val deque = new ArrayDeque[Char]();
    balance(chars, deque)
  }

  /**
   * Exercise 3
   */
   def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0)
      0
    else if (coins.isEmpty)
      if (money == 0) 1 else 0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
  
}
