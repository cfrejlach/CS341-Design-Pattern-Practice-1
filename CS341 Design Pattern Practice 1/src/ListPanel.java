import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class ListPanel.
 */
public class ListPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The diameter. */
	private int diameter = 30;
	
	/** The m list. */
	private ArrayList<ListItem> mList = null;

	/**
	 * Instantiates a new list panel.
	 *
	 * @param title the title
	 */
	public ListPanel(String title) {
		super();
		mList = new ArrayList<ListItem>();
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED), title));
	}

	/**
	 * Instantiates a new list panel.
	 *
	 * @param title the title
	 * @param list the list
	 */
	public ListPanel(String title, ArrayList<ListItem> list) {
		this(title);
		addItems(list);
	}

	/**
	 * Sets the diameter.
	 *
	 * @param diameter the new diameter
	 */
	public void setDiameter(int diameter) {
		this.diameter = diameter;
		repaint();
	}

	/**
	 * Adds the items.
	 *
	 * @param list the list
	 */
	public void addItems(ArrayList<ListItem> list) {
		mList = (ArrayList<ListItem>) list.clone();
		for (ListItem item : mList)
			add(new JLabel(item.createIcon(diameter)));
	}
}