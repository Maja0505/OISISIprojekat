package dialozi;

import java.awt.Frame;

import javax.swing.JDialog;

public class ModalniDijalog extends JDialog {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModalniDijalog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(500, 300);
		setLocationRelativeTo(parent);
		
	
	}
}
