package com.onelostlogician.proofs_using_generics;

import com.onelostlogician.proofs_using_generics.proofs.*;

public class TypingExamples {
    public void ok() {
        Ref.<String>build().unpack(
                new UnpackRef<String, Object>() {
                    @Override
                    public <A extends Formula<A>> Object unpacked(Ref<String, A> x) {
                        return x.set("hello, world").unpack(
                                new UnpackProof<Object>() {
                                    @Override
                                    public <F extends Formula<F>, P extends Proof<F, P>> Object unpacked(Proof<F, P> p) {
                                        System.out.println(x.get());
                                        return null;
                                    }
                                }
                        );
                    }
                }
        );
    }

    public void notOk() {
        Ref.<String>build().unpack(
                new UnpackRef<String, Object>() {
                    @Override
                    public <A extends Formula<A>> Object unpacked(Ref<String, A> x) {
                        System.out.println(x.get());
                        return null;
                    }
                }
        );
    }
}
