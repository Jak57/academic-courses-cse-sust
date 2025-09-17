def f(x):
  return pow(x, 3) - 0.165 * pow(x, 2) + 3.993 * pow(10, -4)


def false_position_method(xl, xu, tolerance, max_iteration):

  xr = xu - f(xu) * ((xl - xu) / (f(xl) - f(xu)))
  total_iteration = 0

  while True:

    test = f(xl) * f(xr)

    if test < 0:
      xu = xr
    elif test > 0:
      xl = xr
    else:
      break

    xr_previous = xr
    xr = xu - f(xu) * ((xl - xu) / (f(xl) - f(xu)))

    approximate_relative_error = (abs(xr - xr_previous) / xr) * 100.0
    total_iteration += 1

    if approximate_relative_error < tolerance or total_iteration > max_iteration:
      break
  
  return xr


root = false_position_method(0.0, 0.11, 0.000005, 20)
print("Approximate value of root is", root)
