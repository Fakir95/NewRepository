# KNN_Classification
This project is a school project made for data mining course. It takes a classification training and test datasets, and classifies the test set according to the training dataset.

Giving it a train and test set, you can enter the number of K nearest neighbors as input, and get an output of total accuracy, the accuracy percentange of each class, and the confusion matrix.

Assume that the format of the input file(test and train datasets, as text files) is as follows:

•	First line contains the number of attributes, the number of instances, and the number of classes. The number of attributes also contains the class attribute.     

•	From the second line, each line corresponds to a single instance and the attributes of the instances are separated via comma. Last element always contains the class attribute of that instance.
An example dataset is as follows:

4 10 3  
0.2,3.4,0.7,0

1.2,3.6,6.7,0 

3.2,0.4,6.9,0

1.8,1.8,9.7,1

1.0,4,16.7,1

21.2,3,68.7,1

45.8,13.5,609.7,2

8.2,1.234,16.7,2

1.29,6.3,0.7,2

1.52,3.4,123.7,2

Given this dataset example,

number of attributes = 4 
number of instances = 10
number of classes = 3. (Represented as 0,1 and 2 in the last element/number of every instance.)

iris dataset is used as an example in the project, you can use your own data file imports.

No weka imports are used for this project, and it is written in pure java.
