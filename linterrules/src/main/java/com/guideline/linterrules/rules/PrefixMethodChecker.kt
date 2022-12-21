package com.guideline.linterrules.rules

abstract class PrefixMethodChecker {
    /**
     * List of methods return class names to be checked
     */
    protected abstract val returnClassNames: List<String>
    /**
     * List of correct suffixes for given [returnClassNames]
     */
    protected abstract val prefix: List<String>
    /**
     * Specific message about why the current method name is incorrect
     */
    abstract val message: String

    fun isMethodReturningType(returnClassName: String): Boolean =
        returnClassNames.contains(returnClassName)

    fun checkMethodNameSuffix(methodName: String): Boolean =
        prefix.any { methodName.endsWith(it) }
}