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

package net.imglib2.meta;

/**
 * Abstract base class for {@link CalibratedAxis}.
 * 
 * @author Barry DeZonia
 * @deprecated Use {@link net.imagej.axis.AbstractCalibratedAxis} instead.
 */
@Deprecated
public abstract class AbstractCalibratedAxis extends DefaultTypedAxis implements
	CalibratedAxis
{

	private String unit;

	public AbstractCalibratedAxis(final AxisType type) {
		super(type);
	}

	public AbstractCalibratedAxis(final AxisType type, final String unit) {
		super(type);
		setUnit(unit);
	}

	// -- CalibratedAxis methods --

	@Override
	public String unit() {
		return unit;
	}

	@Override
	public void setUnit(final String unit) {
		this.unit = unit;
	}

	@Override
	public double averageScale(final double rawValue1, final double rawValue2) {
		return (calibratedValue(rawValue2) - calibratedValue(rawValue1)) /
			(rawValue2 - rawValue1);
	}

	// -- Object methods --

	@Override
	public int hashCode() {
		return hashString(this).hashCode();
	}

	@Override
	public boolean equals(final Object o) {
		if (!(o instanceof CalibratedAxis)) return false;
		final CalibratedAxis other = (CalibratedAxis) o;
		return hashString(this).equals(hashString(other));
	}

	// -- Helper methods --

	/** Computes a likely-to-be-unique string for this axis. */
	private String hashString(final CalibratedAxis axis) {
		return axis.type() + "\n" + axis.unit() + "\n" + axis.particularEquation();
	}

}
