import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.Icon;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItem.
 */
public class ListItem implements Comparable<ListItem> {
	
	/** The val A. */
	private int valA;
	
	/** The val B. */
	private int valB;

	/**
	 * Instantiates a new list item.
	 *
	 * @param valA the val A
	 * @param valB the val B
	 */
	public ListItem(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	/**
	 * Gets the val A.
	 *
	 * @return the val A
	 */
	public int getValA() {
		return valA;
	}

	/**
	 * Gets the val B.
	 *
	 * @return the val B
	 */
	public int getValB() {
		return valB;
	}
	
	/**
	 * Creates the icon.
	 *
	 * @param diameter the diameter
	 * @return the icon
	 */
	public Icon createIcon(int diameter) {
		return new ItemIcon(this, diameter);
	}

	/**
	 * Compare to.
	 *
	 * @param o the o
	 * @return the int
	 */
	@Override
	public int compareTo(ListItem o) {
		return 0;
	}

}