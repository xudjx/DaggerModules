package com.xud.base.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 *
 * AppScope 是 app 级别的注入，用于标识模块中的AppComponent
 */
@Scope
@Retention(RUNTIME)
public @interface AppScope {
}
