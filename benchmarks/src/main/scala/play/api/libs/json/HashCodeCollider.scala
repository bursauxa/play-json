/**
 * Original code at: https://github.com/plokhotnyuk/jsoniter-scala/blob/bb4837d/jsoniter-scala-benchmark/src/main/scala/com/github/plokhotnyuk/jsoniter_scala/macros/HashCodeCollider.scala
 *
 * MIT License
 *
 * Copyright (c) 2017 Andriy Plokhotnyuk, and respective contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package play.api.libs.json

import scala.collection.mutable.ArrayBuffer

object HashCodeCollider {
  val zeroHashCodeStrings: collection.Seq[String] = {
    val cs = new ArrayBuffer[String](2 * 1024 * 1024)
    var i0 = 33
    while (i0 < 127) {
      val h0 = i0 * 31
      if (i0 != '\\' && i0 != '"') {
        var i1 = 33
        while (i1 < 127) {
          val h1 = (h0 + i1) * 31
          if (i1 != '\\' && i1 != '"') {
            var i2 = 33
            while (i2 < 127) {
              val h2 = (h1 + i2) * 31
              if ((((h2 + 32) * 923521) ^ ((h2 + 127) * 923521)) < 0 && i2 != '\\' && i2 != '"') {
                var i3 = 33
                while (i3 < 127) {
                  val h3 = (h2 + i3) * 31
                  if ((((h3 + 32) * 29791) ^ ((h3 + 127) * 29791)) < 0 && i3 != '\\' && i3 != '"') {
                    var i4 = 33
                    while (i4 < 127) {
                      val h4 = (h3 + i4) * 31
                      if ((((h4 + 32) * 961) ^ ((h4 + 127) * 961)) < 0 && i4 != '\\' && i4 != '"') {
                        var i5 = 33
                        while (i5 < 127) {
                          val h5 = (h4 + i5) * 31
                          if ((((h5 + 32) * 31) ^ ((h5 + 127) * 31)) < 0 && i5 != '\\' && i5 != '"') {
                            var i6 = 33
                            while (i6 < 127) {
                              val h6 = (h5 + i6) * 31
                              if (((h6 + 32) ^ (h6 + 127)) < 0 && i6 != '\\' && i6 != '"') {
                                var i7 = 33
                                while (i7 < 127) {
                                  if (h6 + i7 == 0 && i7 != '\\' && i7 != '"') {
                                    cs += s"${i0.toChar}${i1.toChar}${i2.toChar}${i3.toChar}${i4.toChar}${i5.toChar}${i6.toChar}${i7.toChar}"
                                  }
                                  i7 += 1
                                }
                              }
                              i6 += 1
                            }
                          }
                          i5 += 1
                        }
                      }
                      i4 += 1
                    }
                  }
                  i3 += 1
                }
              }
              i2 += 1
            }
          }
          i1 += 1
        }
      }
      i0 += 1
    }
    cs
  }
}
