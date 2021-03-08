//Dhrumil Patel
//Life Simulation GUI
//June 16, 2020
//ICS4U1

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Life Simulation GUI for CGOL
 */
public class PDLifeSimulationGUI extends JFrame implements ActionListener, ChangeListener {
	static Colony colony = new Colony(0.1);
	static JSlider speedSldr = new JSlider();
	static Timer t;

	JTextField inputName = new JTextField(25);
	JComboBox X = new JComboBox(); // top left x coordinate
	JComboBox Y = new JComboBox(); // top left y coordinate
	JComboBox rows = new JComboBox(); // number of rows
	JComboBox columns = new JComboBox(); // number of columns
	JComboBox success = new JComboBox();

	int Xc, Yc, r, c, s;

	/**
	 * Creates a PDPDLifeSimulationGUI to show the program
	 */
	public PDLifeSimulationGUI() {
		JButton simulateBtn = new JButton("Simulate");
		simulateBtn.addActionListener(this);
		JButton stopBtn = new JButton("Stop");
		stopBtn.addActionListener(this);
		JButton saveBtn = new JButton("Save");
		saveBtn.addActionListener(this);
		JButton loadBtn = new JButton("Load");
		loadBtn.addActionListener(this);
		JButton popBtn = new JButton("Populate");
		popBtn.addActionListener(this);
		JButton eraBtn = new JButton("Eradicate");
		eraBtn.addActionListener(this);

		inputName.setText("file name:");

		speedSldr.addChangeListener(this);

		X.addItem("x-coordinate?");
		for (int i = 1; i <= colony.getX(); i++) {
			X.addItem(i);
		}

		Y.addItem("y-coordinate?");
		for (int i = 1; i <= colony.getY(); i++) {
			Y.addItem(i);
		}

		rows.addItem("columns?");
		for (int i = 1; i <= colony.getX(); i++) {
			rows.addItem(i);
		}

		columns.addItem("rows?");
		for (int i = 1; i <= colony.getY(); i++) {
			columns.addItem(i);
		}

		success.addItem("success rate?");
		for (int i = 5; i <= 100; i += 5) {
			success.addItem(i + "%");
		}

		JPanel content = new JPanel(); // Create a content pane
		content.setLayout(new BorderLayout()); // Use BorderLayout for panel
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout()); // Use FlowLayout for input area
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout());// second row of buttons
		DrawArea board = new DrawArea(500, 500);

		north.add(simulateBtn);
		north.add(speedSldr);
		north.add(stopBtn);
		north.add(inputName);
		north.add(saveBtn);
		north.add(loadBtn);
		center.add(X);
		center.add(Y);
		center.add(rows);
		center.add(columns);
		center.add(success);
		center.add(popBtn);
		center.add(eraBtn);

		content.add(north, "North"); // Input area
		content.add(center, "Center");
		content.add(board, "South"); // Output area

		setContentPane(content);
		pack();
		setTitle("Life Simulation Demo");
		setSize(850, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Center window.
	}

	/**
	 * Required to implement this
	 * 
	 * @param e ChangeEvent (slider change)
	 */
	public void stateChanged(ChangeEvent e) {
		if (t != null)
			t.setDelay(400 - 4 * speedSldr.getValue()); // 0 to 400 ms
	}

	/**
	 * Based on a actionPerformed
	 * 
	 * @param e ActionEvent, like a button press
	 */
	public void actionPerformed(ActionEvent e) {
		// reset values
		Xc = colony.getX() + 100;
		Yc = colony.getY() + 100;
		r = 0;
		c = 0;
		s = 0;

		// buttons
		if (e.getActionCommand().equals("Simulate")) {
			Movement moveColony = new Movement(colony); // ActionListener
			t = new Timer(200, moveColony); // timer
			t.start(); // start simulation + timer
		} else if (e.getActionCommand().equals("Stop")) {
			// pause simulation
			t.stop();
		} else if (e.getActionCommand().equals("Save")) {
			// saves file under inputed name or returns error message
			try {
				colony.save(inputName.getText());
				inputName.setText("Successfully saved!");
			} catch (IOException e1) {
				inputName.setText("Error: please try again.");
			}
		} else if (e.getActionCommand().equals("Load")) {
			// load chosen txt files
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("txt Files", "txt");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					colony.load(chooser.getSelectedFile());
				} catch (Exception e1) {
					inputName.setText("Invalid File");
				}
			}

		} else if (e.getActionCommand().equals("Populate")) {
			try {
				// the miracle of life
				Xc = (int) X.getSelectedItem() - 1;
				Yc = (int) Y.getSelectedItem() - 1;
				r = (int) rows.getSelectedItem();
				c = (int) columns.getSelectedItem();
				s = (int) (5 * success.getSelectedIndex());
				colony.populate(Xc, Yc, r, c, s);
			} catch (Exception f) {

			}
		} else if (e.getActionCommand().equals("Delete")) {
			try {
				// ending the miracle of life
				Xc = (int) X.getSelectedItem() - 1;
				Yc = (int) Y.getSelectedItem() - 1;
				r = (int) rows.getSelectedItem();
				c = (int) columns.getSelectedItem();
				s = (int) (5 * success.getSelectedIndex());
				colony.eradicate(Xc, Yc, r, c, s);
			} catch (Exception f) {

			}
		}

		repaint(); // refresh display
	}

	/**
	 * DrawArea class
	 */
	class DrawArea extends JPanel {
		/**
		 * Creates a draw area
		 * 
		 * @param width  The given width of the window
		 * @param height The given height of the window
		 */
		public DrawArea(int width, int height) {
			this.setPreferredSize(new Dimension(width, height)); // size
		}

		/**
		 * What to paint on
		 * 
		 * @param g The graphics object
		 */
		public void paintComponent(Graphics g) {
			colony.show(g);
		}
	}

	/**
	 * Movement class
	 */
	class Movement implements ActionListener {
		private Colony colony;

		/**
		 * Creates a Movement object based on a given Colony
		 * 
		 * @param col The given Colony
		 */
		public Movement(Colony col) {
			colony = col;
		}

		/**
		 * Take another life step
		 * 
		 * @param e The actionevent
		 */
		public void actionPerformed(ActionEvent e) {
			colony.advance();
			repaint();
		}
	}

	public static void main(String[] args) {
		PDLifeSimulationGUI window = new PDLifeSimulationGUI();
		window.setVisible(true);
	}
}

/**
 * Colony Class for CGoL
 */
class Colony {
	private boolean grid[][];

	/**
	 * Creates a Colony given a life density
	 * 
	 * @param density The given life density
	 */
	public Colony(double density) {
		grid = new boolean[100][100];
		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[0].length; col++)
				grid[row][col] = Math.random() < density;
	}

	/**
	 * Draw rectangles to the given graphics object
	 * 
	 * @param g The given graphics object
	 */
	public void show(Graphics g) {
		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col]) // life
					g.setColor(Color.black);
				else
					g.setColor(Color.white);
				g.fillRect(col * 5 + 2, row * 5 + 2, 5, 5); // draw life form
			}
	}

	/**
	 * Get the number of rows (Assume grids all have the same length)
	 * 
	 * @return The number of rows
	 */
	public int getX() {
		return grid[0].length;
	}

	/**
	 * Get the number of columns
	 * 
	 * @return The number of columns
	 */
	public int getY() {
		return grid.length;
	}

	/**
	 * Find if a given cell will live or die
	 * 
	 * @param row The cell's row
	 * @param col The cell's col
	 * @return Whether the cell will live
	 */
	public boolean live(int row, int col) {
		// count number of lives
		int neighbours = 0;
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c]) {
					neighbours++;
				}
			}
		}
		if (grid[row][col]) {
			neighbours = neighbours - 1;
		}
		// determine survival/bye bye
		if (grid[row][col] && neighbours > 1 && neighbours < 4) {
			return true;
		} else if (!grid[row][col] && neighbours == 3) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Take one step forward in generations
	 */
	public void advance() {
		boolean nextGen[][] = new boolean[grid.length][grid[0].length]; // create next generation of life forms
		for (int row = 0; row < grid.length; row++)
			for (int col = 0; col < grid[0].length; col++)
				nextGen[row][col] = live(row, col); // determine life/death status
		grid = nextGen; // update life forms
	}

	/**
	 * Load from a given file
	 * 
	 * @param f The given file
	 * @throws FileNotFoundException If the file can't be found
	 */
	public void load(File f) throws FileNotFoundException {
		// rows + columns value
		int rows = 0;
		int cols = 0;

		Scanner sc = new Scanner(f);
		// count number of lines
		while (sc.hasNextLine()) {
			rows++;
			sc.nextLine();
		}
		sc.close();

		// count columns
		Scanner s2 = new Scanner(f);
		// removes spaces + gets length
		cols = s2.nextLine().replaceAll("\\s+", "").length();
		s2.close();

		// create 2D array
		int[][] file = new int[rows][cols];

		// read elements from file into array
		Scanner s3 = new Scanner(f);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				file[r][c] = s3.nextInt();
			}
		}
		s3.close();

		// creates final array
		grid = new boolean[rows][cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (file[r][c] == 1) {
					grid[r][c] = true;
				} else {
					grid[r][c] = false;
				}
			}
		}
	}

	/**
	 * Save the grid to a file
	 * 
	 * @param name The name of the file to save
	 * @throws IOException Any other issues
	 */
	public void save(String name) throws IOException {
		String temp = "";
		// run through elements
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c]) {
					temp += "1 "; // survival!
				} else {
					temp += "0 "; // bye bye!
				}
			}
			temp += "\n";
		}

		File game = new File("C:" + name + ".txt");

		// create new file
		try {
			game.createNewFile();
		} catch (IOException e) {

		}
		FileWriter fw = new FileWriter(game);
		fw.write(temp);// store
		fw.close();
	}

	/**
	 * Adding live cells into the grid
	 * 
	 * @param Xc Start X position
	 * @param Yc Start Y position
	 * @param X  End X position
	 * @param Y  End Y position
	 * @param s  Given density
	 */
	public void populate(int Xc, int Yc, int X, int Y, int s) {
		// make s a double to use math.random
		double ds = s / 100.0;
		// X tiles right from starting x coordinate, Y tiles down from starting y
		// coordinate
		for (int c = Xc; c < Xc + X; c++) {
			for (int r = Yc; r < Yc + Y; r++) {
				if (r < grid.length && c < grid[0].length && !grid[r][c] && Math.random() < ds) {
					grid[r][c] = true;
				}
			}
		}
	}

	/**
	 * Killing live cells in a range
	 * 
	 * @param Xc Start X position
	 * @param Yc Start Y position
	 * @param X  End X position
	 * @param Y  End Y position
	 * @param s  Density
	 */
	public void eradicate(int Xc, int Yc, int X, int Y, int s) {
		// make s a double to use math.random
		double ds = s / 100.0;
		// X tiles right from starting x coordinate, Y tiles down from starting y
		// coordinate
		for (int c = Xc; c < Xc + X; c++) {
			for (int r = Yc; r < Yc + Y; r++) {
				if (r < grid.length && c < grid[0].length && grid[r][c] && Math.random() < ds)
					grid[r][c] = false;
			}
		}
	}
}