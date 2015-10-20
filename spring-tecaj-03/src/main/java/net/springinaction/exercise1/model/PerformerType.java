package net.springinaction.exercise1.model;

public enum PerformerType {
	ACTOR("ACTOR"), SINGER("SINGER"), BAND("BAND"), COMMEDIAN("COMMEDIAN");
	
	private String name;
	
	PerformerType(String p_type) {
		setName(p_type);
	}
	
	public static PerformerType getEnumByName(final String p_enumName) {
		for (int i = 0; i < PerformerType.values().length; ++i) {
			PerformerType result = PerformerType.values()[i];
			if (result.getName().equals(p_enumName)) {
				return result;
			}
		}
		return null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
