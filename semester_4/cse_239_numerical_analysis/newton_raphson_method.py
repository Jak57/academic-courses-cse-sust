def f(x):
  return pow(x, 3) - 0.165 * pow(x, 2) + 3.993 * pow(10, -4)


def derivative(x):
  return 3 * pow(x, 2) - 0.33 * x

def newton_raphson_method(x0, tolerance, max_iter):

  x1 = x0 - f(x0) / derivative(x0)
  total_iter = 0

  while True:

    x0 = x1

    x1_prev = x1
    x1 = x0 - f(x0) / derivative(x0)

    approximate_relative_error = (abs(x1 - x1_prev) / x1) * 100.0
    total_iter += 1

    if approximate_relative_error < tolerance or total_iter > max_iter:
      break
  
  return x1


root = newton_raphson_method(0.05, 0.00005, 20)
print("Approximate value of root is", root)
