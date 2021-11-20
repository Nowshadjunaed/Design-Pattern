# Prerequisite
Design pattern is based on the [SOLID principles](https://github.com/Nowshadjunaed/SOLID-Principles). So knowing [SOLID principles](https://github.com/Nowshadjunaed/SOLID-Principles) is must to learn design pattern.

# Strategy Pattern
* The strategy pattern (also known as the policy pattern) is a software design pattern that enables an algorithm’s behavior to be selected at runtime
* Separate the code that changes, from the code that remains same
* Wrap the code with interface/abstraction that we will change
# Observer Pattern
* The Observer Pattern defines a one to many dependency between objects so that one object changes state, all of its dependents are notified and updated automatically
* In this pattern, observer are those who are notified when changing of data occurs
# Decorator Pattern
* The decorator pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality
* The decorator pattern can be used to make it possible to extend (decorate) the functionality of a certain object at runtime. It is like wrapping a gift, putting it in a box, and wrapping the box
# Adapter Pattern
* It is like the problem of inserting a new three-prong electrical plug in an old two-prong wall outlet – some kind of adapter or intermediary is necessary
* Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces
* Wrap an existing class with a new interface
* Impedance match an old component to a new system
# Facade Pattern
* Facade pattern presents a simplified interface to client
* It Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use
* Facade pattern violates open closed principle.And to solve this problem we use command pattern
# Command Pattern
* The command pattern encapsulates a request as an object, thereby letting us parameterize other objects with different requests,queue or log requests, and support undoable operations
* Command pattern is modified version of Facade pattern
# Singleton Pattern
* Singleton pattern is a design pattern which restricts a class to instantiate its multiple objects
* It should have only one instance
* Instance should be globally accessible
# Prototype Pattern
* Prototype pattern allows us to hide the complexity of making new instances from the client
* The concept is to copy an existing object or make clone of an existing object rather than creating a new instance from scratch
* This approach saves costly resources and time, especially when object creation is a heavy process
# Template Pattern
* Template design pattern is to define an algorithm as a skeleton of operations and leave the details to be implemented by the child classes
* The overall structure and sequence of the algorithm are preserved by the parent class
# Model View Controller Pattern
* The Model View Controller(MVC) design pattern specifies that an application consist of a data model, view information, and control information
* The pattern requires that each of these be separated into different objects
* MVC is more of an architectural pattern, but not for complete application. MVC mostly relates to the UI / interaction layer of an application
# Iterator Pattern
* This pattern provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
* Here the iterator interface provides a set of methods for traversing or modifying the collection that is in addition to next()/hasNext() it can also provide functions for search, remove etc.

