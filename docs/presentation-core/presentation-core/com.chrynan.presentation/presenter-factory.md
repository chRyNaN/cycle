//[presentation-core](../../index.md)/[com.chrynan.presentation](index.md)/[presenterFactory](presenter-factory.md)

# presenterFactory

[common]\
fun &lt;[I](presenter-factory.md) : [Intent](-intent/index.md), [S](presenter-factory.md) : [State](-state/index.md), [C](presenter-factory.md) : [Change](-change/index.md)&gt; [presenterFactory](presenter-factory.md)(factory: [PresenterFactory](-presenter-factory/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md), [C](presenter-factory.md)&gt;): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[View](-view/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md)&gt;, [Presenter](-presenter/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md), [C](presenter-factory.md)&gt;&gt;

fun &lt;[I](presenter-factory.md) : [Intent](-intent/index.md), [S](presenter-factory.md) : [State](-state/index.md), [C](presenter-factory.md) : [Change](-change/index.md)&gt; [presenterFactory](presenter-factory.md)(factory: (intents: Flow&lt;[I](presenter-factory.md)&gt;) -&gt; [Presenter](-presenter/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md), [C](presenter-factory.md)&gt;): [ReadOnlyProperty](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-read-only-property/index.html)&lt;[View](-view/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md)&gt;, [Presenter](-presenter/index.md)&lt;[I](presenter-factory.md), [S](presenter-factory.md), [C](presenter-factory.md)&gt;&gt;
