package com.onelostlogician.proofs_using_generics.proofs;

abstract class Comp<F extends Formula<F>, G extends Formula<G>, H extends Formula<H>, P extends Proof<Impl<F,G>, P>,
        Q extends Proof<Impl<G,H>, Q>>
        extends Proof<Impl<F,H>,Comp<F,G,H,P,Q>> { }
