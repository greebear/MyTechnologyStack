from typing import List


class Solution:
    def minNumber(self, nums: List[int]) -> str:
        def quick_sort(l, r):
            if l >= r: return
            i, j = l, r
            while i < j:
                while strs[j] + strs[l] >= strs[l] + strs[j] and i < j: j -= 1
                while strs[i] + strs[l] <= strs[l] + strs[i] and i < j: i += 1
                strs[i], strs[j] = strs[j], strs[i]
            strs[i], strs[l] = strs[l], strs[i]
            quick_sort(l, i - 1)
            quick_sort(i + 1, r)

        strs = [str(num) for num in nums]
        quick_sort(0, len(strs) - 1)
        return ''.join(strs)


def quick_sort(li, start, end):
    # 分治 一分为二
    # start=end ,证明要处理的数据只有一个
    # start>end ,证明右边没有数据
    if start >= end:
        return
    # 定义两个游标，分别指向0和末尾位置
    left = start
    right = end
    # 把0位置的数据，认为是中间值
    mid = li[left]
    while left < right:
        # 让右边游标往左移动，目的是找到小于mid的值，放到left游标位置
        while left < right and li[right] >= mid:
            right -= 1
        li[left] = li[right]
        # 让左边游标往右移动，目的是找到大于mid的值，放到right游标位置
        while left < right and li[left] < mid:
            left += 1
        li[right] = li[left]
    # while结束后，把mid放到中间位置，left=right
    li[left] = mid
    # 递归处理左边的数据
    quick_sort(li, start, left - 1)
    # 递归处理右边的数据
    quick_sort(li, left + 1, end)


def quickSort(l, i, j):
    if i >= j: return
    start, end = i, j
    pivot = l[i]
    while i < j:
        while i < j and l[j] >= pivot: j -= 1
        l[i] = l[j]
        while i < j and l[i] <= pivot: i += 1
        l[j] = l[i]
    l[i] = pivot
    quick_sort(l, start, i - 1)
    quick_sort(l, i + 1, end)


if __name__ == '__main__':
    l1 = [6, 5, 4, 3, 2, 1]
    l2 = [30, 24, 5, 58, 18, 36, 12, 42, 39]
    l3 = [2, 3, 2, 2, 1, 0, 0, 19, 2, 3, 7, 84, 3, 2, 5, 10]
    l4 = [2, 3, 2]
    l5 = [2, 1, 3, 4, 7, 8, 5, 2, 5, 4]
    l6 = [0]


    def quick_test(*ls):
        for l in ls:
            quickSort(l, 0, len(l) - 1)


    quick_test(l1, l2, l3, l4, l5, l6)

    assert l1 == [1, 2, 3, 4, 5, 6]
    assert l2 == [5, 12, 18, 24, 30, 36, 39, 42, 58]
    assert l3 == [0, 0, 1, 2, 2, 2, 2, 2, 3, 3, 3, 5, 7, 10, 19, 84]
    assert l4 == [2, 2, 3]
    assert l5 == [1, 2, 2, 3, 4, 4, 5, 5, 7, 8]
    assert l6 == [0]

