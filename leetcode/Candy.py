# 135. Candy
# There are N children standing in a line. Each child is assigned a rating value.

# You are giving candies to these children subjected to the following requirements:

# Each child must have at least one candy.
# Children with a higher rating get more candies than their neighbors.
# What is the minimum candies you must give?

# Example 1:

# Input: [1,0,2]
# Output: 5
# Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
# Example 2:

# Input: [1,2,2]
# Output: 4
# Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
#              The third child gets 1 candy because it satisfies the above two conditions.
class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        num_candies = [1 for i in range(n)]
        for i in range(n-1):
            if ratings[i+1]>ratings[i]:
                num_candies[i+1] = num_candies[i] + 1
            # elif ratings[i+1]==ratings[i]:
            #     num_candies[i+1] = num_candies[i]
        for i in range(n-1, 0, -1):
            if ratings[i-1]>ratings[i]:
                    num_candies[i-1] = max(num_candies[i-1], num_candies[i] + 1)
            # elif ratings[i-1]==ratings[i]:
            #     num_candies[i-1] = num_candies[i]

        return sum(num_candies)
