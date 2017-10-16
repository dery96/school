class MazeSolve(object):
    """docstring for MazeSolve."""
    def __init__(self, mazeMap, width, height):
        self.mazeMap = mazeMap
        self.width = width
        self.height = height
        # self.actualPositionContent = self.mazeMap[self.pos[0]][self.pos[1]]
        self.end = "It's end \n %s" % (self.mazeMap)
        self.posX, self.posY = self.getBeginingPos()[0], self.getBeginingPos[1]

    def checkIfEnd(self):
        if self.Maze[self.pos[0]][self.pos[1]] == '$':
            return true
        return false

    def testPos(x, y):
        if y < width and x < height:
            return True
        return False

    def getBeginingPos(self):
        for i in len(self.mazeMap):
            try:
                return i, self.mazeMap[i].index('@')
            except:
                pass

    def solveRecursive(self, x=self.posX, y=self.posY):
        print("(%d, %d)" % (x, y))
        if self.checkIfEnd():
            return self.end
        else:
            if self.testPos(x+1,y) and self.mazeMap[x+1][y] !== '#':
                # Up
                self.mazeMap[x+1, y] = '.'
                return self.solveRecursive(x+1, y)
            elif self.testPos(x,y+1) and self.mazeMap[x][y+1] !== '#':
                # Right
                self.mazeMap[x, y+1] = '.'
                return self.solveRecursive(x, y+1)
            elif self.testPos(x-1,y) and self.mazeMap[x-1][y] !== '#':
                # Down
                self.mazeMap[x-1, y] = '.'
                return self.solveRecursive(x-1,y)
            elif self.testPos(x,y-1) and self.mazeMap[x][y-1] !== '#':
                # Left
                self.mazeMap[x, y-1] = '.'
                return self.solveRecursive(x, y-1)

def mazeRekurencyjnie(mazeWidth, mazeHeight):
    pass

## Maybe it's time to use Dickstra
## między dwoma punktami zawsze ma być droga

def analzyeMapToGraph(arg):
    ## it sets weight for map
    # weight ignore '$'
    # wall '4'
    # free space to walk '1'



if __name__ == "__main__":
    with open('data.txt', 'r') as myfile:
        data = myfile.readlines().replace('\n', '')
    print("data")
    # after ./labiryn runs evrth inside that
