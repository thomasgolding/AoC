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

    
    fun is_valid2(): Boolean {
        var valid = false
        val cond1 = pw[nMin-1] == character
        val cond2 = pw[nMax-1] == character
        if ((cond1 || cond2) && ! (cond1 && cond2)) {
            valid = true
        }

        return valid
    }

}


fun main() {
    
    val fstream: InputStream = File("day02.txt").inputStream()
    val linelist = mutableListOf<String>()
    fstream.bufferedReader().forEachLine {it -> linelist.add(it)}

    var n_good = 0
    var n_good2 = 0
    for (l in linelist) {
        val pw = Password(l)
        if (pw.is_valid()) {
            n_good = n_good + 1
        } 
        if (pw.is_valid2()) {
            n_good2 = n_good2 + 1
        }
    }

    println("part 1: $n_good")
    println("part 2: $n_good2")


   
}