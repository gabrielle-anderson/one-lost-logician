package com.onelostlogician.proofs_using_generics.proofs;

abstract class Init<T extends Formula<T>> extends Proof<Impl<False,T>,Init<T>> { }
