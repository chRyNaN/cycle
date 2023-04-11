package com.chrynan.presentation.annotation

import com.chrynan.presentation.State
import com.chrynan.presentation.Intent
import com.chrynan.presentation.Action
import com.chrynan.presentation.ViewModel
import com.chrynan.presentation.Reducer
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass

/**
 * Annotates a function that will act as an [Action.perform] function. A processor will register this annotated
 * component and other related annotated components to generate [Intent]s, [Action]s, [Reducer]s, and a [ViewModel].
 * Every return type for a [Perform] annotated function for a particular [State] must have an associated [Reduce]
 * annotated function that takes in that type as a parameter, otherwise an exception will be thrown.
 *
 * **Note:** This annotation is experimental and may change or be removed in the future.
 *
 * ## Function Definition
 *
 * ### Parameters
 *
 * The parameters of the annotated function will be used to generate an [Intent] that can be passed to the generated
 * [ViewModel]. The parameters of the annotated function can be of any type as they will be provided by the call-site
 * which instantiates the generated [Intent]. There may be one [forState] [State] type parameter that represents the
 * current state.
 *
 * ### Extension Receiver
 *
 * The annotated function may contain an extension receiver of the [forState] [State] type, which will represent the
 * current state value. An exception will be thrown if the extension receiver is another type. If there is already a
 * [State] parameter, an exception will be thrown.
 *
 * ### Returns Type
 *
 * The return type of the annotated function can any type including [Flow]. If the return type is [Flow], then the
 * [Flow] will be subscribed to in the generated [ViewModel] and the emitted values will be passed to the generated
 * [Reducer]. If the return type is not a [Flow], then the value will be passed to the generated [Reducer].
 *
 * ### Member Function
 *
 * The annotated function may be a member of a class, interface, or object. The generated [ViewModel] will take the
 * component the function is a member of as a constructor parameter. If the component the function is a member of is an
 * [Action], then the [Action] will be used directly in the generated [ViewModel] instead of generating a wrapper
 * [Action].
 *
 * ## Example
 *
 * ```kotlin
 * sealed class HomeState: State { ... }
 *
 * @Perform(forState = HomeState::class)
 * fun HomeState.load(cursor: String, direction: Direction = Direction.AFTER, count: UInt = 25u): Flow<HomeData> { ... }
 *
 * @Reduce(forState = HomeState::class)
 * fun HomeState.reduce(data: HomeData): HomeState { ... }
 *
 * @Compose
 * fun HomeScreen(viewModel: HomeStateViewModel) { ... } // HomeStateViewModel is auto-generated for you.
 * ```
 *
 * @property [forState] The base [State] class that this function generates an action for. This must point to the base
 * [State] class and not specific inheritors, otherwise behavior is undefined.
 *
 * @property [name] The name of the associated generated [Action] and [Intent] for this function. If this value is
 * blank, then the name will be derived from the function and/or encapsulating component name.
 */
@ExperimentalPresentationApi
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
annotation class Perform(
    val forState: KClass<State>,
    val name: String = ""
)
