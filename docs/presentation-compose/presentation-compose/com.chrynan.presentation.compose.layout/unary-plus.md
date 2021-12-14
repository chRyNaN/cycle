//[presentation-compose](../../index.md)/[com.chrynan.presentation.compose.layout](index.md)/[unaryPlus](unary-plus.md)

# unaryPlus

[common]\

@Composable

inline operator fun &lt;[I](unary-plus.md) : [Intent](../../../presentation-core/presentation-core/com.chrynan.presentation/-intent/index.md), [S](unary-plus.md) : [State](../../../presentation-core/presentation-core/com.chrynan.presentation/-state/index.md), [C](unary-plus.md) : [Change](../../../presentation-core/presentation-core/com.chrynan.presentation/-change/index.md)&gt; [Layout](-layout/index.md)&lt;[I](unary-plus.md), [S](unary-plus.md), [C](unary-plus.md)&gt;.[unaryPlus](unary-plus.md)()

Lays out the provided [layout](layout.md) as a Composable.

This is a convenience function for calling [composeLayout](compose-layout.md).

Example usage:

@Composable\
fun Home {\
    +HomeLayout()\
}