def findSubstrings(w, p){
    def j = w.join " "
    p = p.grep j.&count groupBy{it.size()}
    w.collect{e->
        (5..1).any{          
            w = ([0] + p[it] - null).max{
                ~e.indexOf(it) ?: -99
            }
        } ? e.replaceFirst(w, "[$w]") : e
    }
}

println(findSubstrings(["Apple",
 "Melon",
 "Orange",
 "Watermelon"],
["a",
 "mel",
 "lon",
 "el",
 "An"]))