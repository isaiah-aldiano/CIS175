/**
 * @author Isaiah Aldiano - iealdiano
 * CIS175 - Spring 2023
 * Mar 10, 2023
 */
package dmacc.beans;

import jakarta.persistence.Embeddable;

@Embeddable
public class membership {
	private String typeOf;
	
	public membership() {
		
	}
	
	public membership(String typeOf) {
		this.typeOf = typeOf;
	}

	public String getTypeOf() {
		return typeOf;
	}

	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}

	@Override
	public String toString() {
		return "membership [typeOf=" + typeOf + "]";
	}
}
