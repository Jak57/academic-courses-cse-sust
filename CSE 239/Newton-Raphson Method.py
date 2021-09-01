def f(x):
    """
    Assumes x as float
    Returs float evaluating the expression

    """
    return pow(x, 3) - 0.165*pow(x, 2) + 3.993*pow(10, -4)

def derivative_f(x):
    """
    Assumes x a float
    Returns the derivate of f(x)
    """
    return 3*pow(x, 2) - 0.33*x

def newton_raphson_method(x_present, max_iter, tolerance):
    """
    Assumes x_present and tolerance as float and max_iter as int, x_present is the innitial guess of root
    Returns root of equation as float

    """
    # x_next: float
    x_next = x_present - f(x_present) / derivative_f(x_present)
    # i: int
    global i
    i = 0
    
    while True:
        if f(x_next) == 0:
            break
        # prev_x_next: float
        prev_x_next = x_next
        x_present = x_next
        
        x_next = x_present - f(x_present) / derivative_f(x_present)
        error = (abs(x_next - prev_x_next) / x_next) * 100
        i += 1
        
        if i > max_iter or error < tolerance:
            break

    return x_next

root = newton_raphson_method(0.05, 20, 0.000005)
print("Approximate value of root is", root)
print("No. of iterations:", i)
