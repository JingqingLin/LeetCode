from functools import lru_cache

class Greedy:
    @lru_cache(10**8)
    def climbStairs(self, n):
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            return self.climbStairs(n - 1) + self.climbStairs(n - 2)

print(Greedy().climbStairs(6))