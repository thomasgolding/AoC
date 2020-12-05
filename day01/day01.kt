import java.io.File
import java.io.InputStream

fun main() {

    val numberstream: InputStream = File("day01.txt").inputStream()
    val numberlist = mutableListOf<Int>()

    numberstream.bufferedReader().forEachLine {it -> numberlist.add(it.toInt())}
    
    val imax: Int = numberlist.size
    var a: Int=-1
    var b: Int=-1

    for ((i, num1) in numberlist.withIndex()) {
        for (num2 in numberlist.slice(i..imax-1)) {
            if (num1+num2 == 2020) {
                a=num1
                b=num2
            }
        }        
    }

    println(a*b)
    

}

