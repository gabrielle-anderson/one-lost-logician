package com.onelostlogician.proofs_using_generics.proofs;

abstract class Term<F extends Formula<F>> extends Proof<Impl<F,True>,Term<F>> { }
