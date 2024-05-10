import java.awt.EventQueue;
import java.lang.NumberFormatException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
 class MilestoneCalcGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Ms1input;
	private JTextField Ms2input;
	private JTextField TAinput;
	private JTextField ansTextField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MilestoneCalcGUI frame = new MilestoneCalcGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MilestoneCalcGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Ms1input = new JTextField();
		Ms1input.setBounds(227, 63, 86, 20);
		contentPane.add(Ms1input);
		Ms1input.setColumns(10);
		
		Ms2input = new JTextField();
		Ms2input.setBounds(227, 94, 86, 20);
		Ms2input.setColumns(10);
		contentPane.add(Ms2input);
		
		TAinput = new JTextField();
		TAinput.setBounds(227, 125, 86, 20);
		TAinput.setColumns(10);
		contentPane.add(TAinput);
		
		JButton calculateBttn = new JButton("Calculate");
		calculateBttn.setBounds(224, 165, 89, 23);
		calculateBttn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	// Initialize variables
		        int ms1, ms2, ta, ans;
		        int[] ms1Range = {0, 25};
		        int[] ms2Range = {0, 40};
		        int[] taRange = {0, 35};

		        // Check for empty fields
		        if (Ms1input.getText().trim().isEmpty() || 
		            Ms2input.getText().trim().isEmpty() || 
		            TAinput.getText().trim().isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Please fill in all fields");
		            return;
		        }

		        // Check for integer values
		        try {
		            ms1 = Integer.parseInt(Ms1input.getText().trim());
		            ms2 = Integer.parseInt(Ms2input.getText().trim());
		            ta = Integer.parseInt(TAinput.getText().trim());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Please enter an integer value");
		            return; //
		        }

		        // Check if within range
		        if (ms1 < ms1Range[0] || ms1 > ms1Range[1] || 
		            ms2 < ms2Range[0] || ms2 > ms2Range[1] || 
		            ta < taRange[0] || ta > taRange[1]) {
		            JOptionPane.showMessageDialog(null, "Please enter values within the specified range:\n"
		            		+ "Milestone 1: 0 - 25\n"
		            		+ "Milestone 2: 0 - 40\n"
		            		+ "Terminal Assessment: 0 - 35");
		            return;
		        }

		        // Calculate answer
		        ans = ms1 + ms2 + ta;
		        ansTextField.setText(Integer.toString(ans));
		    }
		});
		contentPane.add(calculateBttn);
		
		JLabel lblNewLabel = new JLabel("Milestone 1 :");
		lblNewLabel.setBounds(136, 66, 76, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMilestone = new JLabel("Milestone 2 :");
		lblMilestone.setBounds(136, 97, 76, 14);
		contentPane.add(lblMilestone);
		
		JLabel lblNewLabel_1_1 = new JLabel("Terminal Assessment :");
		lblNewLabel_1_1.setBounds(73, 128, 144, 14);
		contentPane.add(lblNewLabel_1_1);
		
		ansTextField = new JTextField();
		ansTextField.setBounds(202, 200, 132, 33);
		contentPane.add(ansTextField);
		ansTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Your FINAL grade is :");
		lblNewLabel_1.setBounds(73, 209, 119, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please Enter Your Grade:");
		lblNewLabel_2.setBounds(103, 11, 244, 29);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("/ 25");
		lblNewLabel_3.setBounds(323, 66, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("/ 40");
		lblNewLabel_3_1.setBounds(323, 97, 46, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("/ 35");
		lblNewLabel_3_1_1.setBounds(323, 128, 46, 14);
		contentPane.add(lblNewLabel_3_1_1);
			
	}	
}
