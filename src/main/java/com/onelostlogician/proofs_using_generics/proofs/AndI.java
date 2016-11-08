package com.onelostlogician.proofs_using_generics.proofs;

abstract class AndI<F extends Formula<F>, G extends Formula<G>, P extends Proof<F,P>, Q extends Proof<G,Q>> extends
        Proof<And<F,G>,AndI<F,G,P,Q>> { }
