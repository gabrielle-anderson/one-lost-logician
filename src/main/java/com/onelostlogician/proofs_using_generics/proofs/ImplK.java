package com.onelostlogician.proofs_using_generics.proofs;

abstract class ImplK<F extends Formula<F>, G extends Formula<G>, P extends Proof<G,P>> extends Proof<Impl<F,G>,ImplK<F,G,P>> { }
