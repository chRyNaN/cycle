//[presentation-core](../../../index.md)/[com.chrynan.presentation](../index.md)/[Action](index.md)/[perform](perform.md)



# perform  
[common]  
Content  
abstract fun [perform](perform.md)(intent: [I](index.md), state: [S](index.md)?): Flow<[C](index.md)>  
More info  


Converts the provided [intent](perform.md) of type [I](index.md) into a Flow of type [C](index.md). This means an [Intent](../-intent/index.md) can cause multiple [Change](../-change/index.md)s to be emitted ("StartedLoading", "FinishedLoading", etc).



## Parameters  
  
common  
  
| | |
|---|---|
| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>intent| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a><br><br>The intent to perform an [Action](index.md).<br><br>|
| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a>state| <a name="com.chrynan.presentation/Action/perform/#TypeParam(bounds=[com.chrynan.presentation.Intent])#TypeParam(bounds=[com.chrynan.presentation.State])?/PointingToDeclaration/"></a><br><br>The current state being displayed.<br><br>|
  
  



