def parseFen(position) {
  def board = []
    def pieceMap = [
        "r" : '\u2656',
        "n" : '\u2658',
        "b" : '\u2657',
        "q" : '\u2655',
        "k" : '\u2654',
        "p" : '\u2659',
        "R" : '\u265C',
        "N" : '\u265E',
        "B" : '\u265D',
        "Q" : '\u265B',
        "K" : '\u265A',
        "P" : '\u265F',
    ].withDefault{ '\uFF3F'* it.toInteger()}

    position.split("/").each{
        String temp = ""
        it.each{
            temp += pieceMap[it]
        }
        board << temp
    }

    board
}
