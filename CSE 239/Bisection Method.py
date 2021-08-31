### Find the root of equations using Bisection Method

def f(x):
    """
    Assumes x is a float
    Returns float evaluating the expression below 

    """
    return pow(x, 3) - 0.165*pow(x, 2) + 3.993*pow(10, -4)

# xl: float, lower boundary
xl = 0.0
# xu: float, upper boundary
xu = 0.11
# i: int
i = 0
# max_iter: int, maximum iteration
max_iter = 20
# tolerance: float
tolerance = 0.0005

# xr: float, mid value
xr = (xl + xu)/2.0

while True:
    
    # test: float
    test = f(xl) * f(xr)
    if test < 0:
        xu = xr
    elif test > 0:
        xl = xr
    else:
        break
    
    xr_prev = xr
    xr = (xl + xu)/2.0
    approximate_error = (abs(xr - xr_prev)/xr)*100
    
    i += 1
    if approximate_error < tolerance or i > max_iter:
        break

print("Approximate value of root is", xr)
