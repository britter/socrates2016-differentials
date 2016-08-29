/*
 * Copyright 2016 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.britter.differentials

object Differentials {

  type Differential = Float => Float

  type t       = Float
  type wert    = Float
  type Loesung = Array[(t, wert)]

  def solveDifferentialEquation(startwert: Float,
                                ableitung: Differential): Loesung = {
    val firstTimeValuePair = (0f, startwert)

    val dt: Float = 1f / 1000f
    var solution = Array(firstTimeValuePair)

    val tuples = for (i <- 1 until 10) yield {
      val lastTimeValue: t        = solution(i - 1)._1
      val lastFunctionValue: wert = solution(i - 1)._2
      solution = solution :+ (lastTimeValue + dt, ableitung(lastFunctionValue) * dt + lastFunctionValue)
    }
    solution
  }

  def main(args: Array[String]): Unit = {
    val funktionsApproximation: Loesung =
      solveDifferentialEquation(1, v => v * 1.1f)

    val ersterFunktionswert: (t, wert)  = funktionsApproximation(0)
    val zweiterFunktionswert: (t, wert) = funktionsApproximation(1)
    val thirdFunktionswert: (t, wert)   = funktionsApproximation(2)

    println(ersterFunktionswert)
    println(
        s"actual: $zweiterFunktionswert expected: ${ Math.exp(1.1 * zweiterFunktionswert._1) }"
    )
    println(
        s"actual: $thirdFunktionswert expected: ${ Math.exp(1.1 * thirdFunktionswert._1) }"
    )

    println(funktionsApproximation.length)

    /*
    require(ersterFunktionswert._2 == Math.exp(1.1 * ersterFunktionswert._1))
    require(zweiterFunktionswert._2 == Math.exp(1.1 * zweiterFunktionswert._1))
    require(ersterFunktionswert._1 < zweiterFunktionswert._1)
   */
  }
}

/*
(x(0), (dx/dt = f(x) DGL )) => (x(time))

bv(0) = 80*10^6
wert zur Zeit (t+dt) - wert zur Zeit t = 1.1 * wert *dt
[(0, startwert), (1/1000, ?)]
? - startwert (in zeile 18 = 1) = 1,1* startwert *dt
?  = 1,1* startwert *dt + startwert (in zeile 18 = 1)
  
 */
