package com.chrynan.presentation.annotation

import com.chrynan.presentation.*
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass

/**
 * Annotates a function that will act as an [Reducer.reduce] function. A processor will register this annotated
 * component and other related annotated components to generate [Intent]s, [Change]s, [Action]s, [Reducer]s, and a
 * [ViewModel]. Every return type for a [Perform] annotated function for a particular [State] must have an associated
 * [Reduce] annotated function that takes in that type as a parameter, otherwise an exception will be thrown.
 *
 * **Note:** This annotation is experimental and may change or be removed in the future.
 *
 * ## Function Definition
 *
 * ### Parameters
 *
 * There may be up to two parameters: An optional [State] parameter representing the current state and a required
 * change parameter which must be the output (or type emitted in case of a [Flow]) of a [Perform] annotated function.
 *
 * ### Extension Receiver
 *
 * The annotated function may contain an extension receiver of the [forState] [State] type (or subtype), which will
 * represent the current state value. An exception will be thrown if the extension receiver is another type. If there
 * is already a [State] parameter, an exception will be thrown.
 *
 * ### Returns Type
 *
 * The return type of the annotated function must be the [forState] [State] type or a subtype of it, otherwise an
 * exception will be thrown. The return type may be nullable.
 *
 * ### Member Function
 *
 * The annotated function may be a member of a class, interface, or object. The generated [ViewModel] will take the
 * component the function is a member of as a constructor parameter.
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
 */
@ExperimentalPresentationApi
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
annotation class Reduce(val forState: KClass<State>)
