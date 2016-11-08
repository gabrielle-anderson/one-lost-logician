package com.onelostlogician.proofs_using_generics.proofs;

public abstract class Impl<S extends Formula<S>, T extends Formula<T>> extends Formula<Impl<S,T>> { }
