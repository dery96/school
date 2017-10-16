class MazeSolve(object):
    """docstring for MazeSolve."""
    def __init__(self, mazeMap):
        super(MazeSolve, self).__init__()
        self.mazeMap = mazeMap
        self.end = "It's end \n %s" % (self.mazeMap)
        self.pos = self.getBeginingPos()
        self.actualPositionContent = self.mazeMap[self.pos['x']][self.pos['y']]
        self.width = width
        self.height = height


    def solveRecursive(self):
        print(self.posX, self.posY)
        if self.checkIfEnd:
            return self.end
        else:
            if self.actualPositionContent == ' ':


            if self.actualPositionContent == '#':
                pass



    def getCloserDirection(self):

        pass

    def chooseDirection(self):
        if

    def getBeginingPos(self):
        for i in len(self.mazeMap):
            try:
                return self.mazeMap[i].index('@')
        # return self.mazeMap.index('@')

    def checkIfEnd(self):
        if self.Maze[self.posY][self.posX] == '$':
            return true
        return false


def mazeRekurencyjnie(mazeWidth, mazeHeight):
    pass

## Maybe it's time to use Dickstra
## między dwoma punktami zawsze ma być droga

def moveUp(arg):
    pass

def moveRight(arg):
    pass

def moveDown(arg):
    pass

def moveLeft(arg):
    pass

def move(arg):
    pass

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
