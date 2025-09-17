def f(x):
    return pow(x, 3) - 0.165*pow(x, 2) + 3.993*pow(10, -4)

def secant_method(x1, x2, max_iter, tolerance):
    """
    

    Parameters
    ----------
    x1 : float
          initial guess
    x2 : float
          initial guess
    max_iter : int
          maximum number of iteration
    tolerance : float
        

    Returns
    -------
    x3 : float
          root of the equation

    """
    global i
    i = 0
    x3 = x2 - f(x2) * (x1 - x2)/(f(x1) - f(x2))
    x1 = x2
    x2 = x3
    
    while True:
        if (f(x3) == 0):
            break
        
        prev_x3 = x3
        x3 = x2 - f(x2) * (x1 - x2)/(f(x1) - f(x2))
        error = (abs(x3 - prev_x3)/x3)*100
        print(x1, x2, x3, i)
        
        x1 = x2
        x2 = x3
        i += 1
        if i > max_iter or error < tolerance:
            break

    return x3

root = secant_method(0.02, 0.05, 20, 0.000005)
print("Approximate value of root is", root)
print("Number of iterations:", i)


