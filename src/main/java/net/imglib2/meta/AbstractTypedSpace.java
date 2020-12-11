/*
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2020 ImageJ developers.
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

package net.imglib2.meta;

import java.util.List;

import net.imglib2.AbstractAnnotatedSpace;

/**
 * Abstract base class for {@link TypedSpace}.
 * 
 * @author Curtis Rueden
 * @deprecated Use {@link net.imagej.space.AbstractTypedSpace} instead.
 */
@Deprecated
public abstract class AbstractTypedSpace<A extends TypedAxis> extends
	AbstractAnnotatedSpace<A> implements TypedSpace<A>
{

	public AbstractTypedSpace(final int numDims) {
		super(numDims);
	}

	public AbstractTypedSpace(final A... axes) {
		super(axes);
	}

	public AbstractTypedSpace(final List<A> axes) {
		super(axes);
	}

	// -- TypedSpace methods --

	@Override
	public int dimensionIndex(final AxisType axisType) {
		for (int d = 0; d < numDimensions(); d++) {
			if (axis(d).type() == axisType) return d;
		}
		return -1;
	}

}
