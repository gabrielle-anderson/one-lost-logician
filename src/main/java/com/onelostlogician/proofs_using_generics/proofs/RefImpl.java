package com.onelostlogician.proofs_using_generics.proofs;

public class RefImpl<S> extends Ref<S,True> {
    private S x;

    public Proof<True, ?> set(S x) {
        this.x = x;
        return Proof.build();
    }

    public S get() {
        return this.x;
    }
}

