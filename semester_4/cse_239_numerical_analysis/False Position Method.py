def f(x):
    """
    Assumes x as float
    Returns float evaluating the expression

    """
    return pow(x, 3) - 0.165*pow(x, 2) + 3.993*pow(10, -4)

def false_position_method(xl, xu, max_iter, tolerance):
    """
    Assumes xl, xu, tolerance as float and max_iter as int
    xl: lower boundary
    xu: upper boundary
    max_iter: maximum number of iterations
    
    Returns root of equations as float

    """
    xr = xu - f(xu) * ((xl - xu) / (f(xl) - f(xu)))
    i = 0
    
    while True:
        test = f(xl) * f(xr)
        if test < 0:
            xu = xr
        elif test > 0:
            xl = xr
        else:
            break
        
        xr_prev = xr
        xr = xu - f(xu) * ((xl - xu) / (f(xl) - f(xu)))
        approximate_error = (abs(xr - xr_prev)/xr) * 100
        
        i += 1
        if i > max_iter or approximate_error < tolerance:
            break
        
    return xr

root = false_position_method(0.0, 0.11, 20, 0.000005)
print("Approximate value of root is", root)
