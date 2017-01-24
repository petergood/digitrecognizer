# Digit recognition

This repository contains the source code of a simple digit recognizer. The training and testing data comes from the [the MNIST database of handwritten digits](http://yann.lecun.com/exdb/mnist/). The image classifier is based on the k-nearest neighbors algorithm.

The feature vector of each image is based on its pixels, which are 'unwrapped' in the following manner:
![Drawing](http://i.imgur.com/ZupgfDx.png)
0 represents background, and 1 represents any other color (ranging from 1 to 255).

A better way to obtain features is to extract them directly from the shape (for example the amount of holes, open areas etc). Such an implementation is being developed in the _digit-features-v2_ branch.

## Building and running
```
gradle run
```