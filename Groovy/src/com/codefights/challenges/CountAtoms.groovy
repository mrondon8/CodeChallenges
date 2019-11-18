package com.codefights.challenges
/*
The International Union of Pure and Applied Chemistry needs your help!

Here is the problem: you are provided a molecular structure (a string) containing the symbols of chemical elements, numbers and possibly parentheses. For example, NaCl, H2O or Ca(OH)2.

Given the string molecule, your task is to find how many atoms of each element are contained in the molecule. Return the result in the form [element1][amount1][element2][amount2]..., sorted alphabetically.

Example

For molecule = "NaCl", the output should be countAtoms(molecule) = "Cl1Na1".

This molecule contains 1 atom of Na and 1 atom of Cl, so in alphabetical order, the result is "Cl1Na1".

For molecule = "Ca(OH)2", the output should be countAtoms(molecule) = "Ca1H2O2".

Since there are 2 OHs, the total counts are 1 Ca, 2 Os, and 2 Hs, so the answer is "Ca1H2O2".

For molecule = "Al2(SO4)3", the output should be countAtoms(molecule) = "Al2O12S3".

There are 3 SO4 groups, which makes 4 S and 12 O atoms, and there are also 2 Als at the front, so the result is "Al2O12S3".

For molecule = "[Cu(NH3)4(H2O)2]SO4", the output should be countAtoms(molecule) = "Cu1H16N4O6S1".

In total there's 1 Cu, 4 N, 12 + 4 = 16 H 2 + 4 = 6 O and 1 S, so the result is "Cu1H16N4O6S1".
 */
/* 188
T countAtoms(m){
    T h = [:].withDefault{0}
    T r = ""
    ((m-"["-"]").replaceAll(/\((.+?)\)(\d*)/){a,b,c->
        b * (c as int)
    } =~ /([A-Z][a-z]?)(\d*)/).each{a,b,c->
        h[b] += c ? c as int : 1
    }
    
    h.sort().each{k,v-> r += k + v}
    r
}
*/
//166
/*
T countAtoms(m){
    T r = ""
    T w = "[A-Z][a-z]?"
    T f = {s,p-> s.replaceAll(/$p(\d*)/){a,b,c-> b * (c ? c as int : 1)}}
    (f(f(m,/\((.+?)\)/), /($w)/) =~ w).grep() countBy{it} sort() each{a,b -> r += a+b}
    r
}
*/

def countAtoms(m){
    def r = ""
    (m =~ /(\(.+?\)|[A-Z][a-z]?)(\d*)/).each{a,b,c->
        r += (b - "(" - ")") * (c ? c as int : 1)
    }
    r
    
}