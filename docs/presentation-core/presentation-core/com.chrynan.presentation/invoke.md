//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[invoke](invoke.md)



# invoke  
[common]  
Content  
operator fun <[I](invoke.md) : [Intent](-intent/index.md), [S](invoke.md) : [State](-state/index.md), [C](invoke.md) : [Change](-change/index.md)> [Action](-action/index.md)<[I](invoke.md), [S](invoke.md), [C](invoke.md)>.[invoke](invoke.md)(intent: [I](invoke.md), state: [S](invoke.md)?): Flow<[C](invoke.md)>  
More info  


A convenience function that delegates to [Action.perform](-action/perform.md) allowing the [Action](-action/index.md) to be invoked like a function.

  


[common]  
Content  
suspend operator fun <[S](invoke.md) : [State](-state/index.md), [C](invoke.md) : [Change](-change/index.md)> [Reducer](-reducer/index.md)<[S](invoke.md), [C](invoke.md)>.[invoke](invoke.md)(previous: [S](invoke.md)?, change: [C](invoke.md)): [S](invoke.md)  
More info  


A convenience operator function that delegates to the [reduce](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html) function, so that the [Reducer](-reducer/index.md) class can be invoked like a function.

  



