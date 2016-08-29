# differentials #

The result of a spontaneous hack at [SoCraTes 2016](http://socrates-conference.de) on Saturday night, 27th of August 2016.
At first the idea was to calculate Euler's number by hand, but we quickly changed our minds to writing a full fledged 
differential equation solver. The biggest learning for me was, that Scala's type system tremendously helped us to
communicate. Example:

> A differential equation solver will calculate a solution for a differential equation. The solution is itself an equation that maps a float to a float.

> Okay, so let me just create a type alias for that...

_wirtes_ `type Solution = Float => Float`

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with any pull requests, please state that the contribution is your original work and that you license the work to the project under the project's open source license. Whether or not you state this explicitly, by submitting any copyrighted material via pull request, email, or other means you agree to license the material under the project's open source license and warrant that you have the legal authority to do so.

## License ##

This code is open source software licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
