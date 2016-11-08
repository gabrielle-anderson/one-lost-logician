package com.onelostlogician.proofs_using_generics.proofs;

public abstract class And<S extends Formula<S>, T extends Formula<T>> extends Formula<And<S,T>> { }
