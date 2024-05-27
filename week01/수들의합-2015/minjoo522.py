import sys
from collections import defaultdict

input = sys.stdin.readline

N, K = map(int, input().split())
nums = list(map(int, input().split()))

prefix_sum_counts = defaultdict(int)
current_sum = 0
cnt = 0

# 누적 합이 0일 때 처리
prefix_sum_counts[0] = 1

for num in nums:
    current_sum += num

    if (current_sum - K) in prefix_sum_counts:
        cnt += prefix_sum_counts[current_sum - K]

    prefix_sum_counts[current_sum] += 1

print(cnt)
