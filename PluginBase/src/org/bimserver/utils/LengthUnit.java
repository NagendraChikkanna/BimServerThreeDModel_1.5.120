package org.bimserver.utils;

import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;

public enum LengthUnit {
	METER{
		@Override
		public float toMeter(float v) {
			return v;
		}

		@Override
		public double toMeter(double v) {
			return v;
		}
		
		@Override
		public float toMilliMeter(float v) {
			return v * 1000;
		}

		@Override
		public double toMilliMeter(double v) {
			return v * 1000;
		}
		
		@Override
		public float convert(float v, LengthUnit modelLengthUnit) {
			return modelLengthUnit.toMeter(v);
		}

		@Override
		public double convert(double v, LengthUnit modelLengthUnit) {
			return modelLengthUnit.toMeter(v);
		}
	},
	MILLI_METER{
		@Override
		public float toMeter(float v) {
			return v / 1000;
		}
		
		@Override
		public float toMilliMeter(float v) {
			return v;
		}

		@Override
		public double toMeter(double v) {
			return v / 1000;
		}
		
		@Override
		public double toMilliMeter(double v) {
			return v;
		}

		@Override
		public float convert(float v, LengthUnit modelLengthUnit) {
			return modelLengthUnit.toMilliMeter(v);
		}

		@Override
		public double convert(double v, LengthUnit modelLengthUnit) {
			return modelLengthUnit.toMilliMeter(v);
		}
	};

	public static LengthUnit fromPrefix(IfcSIPrefix prefix) {
		switch (prefix) {
		case NULL:
			return METER;
		case MILLI:
			return MILLI_METER;
		}
		return null;
	}

	public AreaUnit toAreaUnit() {
		switch (this) {
		case MILLI_METER:
			return AreaUnit.SQUARED_MILLI_METER;
		case METER:
			return AreaUnit.SQUARED_METER;
		}
		return null;
	}

	public VolumeUnit toVolumeUnit() {
		switch(this) {
		case METER: return VolumeUnit.CUBIC_METER;
		case MILLI_METER: return VolumeUnit.CUBIC_MILLI_METER;
		}
		return null;
	}

	public float convert(float v, LengthUnit modelLengthUnit) {
		throw new AbstractMethodError();
	}

	public double convert(double v, LengthUnit modelLengthUnit) {
		throw new AbstractMethodError();
	}
	
	public float toMeter(float v) {
		throw new AbstractMethodError();
	}

	public float toMilliMeter(float v) {
		throw new AbstractMethodError();
	}

	public double toMeter(double v) {
		throw new AbstractMethodError();
	}
	
	public double toMilliMeter(double v) {
		throw new AbstractMethodError();
	}
}
