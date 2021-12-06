import math

def f(x):
  return pow(x, 3) + pow(x, 2) - 1


def g(x):
  return 1 / math.sqrt(x + 1)


def simple_fixed_point_iteration(x0, tolerance, max_iteration):

  x1 = g(x0)
  total_iteration = 0

  while True:

    x0 = x1
    x1_prev = x1
    x1 = g(x0)

    approximate_relative_error = (abs(x1 - x1_prev) / x1) * 100.0
    total_iteration += 1

    if approximate_relative_error < tolerance or total_iteration > max_iteration:
      break
  
  return x1


root = simple_fixed_point_iteration(2, 0.00001, 10)
print("Approximate value of root is", root)
