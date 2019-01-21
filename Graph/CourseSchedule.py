# There are a total of n courses you have to take, labeled from 0 to n-1.
# Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
# Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


class Solution:
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = [[] for _ in range(numCourses)]
        indegree = [0 for _ in range(numCourses)]
        for start, end in prerequisites:
            graph[start].append(end)
            indegree[end] += 1

        queue = [vec for vec in range(numCourses) if indegree[vec] == 0]

        cnt = 0
        for i in queue:
            cnt += 1
            for vec in graph[i]:
                indegree[vec] -= 1
                if indegree[vec] == 0:
                    queue.append(vec)

        return cnt == numCourses
