# Digit recognition

This repository contains the source code of a simple digit recognizer. The training and testing data comes from the [the MNIST database of handwritten digits](http://yann.lecun.com/exdb/mnist/). The image classifier is based on the k-nearest neighbors algorithm.

Each image is 'unwrapped' pixel by pixel to form a one-dimensional array, which is used as a feature vector. Distances between feature vectors are computed in a Euclidean n-dimensional space (n = 28^2)

![eq](http://i.imgur.com/rBeRkuB.png)

Before getting passed into the classifier, every image is pre-processed - pixels, whose color value is below a certain threshold, are filtered out.

A better way to obtain features is to extract them directly from the shape (for example the amount of holes, open areas etc). Such an implementation is being developed in the _digit-features-v2_ branch.

## Building and running
```
gradle run
```