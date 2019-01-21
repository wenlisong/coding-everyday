# There are a total of n courses you have to take, labeled from 0 to n-1.
# Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
# Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
# There may be multiple correct orders, you just need to return one of them.If it is impossible to finish all courses, return an empty array.


class Solution:
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        indegree = [0 for i in range(numCourses)]
        pre_list = [[] for _ in range(numCourses)]

        for start, end in prerequisites:
            indegree[end] += 1
            pre_list[start].append(end)

        queue = [i for i in range(numCourses) if indegree[i] == 0]

        for i in queue:
            for vec in pre_list[i]:
                indegree[vec] -= 1
                if indegree[vec] == 0:
                    queue.append(vec)
        if len(queue) == numCourses:
            return queue[::-1]
        else:
            return []
