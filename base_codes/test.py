# coding=utf-8
import sys

# str = input()
# print(str)
print('Hello,World!')


def findMax(nums, begin, end):
    mid = int((begin + end) / 2)
    if mid == 0:
        return nums[mid]
    if nums[mid] > nums[0] and nums[mid] > nums[-1]:
        nums = nums[mid:]
        findMax(nums, mid, end)
    if nums[mid] < nums[0] and nums[mid] < nums[-1]:
        nums = nums[:mid]
        findMax(nums, begin, mid - 1)


def findNum(num, nums, begin, end):
    mid = (begin + end) / 2
    if num == nums[mid]:
        return mid
    if num > nums[mid]:
        findNum(num, nums, mid, end)
    else:
        findNum(num, nums, begin, mid - 1)


nums = [32, 43, 51, 62, 79, 82, 91, 0, 12, 21]
maxNum = findMax(nums, 0, len(nums))
wanted = 0
if wanted < nums[maxNum]:
    res = findNum(wanted, nums, 0, len(nums))
else:
    res = findNum(wanted, nums, maxNum, len(nums))
print(res)




