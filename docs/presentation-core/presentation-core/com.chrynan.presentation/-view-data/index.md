//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[ViewData](index.md)



# ViewData  
 [common] interface [ViewData](index.md)

Represents a model that contains the data required for a UI. Note a [State](../-state/index.md) is a [ViewData](index.md) but a [ViewData](index.md) isn't necessarily a [State](../-state/index.md). For instance, each item in a UI list should be represented as a [ViewData](index.md) but it might not be preferable to have it as a [State](../-state/index.md). Instead, the [State](../-state/index.md) could represent the Screen UI and could contain the list item [ViewData](index.md)s.



Note that a [ViewData](index.md) should not contain any logic. A [ViewData](index.md) is typically an immutable data class containing necessary information for displaying a UI. Typically, fields shouldn't be updated or altered on a [ViewData](index.md) but instead new updated [ViewData](index.md) objects should be created and the whole [State](../-state/index.md) should be updated with these new objects. This way it conforms to the uni-directional paradigm.



Note that there is some terminology conflation between this class "ViewData" and components in other popular frameworks and design patterns, such as, the Android Architecture Component's "ViewModel" class. Here a [ViewData](index.md) should perform no logic, and just be a model representation of a UI.

   


## Types  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/ViewData.Companion///PointingToDeclaration/"></a>[Companion](-companion/index.md)| <a name="com.chrynan.presentation/ViewData.Companion///PointingToDeclaration/"></a>[common]  <br>Content  <br>object [Companion](-companion/index.md)  <br><br><br>|


## Properties  
  
|  Name |  Summary | 
|---|---|
| <a name="com.chrynan.presentation/ViewData/uniqueId/#/PointingToDeclaration/"></a>[uniqueId](unique-id.md)| <a name="com.chrynan.presentation/ViewData/uniqueId/#/PointingToDeclaration/"></a> [common] open val [uniqueId](unique-id.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)A unique identifier for this [ViewData](index.md).   <br>|


## Inheritors  
  
|  Name | 
|---|
| <a name="com.chrynan.presentation/State///PointingToDeclaration/"></a>[State](../-state/index.md)|

