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
 * The Class ItemIcon.
 */
public class ItemIcon implements Icon{ 
	
	/** The Constant DEFAULT_THICKNESS. */
	private final static int DEFAULT_THICKNESS = 5;
	
	/** The Constant DEFAULT_DIAMETER. */
	private final static int DEFAULT_DIAMETER = 50;

	/** The width. */
	private int width = DEFAULT_DIAMETER;
	
	/** The height. */
	private int height = DEFAULT_DIAMETER;

	/** The thickness. */
	private int thickness = DEFAULT_THICKNESS;
	
	/** The border size. */
	private int borderSize = DEFAULT_THICKNESS;

	/** The val A. */
	private int valA;
	
	/** The val B. */
	private int valB;

	/**
	 * Instantiates a new item icon.
	 *
	 * @param valA the val A
	 * @param valB the val B
	 */
	public ItemIcon(int valA, int valB) {
		this.valA = valA;
		this.valB = valB;
	}

	/**
	 * Instantiates a new item icon.
	 *
	 * @param valA the val A
	 * @param valB the val B
	 * @param diameter the diameter
	 */
	public ItemIcon(int valA, int valB, int diameter) {
		this(valA, diameter);
		setDiameter(diameter);
	}

	/**
	 * Instantiates a new item icon.
	 *
	 * @param item the item
	 */
	public ItemIcon(ListItem item) {
		this.valA = item.getValA();
		this.valB = item.getValB();
	}

	/**
	 * Instantiates a new item icon.
	 *
	 * @param item the item
	 * @param diameter the diameter
	 */
	public ItemIcon(ListItem item, int diameter) {
		this(item);
		setDiameter(diameter);
	}

	/**
	 * Sets the diameter.
	 *
	 * @param diameter the new diameter
	 */
	public void setDiameter(int diameter) {
		width = diameter;
		height = diameter;
	}

	/**
	 * Gets the icon height.
	 *
	 * @return the icon height
	 */
	public int getIconHeight() {
		return height + 2 * DEFAULT_THICKNESS;
	}

	/**
	 * Gets the icon width.
	 *
	 * @return the icon width
	 */
	public int getIconWidth() {
		return width + 2 * DEFAULT_THICKNESS;
	}

	/**
	 * Paint icon.
	 *
	 * @param comp the comp
	 * @param g the g
	 * @param x the x
	 * @param y the y
	 */
	public void paintIcon(Component comp, Graphics g, int x, int y) {
		// get graphics context
		Graphics2D g2 = (Graphics2D) g;

		// set stroke size and color
		g2.setPaint(Color.BLACK);
		Stroke s = new BasicStroke(thickness);
		g2.setStroke(s);

		// draw white-filled circle with red border
		Ellipse2D e1 = new Ellipse2D.Float(x + borderSize, y + borderSize, height, width);
		g2.draw(e1);
		g2.setPaint(Color.WHITE);
		g2.fill(e1);
		g2.setPaint(Color.RED);

		// draw text
		Font f = new Font("Arial", Font.BOLD, 14);
		FontMetrics fm = g.getFontMetrics(f);
		String str = ((Integer) valA).toString();
		String str2 = ((Integer) valB).toString();
		Rectangle2D rect = fm.getStringBounds(str, g2);

		int textHeight = (int) rect.getHeight();
		int textWidth = (int) rect.getWidth();
		int panelHeight = getIconHeight();
		int panelWidth = getIconWidth();

		// Center text horizontally and vertically
		int offsetX = (panelWidth - textWidth) / 2;
		int offsetY = (panelHeight - textHeight) / 2 + fm.getAscent();

		// Draw the string.
		g2.setFont(f);
		g2.drawString(str + " " + str2, x + offsetX, y + offsetY);
	}
}
