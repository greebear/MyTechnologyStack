from typing import List


def spilt_func(row):
    loc = []
    for i in range(len(row)):
        if row[i] == "*":
            loc.append(i)


def drop(row):
    split_place = len(row)
    for index in range(len(row)):
        if row[index] == "*":
            split_place = index
            break

    rangeable_row = row[0:split_place]
    unrangeable_row = row[split_place:len(row)]

    space = 0
    # print(rangeable_row)
    for item in rangeable_row:
        if item == ".":
            space += 1
    # print(space)

    new_list = []
    for i in range(space):
        new_list.append(".")

    for i in range(split_place-space):
        new_list.append("#")


    return new_list + unrangeable_row


def row_to_column(box):
    high = len(box)
    width = len(box[0])

    new_box = [[] for _ in range(width)]
    for j in range(width):
        for i in range(high):
            print(j,i)
            new_box[j].append(box[i][j])

    return new_box

print(row_to_column([[1,2,3],[4,5,6],[7,8,9],[10,11,12]]))



class Solution:
    def rotateTheBox(self, box: List[List[str]]) -> List[List[str]]:
        new_box = []
        for each_list in box:
            new_list = drop(each_list)
            new_box.append(new_list)
        new_box.reverse()
        new_box = row_to_column(new_box)
        return new_box








b_list = [[1,2,3],[4,5,6],[7,8,9]]
print(b_list.reverse())
print(b_list)




print(drop(["#","#","#",".","#",".","*"]))
print(drop(["#","#","#",".","#","."]))
print(drop(["#"]))
print(drop([".","#"]))
print(drop(["#","."]))