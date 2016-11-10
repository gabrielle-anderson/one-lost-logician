package com.onelostlogician.proofs_using_generics;

import com.onelostlogician.proofs_using_generics.proofs.*;

public class TypingExamples {
    public void ok() {
        Ref.<String>build().unpack(
                new UnpackRef<String, Object>() {
                    @Override
                    public <A extends Formula<A>> Object unpacked(Ref<String, A> r) {
                        return r.set("hello, world").unpack(
                                new UnpackProof<A,Object>() {
                                    @Override
                                    public Object unpacked(Proof x) {
                                        String s = r.get();
                                        System.out.println(s);
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
                    public <A extends Formula<A>> Object unpacked(Ref<String, A> r) {
                        String s = r.get();
                        System.out.println(s);
                        return null;
                    }
                }
        );
    }
}
