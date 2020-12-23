import java.io.File
import java.io.InputStream

class Password(
    val policypw: String
) {
    var nMin: Int = 0
    var nMax: Int = 0
    var character: Char = '-'
    var pw: String = ""

    init {
        var policypwwords = policypw.split("-", " ", ": ")
        nMin = policypwwords[0].toInt()
        nMax = policypwwords[1].toInt()
        character = policypwwords[2].single() // single converts to char-type
        pw = policypwwords[3]
    }


    fun is_valid(): Boolean {
        val nchar: Int = pw.filter{it == character}.length
        var valid = false
        if ((nMin <= nchar) && (nMax >= nchar)) {
            valid = true 
        }
        return valid
    }

    fun dummy() {
        println("dummyfunc")
        println("nMin = $nMin")
        println("nMax = $nMax")
        println("char = $character")
        println("pw = $pw")
    }
}


fun main() {
    
    val fstream: InputStream = File("day02.txt").inputStream()
    val linelist = mutableListOf<String>()
    fstream.bufferedReader().forEachLine {it -> linelist.add(it)}

    
    var n_good = 0
    for (l in linelist) {
        val pw = Password(l)
        if (pw.is_valid()) {
            n_good = n_good + 1
        }
    }
    
    println(n_good)
    
    // val obj = Password("1-3 a: ffaaasssras")
    // println(obj.is_valid())


}