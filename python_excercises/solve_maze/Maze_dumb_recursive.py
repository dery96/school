from copy import deepcopy

class SolveMaze(object):
    """docstring for SolveMaze."""

    def __init__(self, width, height, mazeMap):
        super(SolveMaze, self).__init__()
        self.width = width
        self.height = height
        self.mazeMap = mazeMap
        self.solves = []
        self.posX, self.posY = self.getBeginingPos()[
                                                   0], self.getBeginingPos()[1]
        self.end = "It's end \n %s" % (self.mazeMap)

    def checkIfEnd(self, x, y):
        return True if self.mazeMap[x][y] == '$' else False

    def visited(self, x, y, mazeMap):
        return True if mazeMap[x][y] == '.' else False

    def getBeginingPos(self):
        for i in range(len(self.mazeMap)):
            try:
                return i, self.mazeMap[i].index('@')
            except:
                pass

    def solveRecursive(self, x, y, mazeMap):
        self._solveRecursive(x, y, mazeMap)
        # Lets cosider now every win case and choose the best one.
        dots_count_list = []
        for i in self.solves:
            solve_case = [j.count('.') for j in i]
            dots_count_list.append(sum(solve_case))

        get_min_case_of_dots = min(dots_count_list)
        get_index_of_min = dots_count_list.index(get_min_case_of_dots)

        print("From %d cases the best is: \n" % (len(self.solves)))
        self.show(self.solves[get_index_of_min])

    def _solveRecursive(self, x, y, mazeMap):
        # firstly Will go every nearest possibility:
        # up -> right -> down -> left
        # print("(%d, %d)" % (x, y))
        checkIfEnd = True if mazeMap[x][y] == '$' else False
        if checkIfEnd:
            mape = deepcopy(mazeMap)
            self.solves.append(mape)
        else:
            mazeMap[x][y] = '.' if mazeMap[x][y] == ' ' else mazeMap[x][y]
            visited = True if mazeMap[x][y] == '.' else False

            if not self.visited(x - 1, y, mazeMap) and mazeMap[x - 1][y] != '#':
                # moveUp
                self._solveRecursive(x - 1, y, mazeMap)

            if not self.visited(x, y - 1, mazeMap) and mazeMap[x][y - 1] != '#':
                # moveLeft
                self._solveRecursive(x, y - 1, mazeMap)

            if not self.visited(x, y + 1, mazeMap) and mazeMap[x][y + 1] != '#':
                # moveRight
                self._solveRecursive(x, y + 1, mazeMap)

            if not self.visited(x + 1, y, mazeMap) and mazeMap[x + 1][y] != '#':
                # moveDown
                self._solveRecursive(x + 1, y, mazeMap)


            # Do it when you want consider every win case
            # mazeMap[x][y] = ' ' if mazeMap[x][y] == '.' else mazeMap[x][y]

    def show(self, array):
        return [print(''.join(line)) for line in array]

with open('mazeExamples/labirynt1.txt', 'r') as f:
    mapFile = [list(line.strip()) for line in f]

# First line of maze txt contains height and width value
mapFile[0] = "".join(mapFile[0])
mapProperties = [ int(x) for x in mapFile[0].split(' ') ]

mapWidth, mapHeight = mapProperties[1], mapProperties[0]
a = SolveMaze(mapWidth, mapHeight, mapFile[1:])
a.solveRecursive(a.posX, a.posY, mapFile[1:])
