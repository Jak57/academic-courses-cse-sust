def f(x):
  return pow(x, 3) - 0.165 * pow(x, 2) + 3.993 * pow(10, -4)


def secant_method(x0, x1, tolerance, max_iter):

  x2 = x1 - f(x1) * ((x1 - x0) / (f(x1) - f(x0)))
  total_iter = 0

  while True:
    x0 = x1
    x1 = x2

    x2_prev = x2
    x2 = x1 - f(x1) * ((x1 - x0) / (f(x1) - f(x0)))

    approximate_relative_error = (abs(x2 - x2_prev)/x2) * 100.0
    total_iter += 1

    if approximate_relative_error < tolerance or total_iter > max_iter:
      break
  
  return x2


root = secant_method(0.02, 0.05, 0.000005, 20)
print("Approximate value of root is", root)
