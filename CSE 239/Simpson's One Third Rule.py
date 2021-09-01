def f(x):
    return 0.2+25*x-200*pow(x, 2)+675*pow(x, 3)-900*pow(x, 4)+400*pow(x, 5)

def simpsons_one_third_rule(x0, xn, true_value, n = 2):
    
    """
    
    Parameters
    ----------
    x0 : float
        Lower limit
    xn : float
        Upper limit
    true_value : float
        
    n : int, optional
        The number of segment. If n is not given then it will
        be 2 segment. The default is 2.

    Returns
    -------
    approximate_value : float
        Approximate value of area
    true_percent_relative_error : float
        

    """
    
    h = (xn-x0)/n
    sum = f(x0) + f(xn)
    
    for i in range(1, n):
        if i % 2 == 1:
            sum += 4 * f(i*h)
        else:
            sum += 2 * f(i*h)
    
    approximate_value = (h/3.0) * sum
    true_percent_relative_error = (abs(true_value - approximate_value)/true_value) * 100
    return approximate_value, true_percent_relative_error
    
approximate_value, true_percent_relative_error = simpsons_one_third_rule(0, 0.8, 1.640533, 4)
print("Approximate value of area is", approximate_value)
print("True percent relative error "+ str(true_percent_relative_error) + "%")




