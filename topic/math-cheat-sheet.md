# Math Cheat Sheet #
The minimal mathematics that developers should know.

- Trigonometry
- Statistics
- Logarithms
- Intro to calculus



## Basics ##
- Coordinate systems
  - Types
    - Cartesian: Represent a location with two distances in a 2D grid, aka (x, y) where x and y are magnitudes of the corresponding axis. Each additional dimension uses another distance along the corresponding axis.
    - Polar: Represent a location with a distance and angle in 2D, aka (r, theta) where r is radius and theta is angle. Each additional dimension uses another angle along the corresponding axis.
  - Convert
    - Polar to Cartesian
      - x = r * cos(T + theta(t))
      - y = r * sin(T + theta(t))
    - Cartesian to Polar
      - r = sqrt(x^2 + y^2)
      - theta = arctan (y / x)
      - tan(theta) = y / x
- Equations
  - Parabola: y = x ^ 2
  - Circle: 1 = sqrt(x ^ 2 + y ^ 2)



## Trigonometry ##
- SohCahToa: sin = opposite / hypotenuse, cos = adjacent / hypotenuse, tan = opposite / adjacent
- In triangle with sides ABC, A + B > C



## Statistics ##
- [Easy Permutations and Combinations](http://betterexplained.com/articles/easy-permutations-and-combinations/)



## Logarithms ##

    // Refresher
    log(x, y) = n     same as     x ^ n = y
    log(e, x)         same as     ln(x), 'natural log', where e = 2.71828...

    // Log properties, let a and b by any two real, non-zero numbers
    logx a + logx b = logx (ab)
    logx a - logx b = logx (a/b)
    b*logx a = logx (a^b)
    log(b,a) = log(a) / log(b)



## Calculus ##
- Lagrange's formula: Basically, a way to find the minimum/maximum of a formula.
  - [A Simple Explanation of Why Lagrange Multipliers Work](http://www.the-idea-shop.com/article/215/understanding-why-the-method-of-lagrange-multipliers-works)

### Derivatives and Integals ###

    distance = speed * time
    speed = distance / time
    acceleration = speed / time

    distance = integral of the speed function over the time period
    speed = derivative of distance function
    acceleration = derivative of speed function
