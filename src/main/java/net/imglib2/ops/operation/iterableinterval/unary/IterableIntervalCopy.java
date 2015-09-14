/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2015 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, Max Planck Institute
 * of Molecular Cell Biology and Genetics, and University of Konstanz.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package net.imglib2.ops.operation.iterableinterval.unary;

import net.imglib2.IterableInterval;
import net.imglib2.ops.img.UnaryOperationAssignment;
import net.imglib2.ops.operation.UnaryOperation;
import net.imglib2.ops.operation.real.unary.RealCopy;
import net.imglib2.type.numeric.RealType;

/**
 *
 * @author Martin Horn (University of Konstanz)
 * @deprecated Use net.imagej.ops instead.
 */
@Deprecated
public class IterableIntervalCopy<T extends RealType<T>> implements
                UnaryOperation<IterableInterval<T>, IterableInterval<T>> {

        /**
         * {@inheritDoc}
         */
        @Override
        public IterableInterval<T> compute(IterableInterval<T> op,
                        IterableInterval<T> r) {
                new UnaryOperationAssignment<T, T>(new RealCopy<T, T>())
                                .compute(op, r);
                return r;
        }

        @Override
        public UnaryOperation<IterableInterval<T>, IterableInterval<T>> copy() {
                return new IterableIntervalCopy<T>();
        }
}
