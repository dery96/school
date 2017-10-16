mazeMap = [[1, 2, 3], ['@'], ['a']]
def getBeginingPos(mazeMap):
    for i in mazeMap:
        try:
            print i.index('@')
        except:
            pass

getBeginingPos(mazeMap)