# 时间 计算时间差 当前时间

import time
import datetime


def time_spent(big, small):
    big = datetime.datetime.strptime(big, '%Y-%m-%dT%H:%M:%S')
    small = datetime.datetime.strptime(small, '%Y-%m-%dT%H:%M:%S')
    return (big - small).total_seconds()


# 当前时间 字符串格式
print("="*50, "获取当前时间")
current_time = time.strftime("%Y-%m-%dT%H:%M:%S", time.localtime())
print(current_time)
print(type(current_time))

# 计算时间差
print("="*50, "计算时间差")
time_1 = '2020-03-02T15:00:00'
time_2 = '2020-03-03T16:00:00'
total_seconds = time_spent(time_2, time_1)
print(total_seconds)
print(type(total_seconds))

