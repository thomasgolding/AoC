import java.io.File
import java.io.InputStream

fun main() {

    val numberstream: InputStream = File("day01.txt").inputStream()
    val numberlist = mutableListOf<Int>()

    numberstream.bufferedReader().forEachLine {it -> numberlist.add(it.toInt())}
    
    val imax: Int = numberlist.size
    var a: Int=0
    var b: Int=0

    var a2: Int=0
    var b2: Int=0
    var c2: Int=0

    for ((i, num1) in numberlist.withIndex()) {
  
        for ((i2,num2) in numberlist.slice(i..imax-1).withIndex()) {
            if (num1+num2 == 2020) {
                a = num1
                b = num2
            }
            for (num3 in numberlist.slice(i+i2..imax-1)) {
                
                if (num1+num2+num3 == 2020) {
                    a2 = num1
                    b2 = num2
                    c2 = num3
                }

            }
        }        
    }

    println("Part 1")
    println(a*b)

    println()
    println("Part 2")
    println(a2*b2*c2)




}

