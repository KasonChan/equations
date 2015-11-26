# Equations #

[![Build Status](https://travis-ci.org/KasonChan/equations.svg?branch=master)](https://travis-ci.org/KasonChan/equations)
[![codecov.io](https://codecov.io/github/KasonChan/equations/coverage.svg?branch=master)](https://codecov.io/github/KasonChan/equations?branch=master)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/009397d800574d5c8ba2d2502258335f)](https://www.codacy.com/app/kasonl-chan/equations)

Equations is a thin layer library for calculating one unknown equations. 
Its mission is to provide the developers simple and robust API primitives 
to build their mass balance equations.

## Modules ##

Equations uses multi-project structure and contains of the following _modules_:

* [`equations-massbalance`](massbalance) - solve mass balance equations.
* [`equations-monooperation`](monooperation) - solve mono-operation equations.

## Installation ##

Every Equations module is published at Maven Central. Use the following _sbt_ snippet ...

* for the _stable_ release:

```scala
libraryDependencies ++= Seq(
  "com.github.kasonchan" %% "[equations-module]" % "0.1.0"
)
```

* for the `SNAPSHOT` version:

```scala
resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.github.kasonchan" %% "[equations-module]" % "0.1.0-SNAPSHOT" changing()
)
```

### Hello World ###

This "Hello World!" example is built with the 0.1.0-SNAPSHOT version.

```
import equations.massbalance.MassBalance._
import equations.monooperation.MonoOperation._

// x = 3 + 4
scala> solveM(List(None), List(Some(3), Some(4)), 'add)
Some(7.0)

// 25 = x * 5
scala> solveM(List(Some(25)), List(None, Some(5)), 'multiple)
Some(5.0)

// 10 * 20 + 5 * 40 = x * 15
svala> val inputs = List(MX(Some(10), Some(20)), MX(None, Some(40)))
scala> val outputs = List(MX(None, Some(15)))
scala> solveMX(inputs, outputs)
Some(26.7)
```

### Documentation ###

- A comprehensive documentation may be found in the `docs/` folder.
- The latest Scaladoc is available at http://kasonchan.github.io/equations/docs/.

### License ###

Licensed under the **[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)** (the "License");
you may not use this software except in compliance with the License.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
