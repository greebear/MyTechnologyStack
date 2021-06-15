import io
import sys
sys.stdout = io.TextIOWrapper(sys.stdout.buffer,encoding='utf-8')
chars = input()
nums = []
for c in chars:
    nums.append(int(c))

print('hello world!')

def max_length(nums):
    max_len = 0
    for i in range(len(nums)):
        sub_nums = nums[:i+1]
        sub_nums.sort()
        if i%2==1:
            if sub_nums[i//2] == 0 and sub_nums[i//2+1] == 0:
                max_len = max(max_len, i+1)
    return max_len

res = max_length(nums)
print(res)



