import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class DataStructsFrame.
 */
public class DataStructsFrame extends JFrame {
	
	/**
	 * Instantiates a new data structs frame.
	 *
	 * @param title the title
	 * @param array the array
	 */
	public DataStructsFrame(String title, int [] array) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		final ArrayList<ListItem> list = arrayToList(array);
		
		final ListPanel unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);
		
		JTextField firstVal = new JTextField();
		firstVal.setSize(30, 10);
		firstVal.setAlignmentX(CENTER_ALIGNMENT);
		
		JTextField secVal = new JTextField();
		secVal.setSize(30, 10);
		secVal.setAlignmentX(CENTER_ALIGNMENT);
		
		JButton addButton = new JButton("Add to List");
		addButton.setSize(30, 10);
		addButton.setAlignmentX(CENTER_ALIGNMENT);
		
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int valA = Integer.valueOf(firstVal.getText());
				int valB = Integer.valueOf(secVal.getText());
				ListItem item = new ListItem(valA, valB);
				list.add(item);
				unorderedList.removeAll();
				unorderedList.addItems(list);
				panel.add(unorderedList);
				pack();
			}
		});
		
		JButton sortButton = new JButton("Sort List");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);

		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				orderedList.removeAll();
				boolean sorted = false;
				bubbleSort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				pack();
			}
		});

		panel.add(unorderedList);
		panel.add(firstVal);
		panel.add(secVal);
		panel.add(addButton);
		panel.add(sortButton);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	/**
	 * Array to list.
	 *
	 * @param numbers the numbers
	 * @return the array list
	 */
	private ArrayList<ListItem> arrayToList(int[] numbers) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i <= numbers.length-1; i+=2) {
			ListItem item = new ListItem(numbers[i], numbers[i+1]);
			//System.out.println(numbers[i]+ numbers[i+1]);
			list.add(item);
		}

		return list;
	}
	
	/**
	 * Bubble sort.
	 *
	 * @param list the list
	 * @return the array list
	 */
	//Bubble Sort, sorting by ValA
	public static ArrayList<ListItem> bubbleSort(ArrayList<ListItem> list) {
		int n = list.size();
 		for(int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n-1; j++) {
				if(list.get(j).getValA() < list.get(j+1).getValA()) {
					ListItem temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j + 1, temp);
				}
			}
		}
		return list;
	}
}
