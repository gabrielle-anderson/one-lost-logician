package com.onelostlogician.proofs_using_generics.proofs;

public class Proof<F extends Formula<F>, P extends Proof<F, P>> {
    static public <F extends Formula<F>, P extends Proof<F, P>> Proof<F,P> build() {
        return new Proof<>();
    }

    public<S> S unpack(UnpackProof<F, S> u) {
        return u.unpacked(this);
    }
}
