import random

class SaperGame(object):
    """docstring for SaperGame."""
    def __init__(self, size):
        self.size = size
        self.mines = (size ** 2) / 2.5
        self.map = self.generateMap()
        self.threat = self.generateThreat()
        self.end = False

    def show(self, array=None):
        '''Nice-Looking showing map list'''
        array = self.map if array == None else array
        print("--"*12)
        tmp = [''.join(str(i)) for i in range(len(array))]
        print(' '*2 + ' '.join(tmp)) ## Printing row number

        for index, line in enumerate(array):
            print(str(index) + ' ' + ' '.join(line))

    def generateMap(self):
        tmp_list = [["-" for e in range(self.size)] for e in range(self.size)]
        return self._generateMines(tmp_list)

    def _generateMines(self, tmp_list):
        '''Will placing mines in random pos on map until the count of it
        will be correct with assumption'''
        placed_mines = 0
        while (placed_mines != self.mines):
            x_pos = random.randint(0, len(tmp_list)-1)
            y_pos = random.randint(0, len(tmp_list[0])-1)
            if tmp_list[x_pos][y_pos] == '-':
                tmp_list[x_pos][y_pos] = "M"
                placed_mines += 1

        # print(sum(list.count('M') for list in tmp_list))
        # ^up How many mines are really in the game
        return tmp_list

    def generateThreat(self):
        '''Creates list of Treat for every empty field becouse. Every field
        has his own mine occurance tells you about: How many mines are
        in neighborhood'''
        threatList = []
        for i in range(len(self.map)):
            t =[self._countNearbyMines(i, j) for j in range(len(self.map[0]))]
            threatList.append(t)
        # self.show(threatList)
        return threatList


    def _countNearbyMines(self, x, y):
        '''calculate threat for fields in neighborhood'''
        mineCount = 0
        if self.map[x][y] != 'M': # We don't count mines for mine field
            for i in range(-1, 2):
                for j in range(-1, 2):
                    if self.testPos(x+i, y+j) and self.map[x+i][y+j] == 'M':
                        # if we don't go out of list we check field
                        mineCount += 1
        else:
            return 'M'
        return str(mineCount)

    def reveal(self, x, y):
        '''Reveal closet area to recursive to map border and Mines'''
        if self.map[x][y] == 'M':
            self.end = True
            print("GAME OVER!")
        else:
            self._reveal(x, y)

    def _reveal(self, x, y):
        if self.test(x, y):
            self.map[x][y] = self.threat[x][y]

            if self.test(x-1, y): # UP
                self._reveal(x-1, y)

            if self.test(x+1, y): # DOWN
                self._reveal(x+1, y)

            if self.test(x, y-1): # Left
                self._reveal(x, y-1)

            if self.test(x, y+1): # Right
                self._reveal(x, y+1)

    def test(self, x, y):
        '''If pos is in list range and it's not Mine and not visited'''
        if self.testPos(x, y) and self.map[x][y] != 'M':
            return True if not self.map[x][y].isdigit() else False

    def testPos(self, x, y):
        testX = True if (x >= 0 and x < len(self.map)) else False
        testY = True if (y >= 0 and y < len(self.map[0])) else False
        return True if (testX and testY) else False

game = SaperGame(20)
# game.show()
# game.show(game.threat)
game.reveal(0, 0)
game.show()
