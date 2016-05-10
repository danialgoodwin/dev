Self-note: Why NN use sigmoid function ( 1/(1 + e^-x) ) use exp instead of something more symetric? Is e^x symmetric? Plot of 1/x is symmetric at 45 degrees.

# Machine Learning Cheat Sheet
There are different types of machine learning.



## Type

### Neural Network

Improvement Strategy:

- Random local search: Try random values for inputs and keep the best results.
- Numerical gradient: Find derivative (or, "slope") for each input by testing another input value, and use that info to get better results.
  - Hill-climbing analogy
- Analytic gradient: Find derivative (or, "slope") mathematically for each input, and use that info to get better results.

### Vector



## Third-party Program

### TensorFlow

    from sklearn import tree
    features = [[140, 1], [130, 1], [150, 0], [170, 0]]
    labels = [0, 0, 1, 1]
    clf = tree.DecisionTreeClassifier()
    clf = clf.fit(features, labels)
    print clf.predict([[150, 0]])

[Source](https://www.youtube.com/watch?v=cKxRvEZd3Mw)



## More Info
- Great: [Hacker's guide to Neural Networks](http://karpathy.github.io/neuralnets/). Technical start into basic NN creation. You should already be familiar with the idea of NN, and knowledge of Calculus 101 is beneficial, but not required.
- [Open source projects on GitHub](https://github.com/showcases/machine-learning)
