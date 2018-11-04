/**
 * Klass som avnänds för att kunna ha ett ID/Index samt ett namn i dropdownmenyer i form av JComboBox. gjord av Marcus Vretling Pistelli
 */

package view;

public class ComboBoxItem {
	private int index;
	private String name;
	
	public ComboBoxItem(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
