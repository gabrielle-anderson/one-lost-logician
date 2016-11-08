package com.onelostlogician.proofs_using_generics.proofs;

abstract class Id<F extends Formula<F>> extends Proof<Impl<F,F>,Id<F>> { }
